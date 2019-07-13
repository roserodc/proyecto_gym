package proyecto_gym.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARRERA_CAID_GENERATOR", sequenceName="SEQ_CARRERA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARRERA_CAID_GENERATOR")
	@Column(name="ca_id")
	private long caId;

	@Column(name="ca_acronimo")
	private String caAcronimo;

	@Column(name="ca_descripcion")
	private String caDescripcion;

	//bi-directional many-to-one association to Facultad
	@ManyToOne
	@JoinColumn(name="f_id_facultad")
	private Facultad facultad;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="carrera")
	private List<Usuario> usuarios;

	public Carrera() {
	}

	public long getCaId() {
		return this.caId;
	}

	public void setCaId(long caId) {
		this.caId = caId;
	}

	public String getCaAcronimo() {
		return this.caAcronimo;
	}

	public void setCaAcronimo(String caAcronimo) {
		this.caAcronimo = caAcronimo;
	}

	public String getCaDescripcion() {
		return this.caDescripcion;
	}

	public void setCaDescripcion(String caDescripcion) {
		this.caDescripcion = caDescripcion;
	}

	public Facultad getFacultad() {
		return this.facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCarrera(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCarrera(null);

		return usuario;
	}

}