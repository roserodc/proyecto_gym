package proyecto_gym.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the peticion database table.
 * 
 */
@Entity
@NamedQuery(name="Peticion.findAll", query="SELECT p FROM Peticion p")
public class Peticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PETICION_PTCID_GENERATOR", sequenceName="SEQ_PETICION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PETICION_PTCID_GENERATOR")
	@Column(name="ptc_id")
	private long ptcId;

	@Column(name="ptc_fecha")
	private String ptcFecha;

	@Column(name="ptc_hora_fin")
	private String ptcHoraFin;

	@Column(name="ptc_hora_inicio")
	private String ptcHoraInicio;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="est_id_estados")
	private Estado estado;

	//bi-directional many-to-one association to GuiaEntrenamiento
	@ManyToOne
	@JoinColumn(name="ge_id_guia_entrenamiento")
	private GuiaEntrenamiento guiaEntrenamiento;

	//bi-directional many-to-one association to TipoPeticion
	@ManyToOne
	@JoinColumn(name="tp_id_tipo_peticion")
	private TipoPeticion tipoPeticion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user_id_usuario")
	private Usuario usuario;

	public Peticion() {
	}

	public long getPtcId() {
		return this.ptcId;
	}

	public void setPtcId(long ptcId) {
		this.ptcId = ptcId;
	}

	public String getPtcFecha() {
		return this.ptcFecha;
	}

	public void setPtcFecha(String ptcFecha) {
		this.ptcFecha = ptcFecha;
	}

	public String getPtcHoraFin() {
		return this.ptcHoraFin;
	}

	public void setPtcHoraFin(String ptcHoraFin) {
		this.ptcHoraFin = ptcHoraFin;
	}

	public String getPtcHoraInicio() {
		return this.ptcHoraInicio;
	}

	public void setPtcHoraInicio(String ptcHoraInicio) {
		this.ptcHoraInicio = ptcHoraInicio;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public GuiaEntrenamiento getGuiaEntrenamiento() {
		return this.guiaEntrenamiento;
	}

	public void setGuiaEntrenamiento(GuiaEntrenamiento guiaEntrenamiento) {
		this.guiaEntrenamiento = guiaEntrenamiento;
	}

	public TipoPeticion getTipoPeticion() {
		return this.tipoPeticion;
	}

	public void setTipoPeticion(TipoPeticion tipoPeticion) {
		this.tipoPeticion = tipoPeticion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}