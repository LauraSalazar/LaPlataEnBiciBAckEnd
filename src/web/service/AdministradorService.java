package web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dbaccess.dao.impl.AdministradorDAO;
import model.Administrador;


@Path("/Administrador")
public class AdministradorService {
	AdministradorDAO administradorDAO;

	public AdministradorService() {
		super();
		administradorDAO = new AdministradorDAO();
	}
	
	public Integer create(String dni,String apellido, String nombres, String domicilio, String fechaNac, String sexo, String mail, String password) {
		return administradorDAO.create(new Administrador(dni,apellido,nombres,domicilio,fechaNac,sexo,mail,password));
	}

}
