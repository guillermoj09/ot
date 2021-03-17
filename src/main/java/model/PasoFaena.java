package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paso_faena database table.
 * 
 */
@Entity
@Table(name="paso_faena")
@NamedQuery(name="PasoFaena.findAll", query="SELECT p FROM PasoFaena p")
public class PasoFaena implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PasoFaenaPK id;

	private String alias;

	private String flat;

	private String flon;

	private String fzoom;

	@Column(name="id_area")
	private int idArea;

	@Column(name="pas_codigo")
	private int pasCodigo;

	private int tipo;

	public PasoFaena() {
	}

	public PasoFaenaPK getId() {
		return this.id;
	}

	public void setId(PasoFaenaPK id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFlat() {
		return this.flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getFlon() {
		return this.flon;
	}

	public void setFlon(String flon) {
		this.flon = flon;
	}

	public String getFzoom() {
		return this.fzoom;
	}

	public void setFzoom(String fzoom) {
		this.fzoom = fzoom;
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getPasCodigo() {
		return this.pasCodigo;
	}

	public void setPasCodigo(int pasCodigo) {
		this.pasCodigo = pasCodigo;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}