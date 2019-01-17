package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.PrestamoDAO;
import model.Persona;

@Entity(name="Usuario")
public class Usuario extends Persona {
	
	@OneToMany
	private List<Bicicleta> bicicletas =  new ArrayList<Bicicleta>();

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}
	
	public Usuario(String dni,String apellido, String nombres, String domicilio, String fechaNac, String sexo, String mail, String password){
		super();
		this.setDni(dni);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.setNombres(nombres);
		this.setFechaNac(fechaNac);
		this.setSexo(sexo);
		this.setMail(mail);
		this.setPassword(password);
	}
	
	public Usuario(){
		super();
	}
	
	public void retirarBicicleta(String fechaInicio, String fechaFin, Bicicleta bici){
		BicicletaDAO bicicletaDAO = new BicicletaDAO(); 
		Integer cantidadLibres = bicicletaDAO.getBicicletasLibres(bici.getUbicacionActual());
		System.out.println("Esto es desde USuario retirarBicicleta y el numero es:" + cantidadLibres);
		if(cantidadLibres>0){
		Prestamo prestamo = new Prestamo(fechaInicio,fechaFin,this, bici);
		PrestamoDAO prestamoDAO = new PrestamoDAO();
		prestamoDAO.create(prestamo);
		
		}
	}

}