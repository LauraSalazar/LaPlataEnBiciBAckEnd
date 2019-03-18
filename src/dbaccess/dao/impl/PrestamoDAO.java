package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;

import dbaccess.dto.BicicletaDTO;
import dbaccess.dto.PrestamoDTO;
import model.Bicicleta;
import model.Prestamo;

public class PrestamoDAO extends GenericDAO {

	public void create(Prestamo prestamo) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(prestamo);
		this.getEntityManager().getTransaction().commit();

	}

	public PrestamoDTO getPrestamo(Integer id) {

		String query = "from Prestamo a where a.id = :id ";
		PrestamoDTO prestamoDTO = new PrestamoDTO();
		try {
		Prestamo prestamo = (Prestamo) this.getEntityManager().createQuery(query).setParameter("id", id)
				.getSingleResult();
		 prestamoDTO = new PrestamoDTO(prestamo);
		}
		catch (NoResultException e) {
			return prestamoDTO;
		}
		return prestamoDTO;

	}

	public void update(Prestamo prestamo) {

		this.getEntityManager().getTransaction().begin();
		Prestamo prestamoTemp =  this.findById(prestamo.getIdPrestamo());
		this.getEntityManager().merge(prestamoTemp);
		this.getEntityManager().getTransaction().commit();

	}

	public void delete(Bicicleta prestamo) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(prestamo);
		this.getEntityManager().getTransaction().commit();
	}

	// prestamoDAO.getPrestamo(this.getId(),usuario.getId());

	public Prestamo getPrestamo(Integer idBicicleta, Integer idUsuario) {

		String query = "from Prestamo a where a.bicicleta.id = :idBicibleta and a.usuario.id = :idUsuario order by a.id";
		Prestamo prestamo = new Prestamo();
		try {
		 prestamo = (Prestamo) this.getEntityManager().createQuery(query)
				.setParameter("idBicibleta", idBicicleta).setParameter("idUsuario", idUsuario).setMaxResults(1).getSingleResult();
		}
		catch (NoResultException e) {
			return prestamo;
		}
		return prestamo;

	}
	
	public Prestamo findById(Integer id){
		String query = "from Prestamo a where a.id = :id ";
		Prestamo prestamo = new Prestamo();
		try {
		 prestamo = (Prestamo) this.getEntityManager().createQuery(query).setParameter("id", id)
				.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
		return prestamo;

	}

	@SuppressWarnings("unchecked")
	public List<PrestamoDTO> getAll(){
		String query = "from Prestamo ";
		List<PrestamoDTO> prestamosDTO = new ArrayList<PrestamoDTO>();		
		try {
		List<Prestamo> prestamos = (List<Prestamo>)this.getEntityManager().createQuery(query).getResultList();

		for(Prestamo a : prestamos){
			prestamosDTO.add(new PrestamoDTO(a));
		}
		}
		catch(NoResultException e) {
			return prestamosDTO;
		}
		return prestamosDTO;
	}
	
	public List<PrestamoDTO> getMisPrestamos(Integer id) {

		String query = "from Prestamo p  where p.usuario.id = :id and p.fechafin is null";
		System.out.println("Esta es la query: " + query + " y este es el id " + id);
		List<PrestamoDTO> prestamosDTO = new ArrayList<PrestamoDTO>();
		
		try {
		List<Prestamo> misPrestamos = (List<Prestamo>) this.getEntityManager().createQuery(query).setParameter("id", id).getResultList();
		
		for (Prestamo p: misPrestamos) {
			prestamosDTO.add(new PrestamoDTO(p));
		}
		}
		catch(NoResultException e) {
			return prestamosDTO;
		}
 
		return prestamosDTO;

	}
	
	public Prestamo findRelated(Integer idBicicleta) {
		String query = "from Prestamo a where a.bicicleta.id = :id and a.fechafin is null";
		System.out.println("Esta es la query: " + query + " y este es el id " + idBicicleta);
		Prestamo prestamo;
		try {
		 prestamo = (Prestamo) this.getEntityManager().createQuery(query).setParameter("id", idBicicleta)
				.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
		return prestamo;
	}
	
}


