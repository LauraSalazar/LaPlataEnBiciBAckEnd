package test;

import java.util.HashMap;
import java.util.Map;

import model.Usuario;

public class UsuarioMockService {
	
	public static Map<Integer,Usuario> aMap = new HashMap<Integer,Usuario>();

	public static Map<Integer, Usuario> getaMap() {
		return aMap;
	}

	public static void setaMap(Map<Integer, Usuario> aMap) {
		UsuarioMockService.aMap = aMap;
	}
	
	public static void addUsuario(Usuario u){
	    aMap.put(u.getId(), u) ;
	}
	
	public static Usuario getUsuario(Integer id){
	    return aMap.get(id) ;
	}

	public static Map<Integer,Usuario> getUsuarios(){
	    return aMap;
	}
	
}
