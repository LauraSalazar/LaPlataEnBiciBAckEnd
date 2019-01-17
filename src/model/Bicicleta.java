/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.DenunciaDAO;
import dbaccess.dao.impl.PrestamoDAO;

@Entity(name="Bicicleta")
public class Bicicleta {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_BICICLETA")
	private Integer id;
	@Column(name="FECHA_INGRESO")
	private String fechaIngreso;
	@Column(name="NUMERO_CUADRO")
	private String numeroCuadro;

	@Column(name="ESTADO")
	private String estado;
	@ManyToOne(optional=false)
	private Estacion ubicacionActual;

	public String getNumeroCuadro() {
		return numeroCuadro;
	}

	public void setNumeroCuadro(String numeroCuadro) {
		this.numeroCuadro = numeroCuadro;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Estacion getUbicacionActual() {
		return this.ubicacionActual;
	}

	public void setUbicacionActual(Estacion ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}


	public Bicicleta(String numeroCuadro, String fechaIngreso, String estado, Estacion ubicacion) {
		super();
		this.numeroCuadro = numeroCuadro;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
		this.ubicacionActual = ubicacion;
	}
	
	public Bicicleta(){
		super();
	}
	
	public void denunciarBicicleta(Usuario usuario, String comentario){
		
		//Buco el prestamo para asignarle la denuncia
		PrestamoDAO prestamoDAO = new PrestamoDAO();
		Prestamo prestamo = prestamoDAO.getPrestamo(this.getId(),usuario.getId());
		
		//Busco el estado denunciada para asignarselo al estado
//		EstadoDAO estadoDAO = new EstadoDAO();
//		Estado estado = estadoDAO.getEstadoByName("Denunciada");
		
		//Creo una denuncia y la persisto
		Denuncia denuncia = new Denuncia(Calendar.DATE + "-" + Calendar.MONTH + "-" + Calendar.YEAR , comentario);
		DenunciaDAO denunciaDAO = new DenunciaDAO();
		denunciaDAO.create(denuncia);
		
		//Actualizo el prestamo con la denuncia y le asigno a la bicicleta que esta denunciada
		prestamo.setDenuncia(denuncia);
		this.setEstado("Denunciada");
		
		BicicletaDAO bicicletaDAO = new BicicletaDAO();
		//Persisto prestamo y bicicleta
		bicicletaDAO.update(this);
		prestamoDAO.update(prestamo);
		
	}
}