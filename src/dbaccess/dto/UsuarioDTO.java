package dbaccess.dto;

import javax.xml.bind.annotation.XmlRootElement;

import model.Usuario;

@XmlRootElement
public class UsuarioDTO {

	private Integer id;
	private String dni;
	private String apellido;
	private String domicilio;
	private String nombres;
	private String fechaNac;
	private String sexo;
	private String mail;
	private String password;

	public String toString() {
		return ("UsuarioId: " + this.getId() + " Usuario dni: " + this.getDni() + " Usuario apellido: "
				+ this.getApellido() + " Usuario domicilio: " + this.getDomicilio() + " Usuario nombre: "
				+ this.getNombres() + " Usuario Fecha Nacimiento: " + this.getFechaNac() + " Usuario sexo: "
				+ this.getSexo() + " Usuario mail: " + this.getMail());
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.dni = usuario.getDni();
		this.apellido = usuario.getApellido();
		this.domicilio = usuario.getDomicilio();
		this.nombres = usuario.getNombres();
		this.fechaNac = usuario.getFechaNac();
		this.sexo = usuario.getSexo();
		this.mail = usuario.getMail();
		this.id = usuario.getId();
		this.password = usuario.getPassword();
	}
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(String dni,String apellido, String domicilio, String nombres, String fechaNac, String sexo, String mail, String password) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.nombres = nombres;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.mail = mail;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
