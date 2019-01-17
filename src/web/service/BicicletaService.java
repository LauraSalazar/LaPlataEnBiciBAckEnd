package web.service;

import java.util.Date;
import java.util.List;

import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.EstacionDAO;
import dbaccess.dao.impl.PrestamoDAO;
import dbaccess.dao.impl.UsuarioDAO;
import dbaccess.dto.BicicletaDTO;
import dbaccess.dto.EstacionDTO;
import model.Bicicleta;
import model.Estacion;
import model.Prestamo;
import model.Usuario;

public class BicicletaService {

	BicicletaDAO bicicletaDAO;
	UsuarioDAO usuarioDAO;
	PrestamoDAO prestamoDAO;

	public BicicletaService() {
		super();
		bicicletaDAO = new BicicletaDAO();
		usuarioDAO = new UsuarioDAO();
		prestamoDAO = new PrestamoDAO();
	}

	public BicicletaDTO getBicicleta(Integer id) {
		return (bicicletaDAO.getBicicleta(id));
	}

	public List<BicicletaDTO> getAll() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAll();
		return (bicicletasDTO);
	}

	public void delete(Integer id) {
		Bicicleta bicicleta = bicicletaDAO.findById(id);
		bicicletaDAO.delete(bicicleta);
	}

//String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta, String estado, String ubicacionLatitud, String ubicacionLongitud, Integer cantidad
//estacion.getNombre(), estacion.getCodigoPostal(), estacion.getEstado(), estacion.getUbicacionActual(), estacion.getAbiertoDesde(), estacion.getAbiertoHasta(), estacion.getCantidadBicicletasMax()
	public Integer create(String numeroCuadro, String fechaIngreso, String estado, Estacion estacion) {
		return bicicletaDAO.create(new Bicicleta(numeroCuadro, fechaIngreso, estado, estacion));
	}

	public void update(Integer id, String fechaIngreso, String estado, Integer estacionId) {

		EstacionService estacionService = new EstacionService();
		Estacion estacion = estacionService.findById(estacionId);
		Bicicleta bicicleta = bicicletaDAO.findById(id);
		bicicleta.setId(id);
		bicicleta.setFechaIngreso(fechaIngreso);
		bicicleta.setEstado(estado);
		bicicleta.setUbicacionActual(estacion);

		bicicletaDAO.update(bicicleta);
	}
	
	public List<BicicletaDTO> getMisBicicletas(Integer id) {
		return this.bicicletaDAO.getMisBicicletas(id);
		
	}
	
	public List<BicicletaDTO> getAllLibres() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllLibres();
		return (bicicletasDTO);
	}
	
	public BicicletaDTO retirarBicicleta(Integer idBicicleta, Integer idUsuario) {
		
		Bicicleta b = bicicletaDAO.findById(idBicicleta);
		Usuario u = usuarioDAO.findById(idUsuario);
		
		Prestamo p = new Prestamo();
		p.setBicicleta(b);
		b.setEstado("prestada");
		Date d = new Date();
		p.setFechaInicio(d.toString());
		p.setUser(u);
		prestamoDAO.create(p);
		bicicletaDAO.update(b);
		return (new BicicletaDTO(b));
	}
	
}
