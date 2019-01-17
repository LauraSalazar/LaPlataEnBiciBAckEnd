package servlets;

import java.io.IOException;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import web.service.UsuarioService;

@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Seteo el host
	private final String host = "http://localhost:4200/";
	
	//Este es el host del servidor de la catedra
	//private final String localhost = "http://localhost:4200/";
	UsuarioService usuarioService = null;
	
	public void init() {
		usuarioService = new UsuarioService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Consigo los parametros
		String dni = request.getParameter("dni");
		String password = request.getParameter("password");
		
		//Variable para saber si es administrador
		Boolean esAdmin = false;
		Boolean esUsuario = false;

		//Pregunto si es usuario
		if (dni != null && password != null) {

			esUsuario = this.usuarioService.validateUser(dni, password);

			if (esUsuario) {
				response.addHeader("token-key", armarJwt(dni));
				response.sendRedirect(host+"usuarioview"+"?user="+dni);
			}

		}
		
		//Pregunto si es administrador y tiene credenciales correctas
		if (!esUsuario) {
			esAdmin = this.usuarioService.validateAdmin(dni,password);
			if (esAdmin) {
				response.addHeader("token-key", armarJwt(dni));
				response.sendRedirect(host+"administradorview");
				

				}
		}
		
		if (!esAdmin && !esUsuario){
			response.sendRedirect("/LaPlataEnBici");
		}

	}

	//Armo el token en base al usuario y contraseña
	public String armarJwt(String dni) {
		//The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	       
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	    
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("laplataenbici");
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    
		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setIssuer(dni).signWith(signatureAlgorithm, signingKey);
		
		long expMillis = nowMillis + 900000;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
		
		System.out.println("Este es el token " + builder.compact());
		return builder.compact();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}