package proyecto_gym.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto_gym.model.manager.ManagerUsuarios;
import proyecto_gym.view.util.JSFUtil;


@Named
@SessionScoped
public class ControllerUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userCi;
	private String clave;

	@EJB
	private ManagerUsuarios managerUsuarios;

	public String actionLogin() {
		try {
			boolean respuesta = managerUsuarios.comprobarUsuario(userCi, clave);
			JSFUtil.createMensajeInfo("Login correcto");
			// verificamos si el acceso es con admin:
//			if (idUsuario.equals("admin")) {
				return "admin/indexAdmin";
//			}
//			return "blog/index";
		} catch (Exception e) {
			JSFUtil.createMensajeError(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	public String getUserCi() {
		return userCi;
	}

	public void setUserCi(String userCi) {
		this.userCi = userCi;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
