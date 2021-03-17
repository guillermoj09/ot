package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agenda_usuario_apoya database table.
 * 
 */
@Entity
@Table(name="agenda_usuario_apoya")
@NamedQuery(name="AgendaUsuarioApoya.findAll", query="SELECT a FROM AgendaUsuarioApoya a")
public class AgendaUsuarioApoya implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="id_agenda")
	private int idAgenda;

	@Column(name="usuario_apoya")
	private String usuarioApoya;

	public AgendaUsuarioApoya() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getUsuarioApoya() {
		return this.usuarioApoya;
	}

	public void setUsuarioApoya(String usuarioApoya) {
		this.usuarioApoya = usuarioApoya;
	}

}