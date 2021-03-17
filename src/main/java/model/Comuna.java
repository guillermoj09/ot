package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comuna database table.
 * 
 */
@Entity
@NamedQuery(name="Comuna.findAll", query="SELECT c FROM Comuna c")
public class Comuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="id_region")
	private Region region;

	public Comuna() {
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

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}