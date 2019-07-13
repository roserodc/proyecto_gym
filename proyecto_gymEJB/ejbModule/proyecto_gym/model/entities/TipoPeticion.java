package proyecto_gym.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_peticion database table.
 * 
 */
@Entity
@Table(name="tipo_peticion")
@NamedQuery(name="TipoPeticion.findAll", query="SELECT t FROM TipoPeticion t")
public class TipoPeticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PETICION_TPID_GENERATOR", sequenceName="SEQ_TIPO_PETICION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PETICION_TPID_GENERATOR")
	@Column(name="tp_id")
	private long tpId;

	@Column(name="tp_descripcion")
	private String tpDescripcion;

	//bi-directional many-to-one association to Peticion
	@OneToMany(mappedBy="tipoPeticion")
	private List<Peticion> peticions;

	public TipoPeticion() {
	}

	public long getTpId() {
		return this.tpId;
	}

	public void setTpId(long tpId) {
		this.tpId = tpId;
	}

	public String getTpDescripcion() {
		return this.tpDescripcion;
	}

	public void setTpDescripcion(String tpDescripcion) {
		this.tpDescripcion = tpDescripcion;
	}

	public List<Peticion> getPeticions() {
		return this.peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	public Peticion addPeticion(Peticion peticion) {
		getPeticions().add(peticion);
		peticion.setTipoPeticion(this);

		return peticion;
	}

	public Peticion removePeticion(Peticion peticion) {
		getPeticions().remove(peticion);
		peticion.setTipoPeticion(null);

		return peticion;
	}

}