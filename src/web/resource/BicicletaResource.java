package web.resource;

import java.util.ArrayList;
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
import web.service.UsuarioService;

@Path ("/Bicicleta")
public class BicicletaResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	
	BicicletaService bicicletaService;

	public BicicletaResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		bicicletaService = new BicicletaService();
	}
	
	public BicicletaResource() {
		super();
		bicicletaService = new BicicletaService();
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
	public Response createBicicleta(/*@PathParam("id") Integer id, @PathParam("fechaIngreso") String fechaIngreso,
			@PathParam("estado") String estado, @PathParam("numeroCuadro") String numeroCuadro,
			@PathParam("ubicacionActual") String ubicacionActual*/
			BicicletaXml biciXml) {
		Response response = null;
		System.out.println("Entro el en CrearBicicleta");
		//BicicletaXml biciXml = bici.getValue();
		try {
            System.out.println("bicicleta.getId: " + biciXml.getId());
            System.out.println("bicicleta.getFechaIngreso: " + biciXml.getFechaIngreso());
            System.out.println("bicicleta.getEstado: " + biciXml.getEstado());
            System.out.println("bicicleta.getNumeroCuadro: " + biciXml.getNumeroCuadro());            
            System.out.println("bicicleta.getUbicacionActual: " + biciXml.getUbicacionActual());

            
            EstacionService estacionService = new EstacionService();
            Estacion estacionBicicleta = estacionService.findById(Integer.valueOf(biciXml.getUbicacionActual()));
            UsuarioService usuarioService = new UsuarioService();
            System.out.println("bicicleta.codigoEstacion:" + estacionBicicleta);
            //String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta, String estado, String ubicacionLatitud, String ubicacionLongitud, Integer cantidad
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Integer id2 = bicicletaService.create(biciXml.getNumeroCuadro(), biciXml.getFechaIngreso(),biciXml.getEstado(),estacionBicicleta);
			
			response = Response.ok(200).
				entity(String.valueOf(id2)).
					build();
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modificar")
	public Response updateUsuario(@FormParam("bicicletaId") Integer bicicletaId, @FormParam("fechaIngreso") String fechaIngreso,
			@FormParam("estado") String estado, @FormParam("ubicacionActual") Integer idEstacion) {
		Response response = null;
		try {
            //Aca tendria que validar si existe la estacion
//			EstacionService estacionService = new EstacionService();
//			Estacion estacion = estacionService.findById(idEstacion);
			BicicletaDTO bicicletaDTO = bicicletaService.getBicicleta(bicicletaId);
			if (bicicletaDTO != null) {
				bicicletaService.update(bicicletaId, fechaIngreso, estado, idEstacion); 
				bicicletaDTO = bicicletaService.getBicicleta(bicicletaId);
				response = Response.ok(bicicletaDTO).build();
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/misBicicletas/{idUsuario}")
	public Response getMisBicicletas(@PathParam("idUsuario") Integer idUsuario) {
		Response response = null;
		try {
			List<BicicletaDTO> misBicis = new ArrayList<BicicletaDTO>();
			misBicis = bicicletaService.getMisBicicletas(idUsuario);
			if (misBicis != null) {
				response = Response.ok(misBicis).build();
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
	@Path("/retirarBicicleta/{idBicicleta}/{idUsuario}")
	public Response retirarBicicleta(@PathParam("idBicicleta") Integer idBicicleta, @PathParam("idUsuario") Integer idUsuario) {
		Response response = null;
		BicicletaDTO bicicletaDTO;
		try {
			bicicletaDTO = bicicletaService.retirarBicicleta(idBicicleta,idUsuario);
			if (bicicletaDTO != null) {
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
}


