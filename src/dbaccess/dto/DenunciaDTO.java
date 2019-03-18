package dbaccess.dto;

import model.Denuncia;

public class DenunciaDTO {

	private String hechos;
	private String fecha;
	private Integer id;

	public DenunciaDTO() {
		super();
	}
	public String getHechos() {
		return hechos;
	}

	public void setHechos(String hechos) {
		this.hechos = hechos;
	}

	public DenunciaDTO(Denuncia denuncia) {
		super();
		this.hechos = denuncia.getHechos();
		this.fecha = denuncia.getFecha();
		this.id = denuncia.getId();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
