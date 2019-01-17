package web.resource;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.DatatypeConverter;

import dbaccess.dto.AuthorizationDTO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import web.service.BicicletaService;
import web.service.UsuarioService;

@Path("/loginAuth")
public class AuthenticationResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Integer id;
	UsuarioService usuarioService;

	public AuthenticationResource(UriInfo uriInfo, Request request, Integer id) {
		super();
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		usuarioService = new UsuarioService();
	}

	public AuthenticationResource() {
		super();
		usuarioService = new UsuarioService();
	}

	@GET
	@Path("/loginService/{dni}/{password}")
	public Response getBicicleta(@PathParam("dni") String dni, @PathParam("password") String password) {
		Response response;

		// Variable para saber si es administrador, usuario o no esta autenticado
		// 0 => No esta autenticado
		// 1 => Es usuario
		// 2 => Es administrador
		Integer categoria = 0;

		// Pregunto si es usuario
		if (dni != null && password != null) {
			System.out.println("Entro en diferente de null");
			categoria = this.usuarioService.validateUser(dni, password) ? 1 : 0;
			if (categoria.equals(0)) {
				categoria = this.usuarioService.validateAdmin(dni, password) ? 2 : 0;
			}
		}
		
		try {
			AuthorizationDTO auth = new AuthorizationDTO();
			if (!categoria.equals(0)) {
				auth.setAuthorization(armarJwt(dni));
				auth.setUsuario(usuarioService.findByDni(dni));
			}
			auth.setCategoria(categoria);
			response = Response.ok(auth).build();
		} 
		catch (Exception e) {
			response = Response.status(500).build();
		}
		return response;
	}

	// Armo el token en base al usuario y contraseña
	public String armarJwt(String dni) {
		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("laplataenbici");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(dni).setIssuedAt(now).signWith(signatureAlgorithm, signingKey);

		long expMillis = nowMillis + 60000;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp);

		System.out.println("Este es el token " + builder.compact());
		return builder.compact();
	}
}
