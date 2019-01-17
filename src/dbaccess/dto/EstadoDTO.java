package dbaccess.dto;

import model.Estado;

public class EstadoDTO {

	private Integer idEstado;
	private String descripcion;
	private String nombre;

	public EstadoDTO(Estado estado) {
		super();
		this.idEstado = estado.getId();
		this.descripcion = estado.getDescripcion();
		this.nombre = estado.getNombre();
	}

	public String toString() {
		return ("Estado id: " + this.getIdEstado() + " Estado descripcion: " + this.getDescripcion()
				+ " Estado nombre: " + this.getNombre());
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
