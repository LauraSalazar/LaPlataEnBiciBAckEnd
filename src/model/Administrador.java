package model;

import javax.persistence.Entity;

import model.Persona;

@Entity(name="Administrador")
public class Administrador extends Persona {
	public Administrador(String dni,String apellido, String nombres, String domicilio, String fechaNac, String sexo, String mail, String password){
		super();
		this.setDni(dni);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.setNombres(nombres);
		this.setDomicilio(domicilio);
		this.setFechaNac(fechaNac);
		this.setSexo(sexo);
		this.setMail(mail);
		this.setPassword(password);
	}
	
	public Administrador(){
		super();
	}
	
}