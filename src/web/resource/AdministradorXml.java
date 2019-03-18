package web.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdministradorXml {

	
	private String dni;
	private String apellido;

	private String nombres;
	private String domicilio;	

	private String fechaNac;
	private String sexo;
	
	private String mail;
	private String password;
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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

	public AdministradorXml(){}
	
	public AdministradorXml(String dni, String apellido,String nombres,String domicilio,String fechaNac,String sexo,String mail,String password){
		super();
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombres(nombres);
		this.setDomicilio(domicilio);
		this.setFechaNac(fechaNac);
		this.setSexo(sexo);
		this.setMail(mail);
		this.setPassword(password);
	}
	
}
