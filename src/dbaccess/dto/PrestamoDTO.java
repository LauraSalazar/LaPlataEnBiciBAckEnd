package dbaccess.dto;

import model.Prestamo;

public class PrestamoDTO {
	private Integer idPrestamo;
	private String fechaInicio;
	private String fechaFin;
	private Integer idBicicleta;
	private Integer idPersona;
	private Integer idDenuncia;
	private String ubicacionActual;
	private String numeroCuadro;
	private String nombreUsuario; 
	private String comentario;
	private Boolean denunciada;

	public PrestamoDTO(Prestamo prestamo) {
		super();
		this.idPrestamo = prestamo.getIdPrestamo();
		this.fechaInicio = prestamo.getFechaInicio();
		this.fechaFin = prestamo.getFechafin();
		this.idBicicleta = prestamo.getBicicleta().getId();
		this.idPersona = prestamo.getUser().getId();
		if (prestamo.getDenuncia() != null) {
		this.idDenuncia = prestamo.getDenuncia().getId();
		this.comentario = prestamo.getDenuncia().getHechos();
		this.denunciada = true;
		}
		else {
			this.idDenuncia = 0;
			this.denunciada = false;
		}
		this.ubicacionActual = prestamo.getBicicleta().getUbicacionActual().getNombre();
		this.numeroCuadro = prestamo.getBicicleta().getNumeroCuadro();
		this.nombreUsuario = prestamo.getUser().getNombres() + " " + prestamo.getUser().getApellido();
	}

	public PrestamoDTO () {
		super();
	}
	
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
