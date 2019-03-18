package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import dbaccess.dto.AdministradorDTO;
import model.Administrador;

public class AdministradorDAO extends GenericDAO{

	public Integer create(Administrador admin){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(admin);
		this.getEntityManager().getTransaction().commit();
		return admin.getId();

	} 
	
	public AdministradorDTO getAdministrador(Integer id){
		
		String query = "from Administrador a where a.id = :id ";
		Administrador admin = (Administrador)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		AdministradorDTO adminDTO = new AdministradorDTO(admin);  
		return adminDTO;
		
	}
	
	public void update(Administrador ad){
		
		this.getEntityManager().getTransaction().begin();
		Administrador adminTemp = this.finById(ad.getId());
		this.getEntityManager().refresh(adminTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Administrador ad){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(ad);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Administrador finById(Integer id){
		
		String query = "from Administrador a where a.id = :id ";
		Administrador admin = (Administrador)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return admin;
		
	}
	
	public List<AdministradorDTO> getAll(){
		String query = "from Administrador";
		@SuppressWarnings("unchecked")
		List<Administrador> admins = (List<Administrador>)this.getEntityManager().createQuery(query).getResultList();
		List<AdministradorDTO> adminsDTO = new ArrayList<AdministradorDTO>();
		for(Administrador a : admins){
			adminsDTO.add(new AdministradorDTO(a));
		}
		return adminsDTO;
	}
}
