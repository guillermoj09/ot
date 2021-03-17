package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_validacion database table.
 * 
 */
@Entity
@Table(name="tipo_validacion")
@NamedQuery(name="TipoValidacion.findAll", query="SELECT t FROM TipoValidacion t")
public class TipoValidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String bloqueante;

	private String descripcion;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="tipoValidacion")
	private List<Log> logs;

	//bi-directional many-to-one association to Validacion
	
	public TipoValidacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBloqueante() {
		return this.bloqueante;
	}

	public void setBloqueante(String bloqueante) {
		this.bloqueante = bloqueante;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setTipoValidacion(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setTipoValidacion(null);

		return log;
	}


}