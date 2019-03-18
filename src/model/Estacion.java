/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Estacion")
@Table
public class Estacion {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ESTACION")
	private Integer id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;
	@Column(name="LATITUD")
	private String ubicacionLatitud;
	@Column(name="LONGITUD")
	private String ubicacionLongitud;
	@Column(name="Estado")
	private String estado;	
	
	@Column(name="ABIERTO_DESDE")
	private String abiertoDesde;
	@Column(name="ABIERTO_HASTA")
	private String abiertoHasta;
	
	@Column(name="CANTIDAD_BICICLETAS_MAX")
	private Integer cantidadBicicletasMax;

	public Integer getCantidadBicicletasMax() {
		return cantidadBicicletasMax;
	}

	public void setCantidadBicicletasMax(Integer cantidadBicicletasMax) {
		this.cantidadBicicletasMax = cantidadBicicletasMax;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbiertoDesde() {
		return abiertoDesde;
	}

	public void setAbiertoDesde(String abiertoDesde) {
		this.abiertoDesde = abiertoDesde;
	}

	public String getAbiertoHasta() {
		return abiertoHasta;
	}

	public void setAbiertoHasta(String abiertoHasta) {
		this.abiertoHasta = abiertoHasta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//estacion.getNombre(),estacion.getCodigopostal(), estacion.getLatitud(), estacion.getLongitud(),estacion.getEstado(),estacion.getAbiertodesde(),estacion.getAbiertohasta(), estacion.getCantidadbicicletasmax()   
	public Estacion(String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta,String ubicacionLatitud, String ubicacionLongitud, String estado, Integer cantidad){
		super();
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.abiertoDesde = abiertoDesde;
		this.abiertoHasta = abiertoHasta;
		this.ubicacionLatitud = ubicacionLatitud;
		this.ubicacionLongitud = ubicacionLongitud;
		this.estado = estado;

		this.cantidadBicicletasMax = cantidad;
	}
	
	public String getUbicacionLatitud() {
		return ubicacionLatitud;
	}

	public void setUbicacionLatitud(String ubicacionLatitud) {
		this.ubicacionLatitud = ubicacionLatitud;
	}

	public String getUbicacionLongitud() {
		return ubicacionLongitud;
	}

	public void setUbicacionLongitud(String ubicacionLongitud) {
		this.ubicacionLongitud = ubicacionLongitud;
	}

	public Estacion(){
		super();
	}
}