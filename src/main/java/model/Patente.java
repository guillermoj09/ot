package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patente database table.
 * 
 */
@Entity
@NamedQuery(name="Patente.findAll", query="SELECT p FROM Patente p")
public class Patente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String idgps;

	private String patente;

	//bi-directional many-to-one association to Ot
	@ManyToOne
	@JoinColumn(name="id_ot")
	private Ot ot;

	public Patente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdgps() {
		return this.idgps;
	}

	public void setIdgps(String idgps) {
		this.idgps = idgps;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Ot getOt() {
		return this.ot;
	}

	public void setOt(Ot ot) {
		this.ot = ot;
	}

}