package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import dbaccess.dto.DenunciaDTO;
import model.Denuncia;

public class DenunciaDAO extends GenericDAO{

	public void create(Denuncia denuncia){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(denuncia);
		this.getEntityManager().getTransaction().commit();

	} 
	
	public DenunciaDTO getDenuncia(Integer id){
		
		DenunciaDTO denunciaDTO = new DenunciaDTO();  
		String query = "from Denuncia a where a.id = :id ";
		try {
		Denuncia denuncia = (Denuncia)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		 denunciaDTO = new DenunciaDTO(denuncia);  
		}
		catch (NoResultException e) {
			return denunciaDTO;
		}
		 return denunciaDTO;
		
	}
	
	public void update(Denuncia denuncia){
		
		this.getEntityManager().getTransaction().begin();
		Denuncia denunciaTemp = this.findByID(denuncia.getId());
		this.getEntityManager().refresh(denunciaTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Denuncia denuncia){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(denuncia);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Denuncia findByID(Integer id){
		String query = "from Denuncia a where a.id = :id ";
		Denuncia denuncia;
		try {
		  denuncia = (Denuncia)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
		return denuncia;	
	}

	@SuppressWarnings("unchecked")
	public List<DenunciaDTO> getAll(){
		String query = "from Denuncia ";
		List<DenunciaDTO> denunciasDTO = new ArrayList<DenunciaDTO>();
		try {
		List<Denuncia> denuncias = (List<Denuncia>)this.getEntityManager().createQuery(query).getResultList();

		for(Denuncia a : denuncias){
			denunciasDTO.add(new DenunciaDTO(a));
		}
		}
		catch (NoResultException e) {
			return denunciasDTO;
		}
		return denunciasDTO;
	}

}
