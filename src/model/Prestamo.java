package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity(name="Prestamo")
public class Prestamo {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idPrestamo;

	@Column(name="FECHA_INICIO")
	private String fechaInicio;
	@Column(name="FECHA_FIN")	
	private String fechafin;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Bicicleta bicicleta;
	@OneToOne(cascade=CascadeType.REMOVE)
	private Denuncia denuncia;
	
	public Integer getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Prestamo(String fechaInicio, String fechafin, Usuario user, Bicicleta bici) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechafin = fechafin;
		this.usuario = user;
		this.bicicleta = bici;
	}
	
	public Prestamo() {
		super();
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

}
