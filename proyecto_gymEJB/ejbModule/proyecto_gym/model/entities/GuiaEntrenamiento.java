package proyecto_gym.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guia_entrenamiento database table.
 * 
 */
@Entity
@Table(name="guia_entrenamiento")
@NamedQuery(name="GuiaEntrenamiento.findAll", query="SELECT g FROM GuiaEntrenamiento g")
public class GuiaEntrenamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GUIA_ENTRENAMIENTO_GEID_GENERATOR", sequenceName="SEQ_GUIA_ENTRENAMIENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GUIA_ENTRENAMIENTO_GEID_GENERATOR")
	@Column(name="ge_id")
	private long geId;

	@Column(name="ge_descripcion")
	private String geDescripcion;

	//bi-directional many-to-one association to Peticion
	@OneToMany(mappedBy="guiaEntrenamiento")
	private List<Peticion> peticions;

	public GuiaEntrenamiento() {
	}

	public long getGeId() {
		return this.geId;
	}

	public void setGeId(long geId) {
		this.geId = geId;
	}

	public String getGeDescripcion() {
		return this.geDescripcion;
	}

	public void setGeDescripcion(String geDescripcion) {
		this.geDescripcion = geDescripcion;
	}

	public List<Peticion> getPeticions() {
		return this.peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	public Peticion addPeticion(Peticion peticion) {
		getPeticions().add(peticion);
		peticion.setGuiaEntrenamiento(this);

		return peticion;
	}

	public Peticion removePeticion(Peticion peticion) {
		getPeticions().remove(peticion);
		peticion.setGuiaEntrenamiento(null);

		return peticion;
	}

}