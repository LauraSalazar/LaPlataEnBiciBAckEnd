package dbaccess.dto;

import model.Prestamo;

public class PrestamoDTO {
	private Integer idPrestamo;
	private String fechaInicio;
	private String fechaFin;
	private Integer idBicicleta;
	private Integer idPersona;
	private Integer idDenuncia;

	public PrestamoDTO(Prestamo prestamo) {
		super();
		this.idPrestamo = prestamo.getIdPrestamo();
		this.fechaInicio = prestamo.getFechaInicio();
		this.fechaFin = prestamo.getFechafin();
		this.idBicicleta = prestamo.getBicicleta().getId();
		this.idPersona = prestamo.getUser().getId();
		this.idDenuncia = prestamo.getDenuncia().getId();
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

}
