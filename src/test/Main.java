package test;

import dbaccess.dao.impl.AdministradorDAO;
import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.EstacionDAO;
import dbaccess.dao.impl.EstadoDAO;
import dbaccess.dao.impl.UbicacionDAO;
import dbaccess.dao.impl.UsuarioDAO;
import dbaccess.dto.BicicletaDTO;
import dbaccess.dto.EstacionDTO;
import dbaccess.dto.EstadoDTO;
import dbaccess.dto.UsuarioDTO;
import model.Administrador;
import model.Bicicleta;
import model.Estacion;
import model.Estado;
import model.Ubicacion;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creo administrador
		Administrador admin = new Administrador("20987324", "Fernandez", "Juan Antonio", "Calle 7 nro 234", "23-3-1980", "M", "juan@hotmail.com", "password1");
		
		//Creo Estados bicicleta
		Estado estadoApta = new Estado("Apta pasa uso","La bicicleta puede ser usada"); 
		Estado estadoDesuso = new Estado("En desuso","La bicicleta no ha sido usada");
		Estado enReparacion = new Estado("En reparacion","La bicicleta se esta reparando");
		Estado denunciada = new Estado("Denunciada","La bicicleta ha sido denunciada como no apta");
		
		//Creo estados de estaciones
		Estado estadoOperativa = new Estado("Operativa","La estacion se encuentra operativa"); 
		Estado estadoCerrada = new Estado("Cerrada","La estacion no esta cerrada");
		Estado estadoEnConstruccion = new Estado("EnConstruccion","La estacion se encuentra en construccion");
			
		//Creo Ubicaciones
		Ubicacion ubicacionPlazaMoreno = new Ubicacion("-32123213","-3213123");
		Ubicacion ubicacionTerminal = new Ubicacion("543554353","5453543");
		Ubicacion ubicacionEstadioUnico = new Ubicacion("989897","78987989");
		Ubicacion ubicacionPlazaRocha = new Ubicacion("12312313","1231223");
		
		//Creo Estaciones
		Estacion estacionPlazaMoreno = new Estacion("Plaza Moreno","1900","9:00","20:00","UbicacionLatitud1","UbicacionLongitud1","estadoOperativa",100);
		Estacion estacionTerminal = new Estacion("Terminal","1900","8:00","20:00", "UbicacionLongitud2","UbicacionLatitud2","estadoOperativa",80 );
		Estacion estacionEstadioUnico = new Estacion("Estadio Unico","1900","7:00","19:00", "UbicacionLatitud3","UbicacionLongitud3","estadoOperativa",120);
		Estacion estacionPlazaRocha = new Estacion("Plaza Rocha","1900","9:30","21:00", "UbicacionLatitud4","UbicacionLongitud4","estadoOperativa",100);
		
		//Creo los usuarios
		Usuario usuario1 = new Usuario("27893465","Gamarra","Mercedes","Calle 8 nro 987","12-07-1980","F","mercedesgamarra@hotmail.com","password2");
		Usuario usuario2 = new Usuario("22435987","Perez","Maria","Calle 47 nro 908","03-06-1985","F","maria@hotmail.com","password3");
		Usuario usuario3 = new Usuario("29786453","Polo","Gonzalo","Calle 50 nro 324","02-09-1986","M","gonza@hotmail.com","password4");
		Usuario usuario4 = new Usuario("10786543","Gonzalez","Guillermo","Calle 60 nro 687","22-10-1980","M","guillermo@hotmail.com","password5");
		Usuario usuario5 = new Usuario("20975634","Lopez","Antonio","Calle 117 nro 987","10-17-1982","M","lopezantonio@hotmail.com","password6");
		Usuario usuario6 = new Usuario("21098762","Fernandez","Mariana","Calle 66 nro 1200","02-07-1984","F","marianafer@hotmail.com","password7");
		Usuario usuario7 = new Usuario("18902738","Cervinez","Mariano","Calle 80 nro 876","12-01-1990","M","cervinez@hotmail.com","password8");
		Usuario usuario8 = new Usuario("19087234","Saldaña","Roberto","Calle 10 nro 2209","23-11-1992","M","robersaldaña@hotmail.com","password9");
			
		//Creo bicicleta
		Bicicleta bici1 = new Bicicleta("1","23-11-2010","estadoApta",estacionTerminal);
		Bicicleta bici2 = new Bicicleta("2","09-12-2011","estadoApta",estacionTerminal);
		
		Bicicleta bici4 = new Bicicleta("4","06-02-2011","estadoApta",estacionPlazaMoreno);
		Bicicleta bici5 = new Bicicleta("5","20-04-2012","estadoApta",estacionPlazaMoreno);
		
		Bicicleta bici7 = new Bicicleta("7","27-06-2011","estadoApta",estacionEstadioUnico);
		Bicicleta bici8 = new Bicicleta("8","07-08-2015","estadoApta",estacionEstadioUnico);
		Bicicleta bici9 = new Bicicleta("9","21-12-2016","estadoApta",estacionEstadioUnico);
		
		Bicicleta bici10 = new Bicicleta("10","24-10-2012","estadoApta",estacionPlazaRocha);
		Bicicleta bici11 = new Bicicleta("11","02-09-2013","estadoApta",estacionPlazaRocha);
		Bicicleta bici12 = new Bicicleta("12","12-01-2014","estadoApta",estacionPlazaRocha);
		
		//Los usuarios van retirando las bicicletas libres
		//Creo los DAOs antes de persistir
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		BicicletaDAO bicicletaDao= new BicicletaDAO();
		AdministradorDAO administradorDAO = new AdministradorDAO();
		EstacionDAO estacionDAO = new EstacionDAO();
		EstadoDAO estadoDAO = new EstadoDAO();
		UbicacionDAO ubicacionDAO = new UbicacionDAO();
		
		//Persisto el administrador
		administradorDAO.create(admin);
		
		//Persisto los Usuarios
		usuarioDAO.create(usuario1);
		usuarioDAO.create(usuario2);
		usuarioDAO.create(usuario3);
		usuarioDAO.create(usuario4);
		usuarioDAO.create(usuario5);
		usuarioDAO.create(usuario6);
		usuarioDAO.create(usuario7);
		usuarioDAO.create(usuario8);
		
		//Persisto los estados
		estadoDAO.create(estadoEnConstruccion);
		estadoDAO.create(estadoCerrada);
		estadoDAO.create(estadoOperativa);
		estadoDAO.create(estadoDesuso);
		estadoDAO.create(estadoApta);
		estadoDAO.create(denunciada);
		estadoDAO.create(enReparacion);
		
		//Persisto Ubicaciones
		ubicacionDAO.create(ubicacionPlazaRocha);
		ubicacionDAO.create(ubicacionEstadioUnico);
		ubicacionDAO.create(ubicacionTerminal);
		ubicacionDAO.create(ubicacionPlazaMoreno);

		//Persisto estaciones
		estacionDAO.create(estacionPlazaRocha);
		estacionDAO.create(estacionEstadioUnico);
		estacionDAO.create(estacionTerminal);
		estacionDAO.create(estacionPlazaMoreno);
		
		//Persisto bicicletas
		bicicletaDao.create(bici1);
		bicicletaDao.create(bici2);
		bicicletaDao.create(bici4);		
		bicicletaDao.create(bici5);		
		bicicletaDao.create(bici7);
		bicicletaDao.create(bici8);		
		bicicletaDao.create(bici9);
		bicicletaDao.create(bici10);
		bicicletaDao.create(bici11);
		bicicletaDao.create(bici12);		
		
		//Los usuarios retiran bicicleta
		
		usuario1.retirarBicicleta("20-09-2017","21-01-2017",bici1);
		usuario2.retirarBicicleta("06-09-2017","07-01-2017",bici2);
		usuario3.retirarBicicleta("09-01-2017","10-01-2017",bici4);
		usuario4.retirarBicicleta("13-02-2017","14-02-2017",bici5);
		usuario5.retirarBicicleta("23-09-2017","24-09-2017",bici7);
		usuario6.retirarBicicleta("06-09-2017","07-02-2017",bici8);
		usuario6.retirarBicicleta("22-05-2017","23-05-2017",bici9);
		usuario7.retirarBicicleta("10-03-2017","11-03-2017",bici10);
		usuario7.retirarBicicleta("01-03-2017","02-03-20º7",bici12);
		usuario8.retirarBicicleta("04-04-2017","05-04-2017",bici11);
		
		//Se denuncia la bici 1 y 2
		bici1.denunciarBicicleta(usuario1,"Los cambios estan rotos");
		bici2.denunciarBicicleta(usuario2,"El cuadro esta torcido");
		
		//Armo e imprimo listado Usuario
	    for(UsuarioDTO  u: usuarioDAO.getAll()){
	    	System.out.println(u.toString());
	    }
		
		//Armo e imprimo listado Estaciones
	    for(EstacionDTO  u: estacionDAO.getAll()){
	    	System.out.println(u.toString());
	    }
	    
		//Armo e imprimo listado Bicicleta
	    for(BicicletaDTO  u: bicicletaDao.getAll()){
	    	System.out.println(u.toString());
	    }
	    
		//Armo e imprimo listado Estado
	    for(EstadoDTO  u: estadoDAO.getAll()){
	    	System.out.println(u.toString());
	    }
	    
	    
		//Armo e imprimo listado Bicicleta
	    for(BicicletaDTO  u: bicicletaDao.getAll()){
	    	System.out.println(u.toString());
	    }
	}

}

