package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the paso_faena database table.
 * 
 */
@Embeddable
public class PasoFaenaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_paso")
	private int idPaso;

	@Column(name="Usuario")
	private String usuario;

	@Column(name="Faena")
	private String faena;

	public PasoFaenaPK() {
	}
	public int getIdPaso() {
		return this.idPaso;
	}
	public void setIdPaso(int idPaso) {
		this.idPaso = idPaso;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFaena() {
		return this.faena;
	}
	public void setFaena(String faena) {
		this.faena = faena;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PasoFaenaPK)) {
			return false;
		}
		PasoFaenaPK castOther = (PasoFaenaPK)other;
		return 
			(this.idPaso == castOther.idPaso)
			&& this.usuario.equals(castOther.usuario)
			&& this.faena.equals(castOther.faena);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPaso;
		hash = hash * prime + this.usuario.hashCode();
		hash = hash * prime + this.faena.hashCode();
		
		return hash;
	}
}