package web.resource;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dbaccess.dto.EstacionDTO;
import web.service.EstacionService;

@Path ("/Estacion")
public class EstacionResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	
	EstacionService estacionService;
	
	public EstacionResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		estacionService = new EstacionService();
	}
	
	public EstacionResource() {
		super();
		estacionService = new EstacionService();
	}
	

	@GET
	@Path("/{estacionId}")
	public Response getEstacion(@PathParam("estacionId") Integer id) {
		Response response;
		EstacionDTO estacionDTO = estacionService.getEstacion(id);
		try {
			if (estacionDTO == null) {
				response = Response.status(204).build();
			} else {
				System.out.println("antes del response OK");
				response = Response.ok(estacionDTO).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}
	

	// Crea una estacion
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createEstacion(EstacionXml estacion) {
		Response response = null;
		try {
            System.out.println("estacion.getNombre: " + estacion.getNombre());
            System.out.println("estacion.getNombres: " + estacion.getCodigopostal());
            System.out.println("estacion.getdomicilio: " + estacion.getEstado());
            System.out.println("estacion.getUbicacionLAtitud: " + estacion.getLatitud());
            System.out.println("estacion.getUbicacionLongitud: " + estacion.getLongitud());
            System.out.println("estacion.getSexo: " + estacion.getAbiertodesde());
            System.out.println("estacion.getMail: " + estacion.getAbiertohasta());
            System.out.println("estacion.getHbilitado: " + estacion.getCantidadbicicletasmax());
            //String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta, String estado, String ubicacionLatitud, String ubicacionLongitud, Integer cantidad
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Integer id = estacionService.create(estacion.getNombre(),estacion.getCodigopostal(), estacion.getAbiertodesde(), estacion.getAbiertohasta(),estacion.getLatitud(),estacion.getLongitud(),estacion.getEstado(), Integer.valueOf(estacion.getCantidadbicicletasmax()));

			response = Response.ok(200).
				entity(String.valueOf(id)).
					build();
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modificar")
	public Response updateUsuario(EstacionXml estacion) {
		System.out.println("Entro en el modificar estacion.id: " + estacion.getId());
		Response response = null;
		try {

			EstacionDTO estacionDTO = estacionService.getEstacion(estacion.getId());
			if (estacionDTO != null) {
				estacionService.update(estacion.getId(), estacion.getNombre(), estacion.getCodigopostal(), estacion.getAbiertodesde(), estacion.getAbiertohasta(), estacion.getEstado(), estacion.getLatitud(), estacion.getLongitud(), estacion.getCantidadbicicletasmax());
				estacionDTO = estacionService.getEstacion(estacion.getId());
				response = Response.ok(estacionDTO).build();
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
	@Path("/listadoEstaciones")
	public Response getEstaciones() {
		Response response = null;
		List<EstacionDTO> estacionesDTO;
		try {
			estacionesDTO = estacionService.getAll();
			if (estacionesDTO != null) {
				response = Response.ok(estacionesDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}
	
	@DELETE
	@Path("/delete/{estacionId}")
	public Response delete(@PathParam("estacionId") Integer id) {

		Response response = null;
		try {
			if (estacionService.getEstacion(id) != null) {
				estacionService.delete(id);
				response = Response.ok(200).build();
			} else {
				response = Response.status(204).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}
	
}




