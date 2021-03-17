package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="faenas")
@NamedQuery(name="Faenas.findAll", query="SELECT c FROM Faenas c")
public class Faenas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_faenas")
	private int idFaenas;
	
	private String faena;
	
	private String flat;
	
	private String flon;
	
	private String fzoom;

	public int getIdFaenas() {
		return idFaenas;
	}

	public void setIdFaenas(int idFaenas) {
		this.idFaenas = idFaenas;
	}

	public String getFaena() {
		return faena;
	}

	public void setFaena(String faena) {
		this.faena = faena;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getFlon() {
		return flon;
	}

	public void setFlon(String flon) {
		this.flon = flon;
	}

	public String getFzoom() {
		return fzoom;
	}

	public void setFzoom(String fzoom) {
		this.fzoom = fzoom;
	}
	
	


}
