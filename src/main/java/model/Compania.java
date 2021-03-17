package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compania database table.
 * 
 */
@Entity
@NamedQuery(name="Compania.findAll", query="SELECT c FROM Compania c")
public class Compania implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String codigo;

	private String descripcion;

	public Compania() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}