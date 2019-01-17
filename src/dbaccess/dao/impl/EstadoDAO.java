package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import dbaccess.dto.EstadoDTO;
import model.Estado;

public class EstadoDAO extends GenericDAO{

	public void create(Estado estado){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(estado);
		this.getEntityManager().getTransaction().commit();

	} 
	
	public EstadoDTO getEstado(Integer id){
		
		String query = "from Estado a where a.id = :id ";
		Estado estado = (Estado) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		EstadoDTO estadoDTO = new EstadoDTO(estado);  
		return estadoDTO;
		
	}
	
	public void update(Estado estado){
		
		this.getEntityManager().getTransaction().begin();
		Estado estadoTemp = this.findById(estado.getId());
		this.getEntityManager().refresh(estadoTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Estado estado){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(estado);
		this.getEntityManager().getTransaction().commit();
	}
	
	//estadoDAO.getEstadoByName("Denunciada");

	public Estado getEstadoByName(String nombre){
		String query = "from Estado a where a.nombre = :nombre ";
		Estado estado = (Estado) this.getEntityManager().createQuery(query).setParameter("nombre", nombre).getSingleResult();
		return estado;
	}
	
	public Estado findById(Integer id){	
		String query = "from Estado a where a.id = :id ";
		Estado estado = (Estado) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return estado;
	}
	
	public List<EstadoDTO> getAll(){
		String query = "from Estado ";
		@SuppressWarnings("unchecked")
		List<Estado> estados = (List<Estado>)this.getEntityManager().createQuery(query).getResultList();
		List<EstadoDTO> estadosDTO = new ArrayList<EstadoDTO>();
		for(Estado a : estados){
			estadosDTO.add(new EstadoDTO(a));
		}
		return estadosDTO;
	}

}
