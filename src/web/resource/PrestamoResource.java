package web.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dbaccess.dto.BicicletaDTO;
import dbaccess.dto.EstacionDTO;
import dbaccess.dto.PrestamoDTO;
import web.service.EstacionService;
import web.service.PrestamoService;

@Path ("/Prestamo")
public class PrestamoResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	
	PrestamoService prestamoService;
	public PrestamoResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		prestamoService = new PrestamoService();
	}
	
	public PrestamoResource() {
		super();
		prestamoService = new PrestamoService();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/retirarBicicleta")
	public Response retirarBicicleta(PrestamoXml pres) {
		Response response = null;
		PrestamoDTO prestamoDTO;
		try {
			prestamoDTO = prestamoService.retirarBicicleta(pres.getIdBicicleta(),pres.getIdPersona());
			if (prestamoDTO != null) {
				response = Response.ok(prestamoDTO).build();
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
	@Path("/getPrestamo/{idPrestamo}")
	public Response getPrestamo(@PathParam("idPrestamo") Integer id) {
		Response response = null;
		PrestamoDTO prestamoDTO;
		try {
			prestamoDTO = prestamoService.getPrestamo(id);
			if (prestamoDTO != null) {
				response = Response.ok(prestamoDTO).build();
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
	@Path("/misPrestamos/{idUsuario}")
	public Response getMisBicicletas(@PathParam("idUsuario") Integer idUsuario) {
		Response response = null;
		try {
			List<PrestamoDTO> misPrestamos = new ArrayList<PrestamoDTO>();
			misPrestamos = prestamoService.getMisPrestamos(idUsuario);
			if (misPrestamos != null) {
				response = Response.ok(misPrestamos).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(500).build();
		}
		return response;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/devolverBicicletaConDenuncia")
	public Response devolverBicicletaConDenuncia(PrestamoXml pres) {
		Response response = null;
		List<PrestamoDTO> prestamosDTO;
		try {
			prestamosDTO = prestamoService.devolverBicicletaConDenuncia(pres.getIdPersona(),pres.getIdBicicleta(),pres.getIdPrestamo(), pres.getComentario());
			if (prestamosDTO != null) {
				response = Response.ok(prestamosDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(500).build();
		}
		return response;

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/devolverBicicletaSinDenuncia")
	public Response devolverBicicletaSinDenuncia(PrestamoXml pres) {
		Response response = null;
		List<PrestamoDTO> prestamosDTO;
		try {
			prestamosDTO = prestamoService.devolverBicicletaSinDenuncia(pres.getIdPersona(),pres.getIdBicicleta(),pres.getIdPrestamo());
			if (prestamosDTO != null) {
				response = Response.ok(prestamosDTO).build();
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
