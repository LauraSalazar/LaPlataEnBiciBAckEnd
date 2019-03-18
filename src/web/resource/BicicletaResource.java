package web.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import dbaccess.dto.BicicletaDTO;
import model.Estacion;
import model.Usuario;
import web.service.BicicletaService;
import web.service.EstacionService;
import web.service.PrestamoService;
import web.service.UsuarioService;

@Path ("/Bicicleta")
public class BicicletaResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	
	BicicletaService bicicletaService;
	PrestamoService prestamoService;

	public BicicletaResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		bicicletaService = new BicicletaService();
		prestamoService = new PrestamoService();
	}
	
	public BicicletaResource() {
		super();
		bicicletaService = new BicicletaService();
		prestamoService = new PrestamoService();
	}
	

	@GET
	@Path("/{bicicletaId}")
	public Response getBicicleta(@PathParam("bicicletaId") Integer id) {
		Response response;
		BicicletaDTO bicicletaDTO = bicicletaService.getBicicleta(id);
		try {
			if (bicicletaDTO == null) {
				response = Response.status(204).build();
			} else {
				response = Response.ok(bicicletaDTO).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}
	

	// Crea una bicicleta
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createBicicleta(BicicletaXml biciXml) {
		Response response = null;
		System.out.println("Entro el en CrearBicicleta");
		//BicicletaXml biciXml = bici.getValue();
		try {
            System.out.println("bicicleta.getId: " + biciXml.getId());
            System.out.println("bicicleta.getFechaIngreso: " + biciXml.getFechaIngreso());
            System.out.println("bicicleta.getEstado: " + biciXml.getEstado());
            System.out.println("bicicleta.getNumeroCuadro: " + biciXml.getNumeroCuadro());            
            System.out.println("bicicleta.getUbicacionActual: " + biciXml.getUbicacionActual());
            System.out.println("bicicleta.getIdEstacion" + biciXml.getIdEstacion());
            
            EstacionService estacionService = new EstacionService();
            Estacion estacionBicicleta = estacionService.findById(Integer.valueOf(biciXml.getIdEstacion()));
            UsuarioService usuarioService = new UsuarioService();
            System.out.println("bicicleta.codigoEstacion:" + estacionBicicleta);
            //String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta, String estado, String ubicacionLatitud, String ubicacionLongitud, Integer cantidad
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Date d = new Date();
            Integer id2 = bicicletaService.create(biciXml.getNumeroCuadro(),d.toString(),biciXml.getEstado(),estacionBicicleta);
			
			response = Response.ok(200).
				entity(String.valueOf(id2)).
					build();
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(500).build();
		}
		return response;
	}
	
	//Modificar una bicicleta
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modificar")
	public Response updateUsuario(BicicletaXml bici) {
		Response response = null;
		try {
            //Aca tendria que validar si existe la estacion
//			EstacionService estacionService = new EstacionService();
//			Estacion estacion = estacionService.findById(idEstacion);
			BicicletaDTO bicicletaDTO = bicicletaService.getBicicleta(bici.getId());
			if (bicicletaDTO != null) {
				if (bicicletaDTO.getEstado().equals("Denunciada") && !bici.getEstado().equals("Denunciada")) {
					//busco el prestamo asociado y le seteo fecha fin
					prestamoService.findRelatedAndUpdate(bici.getId());	
		
				}
				bicicletaService.update(bici.getId(), bici.getNumeroCuadro(), bici.getFechaIngreso(), bici.getEstado(), bici.getIdEstacion()); 
				bicicletaDTO = bicicletaService.getBicicleta(bici.getId());
				response = Response.ok(bicicletaDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(500).build();
		}
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletas")
	public Response getBicicletas() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAll();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasOrdenUbicacion")
	public Response getBicicletasOrdenUbicacion() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllOrdenUbicacion();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasOrdenEstado")
	public Response getBicicletasOrdenEstado() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllOrdenEstado();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasOrdenNumeroCuadro")
	public Response getBicicletasOrdenNumeroCuadro() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllOrdenNumeroCuadro();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@DELETE
	@Path("/delete/{bicicletaId}")
	public Response delete(@PathParam("bicicletaId") Integer id) {

		Response response = null;
		try {
			if (bicicletaService.getBicicleta(id) != null) {
				bicicletaService.delete(id);
				response = Response.ok(200).build();
			} else {
				response = Response.status(204).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasLibres")
	public Response getBicicletasLibres() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllLibres();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasLibresOrdenUbicacion")
	public Response getBicicletasLibresOrdenUbicacion() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllLibresOrdenUbicacion();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasLibresOrdenEstado")
	public Response getBicicletasLibresOrdenEstado() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllLibresOrdenEstado();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listadoBicicletasLibresOrdenNumeroCuadro")
	public Response getBicicletasLibresOrden() {
		Response response = null;
		List<BicicletaDTO> bicicletasDTO;
		try {
			bicicletasDTO = bicicletaService.getAllLibresOrdenNumeroCuadro();
			if (bicicletasDTO != null) {
				response = Response.ok(bicicletasDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
}


