package dbaccess.dto;

import model.Bicicleta;

public class BicicletaDTO {

	private String fechaIngreso;
	private Integer id;
	private String estado;
	private String numeroCuadro;
	private String ubicacionActual;
	private Integer idEstacion;
	
	public String getNumeroCuadro() {
		return numeroCuadro;
	}

	public void setNumeroCuadro(String numeroCuadro) {
		this.numeroCuadro = numeroCuadro;
	}

	public String toString(){
		return (" Bicicleta id: " + this.getId() + " Bicicleta fecha ingreso: " + this.getFechaIngreso());
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUbicacionActual() {
		return ubicacionActual;
	}

	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

	public Integer getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Integer idEstacion) {
		this.idEstacion = idEstacion;
	}

	public BicicletaDTO(Bicicleta bici) {
		super();
		this.fechaIngreso = bici.getFechaIngreso();
		this.id = bici.getId();
		this.estado = bici.getEstado();
		this.ubicacionActual = bici.getUbicacionActual().getNombre();
		this.numeroCuadro = bici.getNumeroCuadro();
		this.idEstacion = bici.getUbicacionActual().getId();
	}
	
	public BicicletaDTO() {
		
	}

}