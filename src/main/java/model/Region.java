package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region database table.
 * 
 */
@Entity
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String abreviatura;

	private String descripcion;

	//bi-directional many-to-one association to Comuna
	@OneToMany(mappedBy="region")
	private List<Comuna> comunas;

	public Region() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Comuna> getComunas() {
		return this.comunas;
	}

	public void setComunas(List<Comuna> comunas) {
		this.comunas = comunas;
	}

	public Comuna addComuna(Comuna comuna) {
		getComunas().add(comuna);
		comuna.setRegion(this);

		return comuna;
	}

	public Comuna removeComuna(Comuna comuna) {
		getComunas().remove(comuna);
		comuna.setRegion(null);

		return comuna;
	}

}