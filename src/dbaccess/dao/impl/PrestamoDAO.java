package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
		Prestamo prestamo = (Prestamo) this.getEntityManager().createQuery(query).setParameter("id", id)
				.getSingleResult();
		PrestamoDTO prestamoDTO = new PrestamoDTO(prestamo);
		return prestamoDTO;

	}

	public void update(Prestamo prestamo) {

		this.getEntityManager().getTransaction().begin();
		Prestamo prestamoTemp =  this.findById(prestamo.getIdPrestamo());
		this.getEntityManager().refresh(prestamoTemp);
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
		Prestamo prestamo = (Prestamo) this.getEntityManager().createQuery(query)
				.setParameter("idBicibleta", idBicicleta).setParameter("idUsuario", idUsuario).setMaxResults(1).getSingleResult();
		return prestamo;

	}
	
	public Prestamo findById(Integer id){
		String query = "from Prestamo a where a.id = :id ";
		Prestamo prestamo = (Prestamo) this.getEntityManager().createQuery(query).setParameter("id", id)
				.getSingleResult();
		return prestamo;

	}

	public List<PrestamoDTO> getAll(){
		String query = "from Prestamo ";
		@SuppressWarnings("unchecked")
		List<Prestamo> prestamos = (List<Prestamo>)this.getEntityManager().createQuery(query).getResultList();
		List<PrestamoDTO> prestamosDTO = new ArrayList<PrestamoDTO>();
		for(Prestamo a : prestamos){
			prestamosDTO.add(new PrestamoDTO(a));
		}
		return prestamosDTO;
	}
	
}
