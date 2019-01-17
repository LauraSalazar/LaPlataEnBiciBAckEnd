package web.service;

import java.util.List;

import dbaccess.dao.impl.UsuarioDAO;
import dbaccess.dto.UsuarioDTO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO usuarioDAO;
	
	public UsuarioService(){
		super();
		usuarioDAO = new UsuarioDAO();
	}
	
	public UsuarioDTO getUsuario(Integer id){
		return (usuarioDAO.getUsuario(id));
	}
	
	public List<UsuarioDTO> getAll(){
		List<UsuarioDTO> usuariosDTO = usuarioDAO.getAll();
		return (usuariosDTO);
	}
	
	public void delete (Integer id){
		Usuario usuario = usuarioDAO.findById(id);
		usuarioDAO.delete(usuario);
	}
	
	public Integer create(String dni,String apellido,String nombres,String domicilio,String fechaNacimiento,String sexo,String mail,String password){
		return usuarioDAO.create(new Usuario(dni,apellido,nombres,domicilio,fechaNacimiento,sexo,mail,password));
	}
	
	public void update(Integer id,String dni,String apellido,String nombres,String domicilio,String fechaNacimiento,String sexo,String mail){
		
		Usuario usuario = usuarioDAO.findById(id); 
		usuario.setApellido(apellido);
		usuario.setDni(dni);
		usuario.setDomicilio(domicilio);
		usuario.setMail(mail);
		usuario.setNombres(nombres);
		usuario.setSexo(sexo);
		usuario.setFechaNac(fechaNacimiento);
		usuarioDAO.update(usuario);
	}
	
	public Boolean validateUser(String nombreUsuario, String password) {
		return usuarioDAO.validarUsuario(nombreUsuario, password);
		
	}
	
	public Boolean validateAdmin(String nombreUsuario, String password) {
		return usuarioDAO.validarAdministrador(nombreUsuario, password);
		
	}
	
	public Integer findByDni(String dni) {
		return usuarioDAO.findByDni(dni);
	}
	
	public Usuario findById(Integer id) {
		return usuarioDAO.findById(id);
	}
}
