package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import dbaccess.dto.EstacionDTO;
import model.Estacion;

public class EstacionDAO extends GenericDAO{

	public Integer create(Estacion estacion){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(estacion);
		this.getEntityManager().getTransaction().commit();
        return estacion.getId();
	} 
	
	public EstacionDTO getEstacion(Integer id){
		Estacion estacion = null;
		EstacionDTO estacionDTO = null;
		System.out.println("valor de id antes de la query: " + id);
		String query = "from Estacion a where a.id = :id ";
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		estacion = (Estacion)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (estacion != null){
			 estacionDTO = new EstacionDTO(estacion);
					}
		System.out.println("valor de nombre de estacionDTO despues de la query" + estacionDTO.getNombre());
		return estacionDTO;
		
	}
	
	public void update(Estacion estacion){
		
		this.getEntityManager().getTransaction().begin();
		Estacion estacionTemp = this.findById(estacion.getId());
		this.getEntityManager().refresh(estacionTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Estacion estacion){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(estacion);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Estacion findById(Integer id){
		String query = "from Estacion a where a.id = :id ";
		Estacion estacion = (Estacion) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return estacion;
	}
	
	public List<EstacionDTO> getAll(){
		String query = "from Estacion";
		@SuppressWarnings("unchecked")
		List<Estacion> estaciones = (List<Estacion>)this.getEntityManager().createQuery(query).getResultList();
		List<EstacionDTO> estacionesDTO = new ArrayList<EstacionDTO>();
		for(Estacion a : estaciones){
			estacionesDTO.add(new EstacionDTO(a));
		}
		return estacionesDTO;
	}

}