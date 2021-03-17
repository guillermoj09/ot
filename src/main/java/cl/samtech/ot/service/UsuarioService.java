package cl.samtech.ot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import cl.samtech.ot.UsuarioLogin;
import model.Usuario;
import model.UsuariosTran;

public class UsuarioService {
	
	private static EntityManager em;
	private static EntityManager em1;
	private static EntityManager em2;
	
	final static Logger logger = Logger.getLogger(InstalacionService.class);
	
	
	
	public static UsuarioLogin findUsuarioLogin(String idUsuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();

		Query query = em.createQuery("select u from UsuariosTran u where u.id.usuario = :usuario");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

		query.setParameter("usuario", idUsuario);
		List<UsuariosTran> usuarios = query.getResultList();

		UsuarioLogin usuariol = new UsuarioLogin();

		if (usuarios.isEmpty() != true) {
			usuariol.setPassword(usuarios.get(0).getPassword());
			usuariol.setNombre(usuarios.get(0).getNombres());
			usuariol.setApellidos(usuarios.get(0).getApellidos());
			usuariol.setRolDescripcion(usuarios.get(0).getTipo());
			usuariol.setUsername(idUsuario);
		}

		em.clear();
		em.close();

		return usuariol;
	}

	public static Usuario findUsuario(String idUsuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em = emf.createEntityManager();

		Usuario usuario = em.find(Usuario.class, idUsuario);
		em.refresh(usuario);
		em.clear();
		em.close();

		return usuario;
	}

}
