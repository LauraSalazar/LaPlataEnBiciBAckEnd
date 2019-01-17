package dbaccess.dto;

import javax.xml.bind.annotation.XmlRootElement;

import model.Estacion;

@XmlRootElement
public class EstacionDTO {

	private Integer id;
	private String abiertodesde;
	private String abiertohasta;
	private Integer cantidadbicicletasmax;
	private String codigopostal;
	private String nombre;
	private String estado;
	private String latitud;	
	private String longitud;	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



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


	public String toString(){
		return ("Estacion id: " + this.getId() + " Estacion abierta desde: " + this.getAbiertodesde() + "Estacion abierta hasta: "+ this.getAbiertohasta()
				+ " Estacion cantidad biciletas max: " + this.getCantidadbicicletasmax() + " Estacion codigo postal: " + this.getCodigopostal())
				+ " Estacion nombre: " + this.getNombre() ;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getAbiertodesde() {
		return abiertodesde;
	}

	public void setAbiertodesde(String abiertodesde) {
		this.abiertodesde = abiertodesde;
	}

	public String getAbiertohasta() {
		return abiertohasta;
	}

	public void setAbiertohasta(String abiertohasta) {
		this.abiertohasta = abiertohasta;
	}

	public Integer getCantidadbicicletasmax() {
		return cantidadbicicletasmax;
	}

	public void setCantidadbicicletasmax(Integer cantidadbicicletasmax) {
		this.cantidadbicicletasmax = cantidadbicicletasmax;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstacionDTO(Estacion estacion) {
		super();
		this.id = estacion.getId();
		this.abiertodesde = estacion.getAbiertoDesde();
		this.abiertohasta = estacion.getAbiertoHasta();
		this.cantidadbicicletasmax = estacion.getCantidadBicicletasMax();
		this.codigopostal = estacion.getCodigoPostal();
		this.nombre = estacion.getNombre();
		this.estado = estacion.getEstado(); 
		this.latitud = estacion.getUbicacionLatitud();
		this.longitud = estacion.getUbicacionLongitud();
	}


	public EstacionDTO() {
		super();
	}
	
	public EstacionDTO(String nombre,String codigopostal, String latitud, String longitud, String estado, String abiertodesde, String abiertohasta, Integer cantidadbicicletasmax) {
		super();
		this.nombre = nombre;
		this.codigopostal  = codigopostal;
		this.latitud = latitud;
		this.longitud = longitud;
		this.estado = estado;
		this.abiertodesde = abiertodesde;
		this.abiertohasta = abiertohasta;
		this.cantidadbicicletasmax = cantidadbicicletasmax;
	}
	
	
	
}
