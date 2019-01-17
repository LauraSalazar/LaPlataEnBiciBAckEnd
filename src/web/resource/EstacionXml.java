package web.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstacionXml {
	@XmlElement
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	private String nombre;
	
	@XmlElement
	private String codigopostal;
	
	@XmlElement
	private String estado;
	
	@XmlElement
	private String latitud;
	
	@XmlElement
	private String longitud;
	
	@XmlElement
	private String abiertodesde;
	
	@XmlElement
	private String abiertohasta;
	
	@XmlElement
	private Integer cantidadbicicletasmax;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


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


	
	public EstacionXml(){}
	
	public EstacionXml(Integer id, String nombre, String codigopostal, String estado, String latitud, String longitud, String abiertodesde, String abiertohasta, Integer cantidadbicicletasmax){
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setCodigopostal(codigopostal);
		this.setEstado(estado);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setAbiertodesde(abiertodesde);
		this.setAbiertohasta(abiertohasta);
		this.setCantidadbicicletasmax(cantidadbicicletasmax);
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
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
}
