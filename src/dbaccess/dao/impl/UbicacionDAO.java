package dbaccess.dao.impl;

import dbaccess.dto.UbicacionDTO;
import model.Ubicacion;

public class UbicacionDAO extends GenericDAO{

	public void create(Ubicacion ubicacion){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(ubicacion);
		this.getEntityManager().getTransaction().commit();

	} 
	
	public UbicacionDTO getUbicacion(Integer id){
		
		String query = "from Ubicacion a where a.id = :id ";
		Ubicacion ubicacion = (Ubicacion)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		UbicacionDTO ubicacionDTO = new UbicacionDTO(ubicacion);  
		return ubicacionDTO;
		
	}
	
	public void update(Ubicacion ubicacion){
		
		this.getEntityManager().getTransaction().begin();
		Ubicacion ubicacionTemp = this.findById(ubicacion.getId());
		this.getEntityManager().refresh(ubicacionTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Ubicacion ubicacion){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(ubicacion);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Ubicacion findById(Integer id){
		String query = "from Ubicacion a where a.id = :id ";
		Ubicacion ubicacion = (Ubicacion)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return ubicacion;
	}

}
