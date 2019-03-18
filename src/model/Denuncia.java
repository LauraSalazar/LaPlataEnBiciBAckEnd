package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Denuncia")
public class Denuncia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_DENUNCIA")
	private Integer id;

	@Column(name = "FECHA")
	private String fecha;
	@Column(name = "HECHOS")
	private String hechos;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHechos() {
		return hechos;
	}

	public void setHechos(String hechos) {
		this.hechos = hechos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Denuncia(String fecha, String comentario) {
		super();
		this.fecha = fecha;
		this.hechos = comentario;
	}
	
	public Denuncia(){
		super();
	}
	
}
