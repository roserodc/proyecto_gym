package proyecto_gym.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import proyecto_gym.model.entities.Usuario;

/**
 * Session Bean implementation class ManagerUsuarios
 */
@Stateless
@LocalBean
public class ManagerUsuarios {
	@PersistenceContext(unitName = "gymutnDS")
	private EntityManager em;

	public ManagerUsuarios() {
	}

	public boolean comprobarUsuario(String userCi, String clave) throws Exception {
		Usuario u = em.find(Usuario.class, userCi);
		if (u == null)
			throw new Exception("No existe el usuario " + userCi);
//		if (!u.getActivo())
//			throw new Exception("El usuario no está activo.");
		if (u.getUserPass().equals(clave))
			return true;
		throw new Exception("Contraseña no válida.");
	}
}
