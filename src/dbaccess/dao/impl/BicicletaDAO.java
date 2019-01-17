package dbaccess.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dbaccess.dto.BicicletaDTO;
import dbaccess.dto.EstacionDTO;
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
		BicicletaDTO bicicletaDTO = null;
		System.out.println("valor de id antes de la query: " + id);
		String query = "from Bicicleta a where a.id = :id ";
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()) {
			bicicleta = (Bicicleta) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (bicicleta != null) {
			bicicletaDTO = new BicicletaDTO(bicicleta);
		}
		System.out.println("valor de nombre de bicicletaDTO despues de la query" + bicicletaDTO.getNumeroCuadro());
		return bicicletaDTO;

	}

	public Bicicleta findById(Integer id) {
		String query = "from Bicicleta a where a.id = :id ";
		System.out.println("Este es el parametro antes de la query: " + id);
		Bicicleta bici = (Bicicleta) this.getEntityManager().createQuery(query).setParameter("id", id)
				.getSingleResult();
		return bici;
	}

	public void update(Bicicleta bici) {
		this.getEntityManager().getTransaction().begin();
		Bicicleta biciTemp = this.findById(bici.getId());
		this.getEntityManager().refresh(biciTemp);
		this.getEntityManager().getTransaction().commit();

	}

	public void delete(Bicicleta bici) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(bici);
		this.getEntityManager().getTransaction().commit();
	}

	public Integer getBicicletasLibres(Estacion estacion) {
		String query = "select count (b.id) from Bicicleta b where b.ubicacionActual.nombre  = :nombre ";
		Integer cantidadLibres = estacion.getCantidadBicicletasMax() - Integer.valueOf((this.getEntityManager()
				.createQuery(query).setParameter("nombre", estacion.getNombre()).getSingleResult()).toString());
		return cantidadLibres;

	}

	public List<BicicletaDTO> getAll() {
		String query = "from Bicicleta ";
		@SuppressWarnings("unchecked")
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		return bicisDTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<BicicletaDTO> getAllLibres() {
		String query = "from Bicicleta b where b.estado = 'estadoApta' ";
		System.out.println("Estas son las bicis libres");
		List<Bicicleta> bicis = (List<Bicicleta>) this.getEntityManager().createQuery(query).getResultList();
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		for (Bicicleta a : bicis) {
			bicisDTO.add(new BicicletaDTO(a));
		}
		return bicisDTO;
	}

	public List<BicicletaDTO> getMisBicicletas(Integer id) {

		//String query = "select b.id, b.numeroCuadro, b.estado, e.nombre from Prestamo p left join fetch p.bicicleta b left join fetch b.estacion e where p.usuario.id = :id  ";
		String query = "select p.bicicleta.id, p.bicicleta.numeroCuadro, p.bicicleta.estado, p.bicicleta.ubicacionActual.nombre from Prestamo p  where p.usuario.id = :id and p.fechafin is null";
		System.out.println("Esta es la query: " + query + " y este es el id " + id);
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		List s = this.getEntityManager().createQuery(query).setParameter("id", id).getResultList();
		Iterator i = s.iterator();
		while (i.hasNext()) {
			Object[] reg = (Object[]) i.next();
			BicicletaDTO b = new BicicletaDTO();
			b.setId((Integer) reg[0]);
			b.setNumeroCuadro((String) reg[1]);
			b.setEstado((String) reg[2]);
			b.setUbicacionActual((String) reg[3]);

			bicisDTO.add(b);
			System.out.println("Despues de la consulta me devuelve registros" + reg[0]);
		}

		return bicisDTO;

	}
	
}
