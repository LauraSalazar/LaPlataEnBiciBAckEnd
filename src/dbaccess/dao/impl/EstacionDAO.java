package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

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
		EstacionDTO estacionDTO = new EstacionDTO();
		System.out.println("valor de id antes de la query: " + id);
		String query = "from Estacion a where a.id = :id ";
		try {
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		estacion = (Estacion)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (estacion != null){
			 estacionDTO = new EstacionDTO(estacion);
					}
		System.out.println("valor de nombre de estacionDTO despues de la query" + estacionDTO.getNombre());
		}
		catch (NoResultException e) {
			return estacionDTO;
		}
		return estacionDTO;
		
	}
	
	public void update(Estacion estacion){
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(estacion);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Estacion estacion){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(estacion);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Estacion findById(Integer id){
		System.out.println("Entro en la query de estcion");
		String query = "from Estacion a where a.id = :id ";
		System.out.println("Esta es la query " + query);
		Estacion estacion;
		try {
		 estacion = (Estacion) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
		return estacion;
	}
	
	@SuppressWarnings("unchecked")
	public List<EstacionDTO> getAll(){
		String query = "from Estacion";

		List<EstacionDTO> estacionesDTO = new ArrayList<EstacionDTO>();
		try {
		List<Estacion> estaciones = (List<Estacion>)this.getEntityManager().createQuery(query).getResultList();
		for(Estacion a : estaciones){
			estacionesDTO.add(new EstacionDTO(a));
		}
		}
		catch (NoResultException e) {
			return estacionesDTO;
		}
		return estacionesDTO;
	}

}