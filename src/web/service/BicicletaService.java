package web.service;


import java.util.List;

import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.PrestamoDAO;
import dbaccess.dao.impl.UsuarioDAO;
import dbaccess.dto.BicicletaDTO;
import model.Bicicleta;
import model.Estacion;

public class BicicletaService {

	BicicletaDAO bicicletaDAO;

	public BicicletaService() {
		super();
		bicicletaDAO = new BicicletaDAO();
	}

	public BicicletaDTO getBicicleta(Integer id) {
		return (bicicletaDAO.getBicicleta(id));
	}

	public List<BicicletaDTO> getAll() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAll();
		return (bicicletasDTO);
	}
	
	public List<BicicletaDTO> getAllOrdenUbicacion() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllOrdenUbicacion();
		return (bicicletasDTO);
	}
	
	public List<BicicletaDTO> getAllOrdenEstado() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllOrdenEstado();
		return (bicicletasDTO);
	}
	
	public List<BicicletaDTO> getAllOrdenNumeroCuadro() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllOrdenNumeroCuadro();
		return (bicicletasDTO);
	}

	public void delete(Integer id) {
		Bicicleta bicicleta = bicicletaDAO.findById(id);
		bicicletaDAO.delete(bicicleta);
	}

//String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta, String estado, String ubicacionLatitud, String ubicacionLongitud, Integer cantidad
//estacion.getNombre(), estacion.getCodigoPostal(), estacion.getEstado(), estacion.getUbicacionActual(), estacion.getAbiertoDesde(), estacion.getAbiertoHasta(), estacion.getCantidadBicicletasMax()
	public Integer create(String numeroCuadro, String fechaIngreso, String estado, Estacion estacion) {
		System.out.println("Esto viene como fecha de hoy en el Servicio: " + fechaIngreso);
		return bicicletaDAO.create(new Bicicleta(numeroCuadro, fechaIngreso, estado, estacion));
	}

	public void update(Integer id, String numeroCuadro,String fechaIngreso, String estado, Integer estacionId) {

		EstacionService estacionService = new EstacionService();
		Estacion estacion = estacionService.findById(estacionId);
		Bicicleta bicicleta = bicicletaDAO.findById(id);
		bicicleta.setFechaIngreso(fechaIngreso);
		bicicleta.setEstado(estado);
		bicicleta.setUbicacionActual(estacion);
		bicicleta.setNumeroCuadro(numeroCuadro);

		bicicletaDAO.update(bicicleta);
	}
	

	
	public List<BicicletaDTO> getAllLibres() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllLibres();
		return (bicicletasDTO);
	}
	
	public List<BicicletaDTO> getAllLibresOrdenUbicacion() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllLibresOrdenUbicacion();
		return (bicicletasDTO);
	}
	
	public List<BicicletaDTO> getAllLibresOrdenEstado() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllLibresOrdenEstado();
		return (bicicletasDTO);
	}
	
	public List<BicicletaDTO> getAllLibresOrdenNumeroCuadro() {
		List<BicicletaDTO> bicicletasDTO = bicicletaDAO.getAllLibresOrdenNumeroCuadro();
		return (bicicletasDTO);
	}
}
