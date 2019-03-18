package web.service;

import java.util.Date;
import java.util.List;

import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.PrestamoDAO;
import dbaccess.dao.impl.UsuarioDAO;
import dbaccess.dto.PrestamoDTO;
import model.Bicicleta;
import model.Denuncia;
import model.Prestamo;
import model.Usuario;

public class PrestamoService {

	PrestamoDAO prestamoDAO;
	BicicletaDAO bicicletaDAO;
	UsuarioDAO usuarioDAO;

	public PrestamoService() {
		super();
		prestamoDAO = new PrestamoDAO();
		bicicletaDAO = new BicicletaDAO();
		usuarioDAO = new UsuarioDAO();
	}

	public PrestamoDTO retirarBicicleta(Integer idBicicleta, Integer idUsuario) {

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
		return (new PrestamoDTO(p));
	}

	public PrestamoDTO getPrestamo(Integer id) {
		return this.prestamoDAO.getPrestamo(id);
	}

	public List<PrestamoDTO> getMisPrestamos(Integer id) {
		return this.prestamoDAO.getMisPrestamos(id);

	}

	public List<PrestamoDTO> devolverBicicletaConDenuncia(Integer idUsuario, Integer idBicicleta, Integer idPrestamo,
			String comentario) {

		Denuncia d = new Denuncia();
		d.setHechos(comentario);
		Date dia = new Date();
		d.setFecha(dia.toString());
		Prestamo p = prestamoDAO.findById(idPrestamo);
		p.setFechafin(dia.toString());
		p.setDenuncia(d);
		prestamoDAO.update(p);
		Bicicleta b = bicicletaDAO.findById(idBicicleta);
		b.setEstado("Denunciada");
		bicicletaDAO.update(b);
		return (prestamoDAO.getMisPrestamos(idUsuario));
	}

	public List<PrestamoDTO> devolverBicicletaSinDenuncia(Integer idUsuario, Integer idBicicleta, Integer idPrestamo) {
		Date dia = new Date();
		Prestamo p = prestamoDAO.findById(idPrestamo);
		p.setFechafin(dia.toString());
		prestamoDAO.update(p);
		Bicicleta b = bicicletaDAO.findById(idBicicleta);
		b.setEstado("Apta");
		bicicletaDAO.update(b);
		return (prestamoDAO.getMisPrestamos(idUsuario));
	}

	// Busca el pretamo asociado y le pone una fecha de fin
	public Prestamo findRelatedAndUpdate(Integer idBicicleta) {
		Prestamo miPrestamo = prestamoDAO.findRelated(idBicicleta);
		if (miPrestamo != null) {
			Date dia = new Date();
			miPrestamo.setFechafin(dia.toString());
			prestamoDAO.update(miPrestamo);
		}
		return miPrestamo;
	}
}
