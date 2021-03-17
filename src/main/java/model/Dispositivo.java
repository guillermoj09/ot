package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dispositivo database table.
 * 
 */
@Entity
@NamedQuery(name="Dispositivo.findAll", query="SELECT d FROM Dispositivo d")
public class Dispositivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	private String serie;

	//bi-directional many-to-one association to Patente
	@ManyToOne
	@JoinColumn(name="id_patente")
	private Patente patente;

	public Dispositivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Patente getPatente() {
		return this.patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

}