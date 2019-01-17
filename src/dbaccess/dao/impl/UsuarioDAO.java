package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import dbaccess.dto.UsuarioDTO;
import model.Administrador;
import model.Usuario;

public class UsuarioDAO extends GenericDAO {

	public Integer create(Usuario usuario) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(usuario);
		this.getEntityManager().getTransaction().commit();
		return usuario.getId();

	}

	public UsuarioDTO getUsuario(Integer id) {
		Usuario usuario = null;
		UsuarioDTO usuarioDTO = null;
		String query = "from Usuario a where a.id = :id ";
		try {
			if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()) {
				usuario = (Usuario) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
			}
			if (usuario != null) {
				usuarioDTO = new UsuarioDTO(usuario);
			}
		} catch (NoResultException e) {
			return new UsuarioDTO();
		}
		return usuarioDTO;

	}

	public void update(Usuario usuario) {

		this.getEntityManager().getTransaction().begin();
		Usuario usuarioTemp = this.findById(usuario.getId());
		this.getEntityManager().refresh(usuarioTemp);
		this.getEntityManager().getTransaction().commit();

	}

	public void delete(Usuario usuario) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(usuario);
		this.getEntityManager().getTransaction().commit();
	}

	public Usuario findById(Integer id) {
		String query = "from Usuario a where a.id = :id ";
		Usuario usuario = new Usuario();
		try {
			usuario = (Usuario) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();

		} catch (NoResultException e) {
			return new Usuario();
		}
		return usuario;
	}
	
	public Integer findByDni(String dni) {
		String query = "from Usuario a where a.dni = :dni ";
		Usuario usuario = new Usuario();
		try {
			usuario = (Usuario) this.getEntityManager().createQuery(query).setParameter("dni", dni).getSingleResult();

		} catch (NoResultException e) {
			return new Integer(-1);
		}
		return usuario.getId();
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioDTO> getAll() {
		String query = "from Usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		try {
			usuarios = (List<Usuario>) this.getEntityManager().createQuery(query).getResultList();
			if (usuarios != null) {
				for (Usuario a : usuarios) {
					usuariosDTO.add(new UsuarioDTO(a));
				}
			}
		} catch (NoResultException e) {
			return usuariosDTO;
		}
		return usuariosDTO;
	}

	public Boolean validarUsuario(String dni, String password) {
		Boolean resultado = false;

		String query = "from Usuario a where a.dni = :dni and a.password= :password";
		try {
			Usuario usuario = (Usuario) this.getEntityManager().createQuery(query).setParameter("dni", dni)
					.setParameter("password", password).getSingleResult();
			if (usuario != null) {
				resultado = true;
			}
		} catch (NoResultException e) {
			return false;
		}
		return resultado;

	}

	public Boolean validarAdministrador(String dni, String password) {

		Boolean resultado = false;

		String query = "from Administrador a where a.dni = :dni and a.password= :password";
		try {
			Administrador admin = (Administrador) this.getEntityManager().createQuery(query).setParameter("dni", dni)
					.setParameter("password", password).getSingleResult();
			if (admin != null) {
				resultado = true;
			}
		} catch (NoResultException e) {
			return false;
		}
		return resultado;

	}

}
