package web.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import web.service.AdministradorService;
import web.service.UsuarioService;
@Path("/Administrador")
public class AdministradorResource {


	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	AdministradorService administradorService;

	public AdministradorResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		administradorService = new AdministradorService();
	}

	public AdministradorResource() {
		super();
		administradorService = new AdministradorService();
	}
	
	// Crea un administrador
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response createAdministrador(AdministradorXml admin) {
		Response response = null;
		try {
			// usuarioService.create(usuario.getDni(),usuario.getApellido(),usuario.getNombres(),usuario.getDomicilio(),usuario.getFechaNac(),usuario.getSexo(),usuario.getMail());
			Integer id3 = administradorService.create(admin.getDni(), admin.getApellido(), 
					admin.getNombres(), admin.getDomicilio(), admin.getFechaNac(), admin.getSexo(), admin.getMail(), admin.getPassword());
			response = Response.ok(200).entity(String.valueOf(id3)).build();
		} catch (Exception e) {
			response = Response.ok().entity(e.getMessage()).build();
		}
		return response;
		
	}
	


}
