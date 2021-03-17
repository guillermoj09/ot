package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the agenda_refresh database table.
 * 
 */
@Entity
@Table(name="agenda_refresh")
@NamedQuery(name="AgendaRefresh.findAll", query="SELECT a FROM AgendaRefresh a")
public class AgendaRefresh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agenda_refresh")
	private long idAgendaRefresh;

	private int estado;

	private Timestamp fecha;

	@Column(name="id_agenda")
	private long idAgenda;

	private String ip;

	private String usuario;

	public AgendaRefresh() {
	}

	public long getIdAgendaRefresh() {
		return this.idAgendaRefresh;
	}

	public void setIdAgendaRefresh(long idAgendaRefresh) {
		this.idAgendaRefresh = idAgendaRefresh;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public long getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}