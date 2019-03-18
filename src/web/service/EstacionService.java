package web.service;

import java.util.List;

import dbaccess.dao.impl.EstacionDAO;
import dbaccess.dto.EstacionDTO;
import model.Estacion;


public class EstacionService {
	
	EstacionDAO estacionDAO;

	public EstacionService(){
		super();
		estacionDAO = new EstacionDAO();
	}

public EstacionDTO getEstacion(Integer id){
	return (estacionDAO.getEstacion(id));
}

public Estacion findById(Integer id){
	return (estacionDAO.findById(id) );
}


public List<EstacionDTO> getAll(){
	List<EstacionDTO> estacionesDTO = estacionDAO.getAll();
	return (estacionesDTO);
}

public void delete (Integer id){
	Estacion estacion = estacionDAO.findById(id);
	estacionDAO.delete(estacion);
}

//String nombre, String codigoPostal, String abiertoDesde, String abiertoHasta,String ubicacionLatitud, String ubicacionLongitud, String estado, Integer cantidad
public Integer create(String nombre,String codigoPostal,String abiertoDesde, String abiertoHasta, String ubicacionLatitud, String ubicacionLongitud,String estado, Integer cantidadBicicletasMax){
	 return estacionDAO.create(new Estacion(nombre,codigoPostal,abiertoDesde,abiertoHasta,ubicacionLatitud,ubicacionLongitud,estado,cantidadBicicletasMax));
}

public void update(Integer id,String nombre,String codigoPostal,String abiertoDesde,String abiertoHasta,String estado, String ubicacionLatitud, String ubicacionLongitud, Integer cantidadBicicletasMax){
	
	System.out.println("Este es el id que mando: " + id);
	Estacion estacion = estacionDAO.findById(id); 
	estacion.setNombre(nombre);
	estacion.setCodigoPostal(codigoPostal);
	estacion.setAbiertoDesde(abiertoDesde);
	estacion.setAbiertoHasta(abiertoHasta);
	estacion.setEstado(estado);
	estacion.setUbicacionLatitud(ubicacionLatitud);
	estacion.setUbicacionLongitud(ubicacionLongitud);
	estacion.setCantidadBicicletasMax(cantidadBicicletasMax);
	estacionDAO.update(estacion);
}
	
}





