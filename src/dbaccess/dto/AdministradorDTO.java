package dbaccess.dto;

import model.Administrador;

public class AdministradorDTO {
	
	private String dni;
	private String apellido;
	private String nombres;
	private String domicilio;
	private String fecha_nac;
	private String sexo;
	private String mail;
	private String password;
	
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

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
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

	public AdministradorDTO(Administrador admin){
		super();
		this.setApellido(admin.getApellido());
		this.setDni(admin.getDni());
		this.setDomicilio(admin.getDomicilio());
		this.setFecha_nac(admin.getFechaNac());
		this.setMail(admin.getMail());
		this.setNombres(admin.getNombres());
		this.setSexo(admin.getSexo());
		this.setDni(admin.getPassword());
	}

}
