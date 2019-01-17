package dbaccess.dto;

import model.Ubicacion;

public class UbicacionDTO {

	private String latitud;
	private String longitud;
	private Integer id;

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public UbicacionDTO(Ubicacion ubicacion) {
		super();
		this.latitud = ubicacion.getLatitud();
		this.longitud = ubicacion.getLongitud();
		this.id = ubicacion.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
