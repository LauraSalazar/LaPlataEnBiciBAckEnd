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

import dbaccess.dto.UsuarioDTO;
import web.service.UsuarioService;

@Path("/Usuario")
public class UsuarioResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	UsuarioService usuarioService;

	public UsuarioResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		usuarioService = new UsuarioService();
	}

	public UsuarioResource() {
		super();
		usuarioService = new UsuarioService();
	}

	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/{usuarioId}")
	public Response getUsuario(@PathParam("usuarioId") Integer id) {
		Response response;
		UsuarioDTO usuarioDTO = usuarioService.getUsuario(id);
		try {
			if (usuarioDTO == null) {
				response = Response.status(204).build();
			} else {
				response = Response.ok(usuarioDTO).build();
			}
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

	// Crea un usuario
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createUsuario(UsuarioXml usuario) {
		Response response = null;
		try {
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Integer id3 = usuarioService.create(usuario.getDni(), usuario.getApellido(), usuario.getNombres(), usuario.getDomicilio(), usuario.getFechaNac(), usuario.getSexo(), usuario.getMail(), usuario.getPassword());
			response = Response.ok(200).entity(String.valueOf(id3)).build();
		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modificar")
	public Response updateUsuario(UsuarioXml user) {
		Response response = null;
		try {

			UsuarioDTO usuarioDTO = usuarioService.getUsuario(user.getId());
			if (usuarioDTO != null) {
				usuarioService.update(user.getId(), user.getDni(), user.getApellido(), user.getNombres(), user.getDomicilio(), user.getFechaNac(), user.getSexo(), user.getMail());
				usuarioDTO = usuarioService.getUsuario(user.getId());
				response = Response.ok(usuarioDTO.getId()).build();
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listadoUsuario")
	public Response getUsuario() {
		Response response = null;
		List<UsuarioDTO> usuariosDTO;
		try {
			usuariosDTO = usuarioService.getAll();
			if (usuariosDTO != null) {
				response = Response.ok(usuariosDTO).build();
			} else {
				response = Response.status(204).build();
			}

		} catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;

	}

	@DELETE

	@Path("/delete/{usuarioId}")
	public Response delete(@PathParam("usuarioId") Integer id) {

		Response response = null;
		try {
			if (usuarioService.getUsuario(id) != null) {
				usuarioService.delete(id);
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
