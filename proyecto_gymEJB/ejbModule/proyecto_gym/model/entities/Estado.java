package proyecto_gym.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADOS_ESTID_GENERATOR", sequenceName="SEQ_ESTADOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOS_ESTID_GENERATOR")
	@Column(name="est_id")
	private long estId;

	@Column(name="est_descripcion")
	private String estDescripcion;

	//bi-directional many-to-one association to Peticion
	@OneToMany(mappedBy="estado")
	private List<Peticion> peticions;

	public Estado() {
	}

	public long getEstId() {
		return this.estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public String getEstDescripcion() {
		return this.estDescripcion;
	}

	public void setEstDescripcion(String estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public List<Peticion> getPeticions() {
		return this.peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	public Peticion addPeticion(Peticion peticion) {
		getPeticions().add(peticion);
		peticion.setEstado(this);

		return peticion;
	}

	public Peticion removePeticion(Peticion peticion) {
		getPeticions().remove(peticion);
		peticion.setEstado(null);

		return peticion;
	}

}