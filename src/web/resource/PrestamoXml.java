package web.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrestamoXml {
	@XmlElement
	private Integer idPrestamo;
	@XmlElement
	private String fechaInicio;
	@XmlElement
	private String fechaFin;
	@XmlElement
	private Integer idBicicleta;
	@XmlElement
	private Integer idPersona;
	@XmlElement
	private Integer idDenuncia;
	@XmlElement
	private String ubicacionActual;
	@XmlElement	
	private String numeroCuadro;
	@XmlElement	
	private String nombreUsuario;
	@XmlElement	
	private String comentario;
	@XmlElement
	private Boolean denunciada; 
	
	public Integer getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Integer getIdBicicleta() {
		return idBicicleta;
	}
	public void setIdBicicleta(Integer idBicicleta) {
		this.idBicicleta = idBicicleta;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(Integer idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public String getUbicacionActual() {
		return ubicacionActual;
	}
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
	public String getNumeroCuadro() {
		return numeroCuadro;
	}
	public void setNumeroCuadro(String numeroCuadro) {
		this.numeroCuadro = numeroCuadro;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Boolean getDenunciada() {
		return denunciada;
	}
	public void setDenunciada(Boolean denunciada) {
		this.denunciada = denunciada;
	}

	
}
