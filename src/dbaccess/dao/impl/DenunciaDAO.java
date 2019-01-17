package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import dbaccess.dto.DenunciaDTO;
import model.Denuncia;

public class DenunciaDAO extends GenericDAO{

	public void create(Denuncia denuncia){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(denuncia);
		this.getEntityManager().getTransaction().commit();

	} 
	
	public DenunciaDTO getDenuncia(Integer id){
		
		String query = "from Denuncia a where a.id = :id ";
		Denuncia denuncia = (Denuncia)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		DenunciaDTO denunciaDTO = new DenunciaDTO(denuncia);  
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
		Denuncia denuncia = (Denuncia)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return denuncia;	
	}


	public List<DenunciaDTO> getAll(){
		String query = "from Denuncia ";
		@SuppressWarnings("unchecked")
		List<Denuncia> denuncias = (List<Denuncia>)this.getEntityManager().createQuery(query).getResultList();
		List<DenunciaDTO> denunciasDTO = new ArrayList<DenunciaDTO>();
		for(Denuncia a : denuncias){
			denunciasDTO.add(new DenunciaDTO(a));
		}
		return denunciasDTO;
	}

}
