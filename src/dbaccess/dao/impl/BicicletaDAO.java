package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;

import dbaccess.dto.BicicletaDTO;
import model.Bicicleta;
import model.Estacion;

public class BicicletaDAO extends GenericDAO {

	public Integer create(Bicicleta bici) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(bici);
		this.getEntityManager().getTransaction().commit();
		return bici.getId();

	}

	public BicicletaDTO getBicicleta(Integer id) {
		Bicicleta bicicleta = null;
		BicicletaDTO bicicletaDTO = new BicicletaDTO();
		System.out.println("valor de id antes de la query: " + id);
		String query = "from Bicicleta a where a.id = :id ";
		try {
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()) {
			bicicleta = (Bicicleta) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (bicicleta != null) {
			bicicletaDTO = new BicicletaDTO(bicicleta);
		}
		System.out.println("valor de nombre de bicicletaDTO despues de la query" + bicicletaDTO.getNumeroCuadro());
	}		
	catch (NoResultException e) {
		return bicicletaDTO;
	}
		return bicicletaDTO;

	}

	public Bicicleta findById(Integer id) {
		String query = "from Bicicleta a where a.id = :id ";
		System.out.println("Este es el parametro antes de la query: " + id);
		Bicicleta bici;
		try {
		 bici = (Bicicleta) this.getEntityManager().createQuery(query).setParameter("id", id)
				.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
		return bici;
	}

	public void update(Bicicleta bici) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(bici);
		this.getEntityManager().getTransaction().commit();

	}

	public void delete(Bicicleta bici) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(bici);
		this.getEntityManager().getTransaction().commit();
	}

	public Integer getBicicletasLibres(Estacion estacion) {
		String query = "select count (b.id) from Bicicleta b where b.ubicacionActual.nombre  = :nombre ";
		Integer cantidadLibres = 0;
		try {
		 cantidadLibres = estacion.getCantidadBicicletasMax() - Integer.valueOf((this.getEntityManager()
				.createQuery(query).setParameter("nombre", estacion.getNombre()).getSingleResult()).toString());
		}
		catch (NoResultException e) {
			return cantidadLibres;
		}
		return cantidadLibres;

	}

	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAll() {
		String query = "from Bicicleta ";
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();

		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllOrdenUbicacion() {
		String query = "from Bicicleta b order by b.ubicacionActual.nombre";
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();
		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}

	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllOrdenEstado() {
		String query = "from Bicicleta b order by b.estado";
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();
		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		
		return bicisDTO;
	}

	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllOrdenNumeroCuadro() {
		String query = "from Bicicleta b order by b.numeroCuadro";

		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();

		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllLibres() {
		String query = "from Bicicleta b where b.estado = 'Apta' ";
		System.out.println("Estas son las bicis libres no cambia");
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();

		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}

	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllLibresOrdenUbicacion() {
		String query = "from Bicicleta b where b.estado = 'Apta' order by b.ubicacionActual.nombre";
		System.out.println("Estas son las bicis libres no cambia");
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();

		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllLibresOrdenEstado() {
		String query = "from Bicicleta b where b.estado = 'Apta' order by b.estado";
		System.out.println("Estas son las bicis libres no cambia");
		
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();

		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllLibresOrdenNumeroCuadro() {
		String query = "from Bicicleta b where b.estado = 'Apta' order by b.numeroCuadro";
		System.out.println("Estas son las bicis libres no cambia");
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		try {
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();

		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		}
		catch (NoResultException e) {
			return bicisDTO;
		}
		return bicisDTO;
	}

}
