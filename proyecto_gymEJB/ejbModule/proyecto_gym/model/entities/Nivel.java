package proyecto_gym.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEL_NIID_GENERATOR", sequenceName="SEQ_NIVEL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEL_NIID_GENERATOR")
	@Column(name="ni_id")
	private long niId;

	@Column(name="ni_descripcion")
	private String niDescripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="nivel")
	private List<Usuario> usuarios;

	public Nivel() {
	}

	public long getNiId() {
		return this.niId;
	}

	public void setNiId(long niId) {
		this.niId = niId;
	}

	public String getNiDescripcion() {
		return this.niDescripcion;
	}

	public void setNiDescripcion(String niDescripcion) {
		this.niDescripcion = niDescripcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setNivel(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setNivel(null);

		return usuario;
	}

}