package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarios_trans database table.
 * 
 */
@Embeddable
public class UsuariosTranPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long codigo;

	private String usuario;

	public UsuariosTranPK() {
	}
	public long getCodigo() {
		return this.codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosTranPK)) {
			return false;
		}
		UsuariosTranPK castOther = (UsuariosTranPK)other;
		return 
			(this.codigo == castOther.codigo)
			&& this.usuario.equals(castOther.usuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codigo ^ (this.codigo >>> 32)));
		hash = hash * prime + this.usuario.hashCode();
		
		return hash;
	}
}