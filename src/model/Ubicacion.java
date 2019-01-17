package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Ubicacion")
public class Ubicacion {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_UBICACION")private Integer id;

	@Column(name="LATITUD")
	private String latitud;
	@Column(name="LONGITUD")
	private String longitud;

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	public Ubicacion(String latitud, String longitud){
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public Ubicacion(){
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}