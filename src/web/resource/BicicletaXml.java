package web.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BicicletaXml {
	
	@XmlElement
	private Integer id;
	@XmlElement
	private String fechaIngreso;
	@XmlElement
	private String estado;
	@XmlElement
	private String numeroCuadro;

	@XmlElement
	//Nombre de la estacion donde se encuentra la bicicleta
	private String ubicacionActual;
	
	@XmlElement
	//Usuario que tiene esta bicicleta
	private Integer idUsuario;
	
	@XmlElement
	private Integer idEstacion;
	
	public String getFechaIngreso() {
		return fechaIngreso;
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

	public String getNumeroCuadro() {
		return numeroCuadro;
	}
	public void setNumeroCuadro(String numeroCuadro) {
		this.numeroCuadro = numeroCuadro;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUbicacionActual() {
		return ubicacionActual;
	}
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public Integer getIdEstacion() {
		return idEstacion;
	}
	public void setIdEstacion(Integer idEstacion) {
		this.idEstacion = idEstacion;
	}
	
	public BicicletaXml(){}
	
	public BicicletaXml(Integer id, String fechaIngreso, String estado, String numeroCuadro, String ubicacionActual, Integer idUsuario){
		super();
		this.setId(id);
		this.setFechaIngreso(fechaIngreso);
		this.setEstado(estado);
		this.setNumeroCuadro(numeroCuadro);
		this.setUbicacionActual(ubicacionActual);
		this.setIdUsuario(idUsuario);
	}
}
