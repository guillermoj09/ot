package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the agenda_mail database table.
 * 
 */
@Entity
@Table(name="agenda_mail")
@NamedQuery(name="AgendaMail.findAll", query="SELECT a FROM AgendaMail a")
public class AgendaMail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String area;

	private String copia;

	private int estado;

	private int excluyente;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String observaciones;

	private String para;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	public AgendaMail() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCopia() {
		return this.copia;
	}

	public void setCopia(String copia) {
		this.copia = copia;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getExcluyente() {
		return this.excluyente;
	}

	public void setExcluyente(int excluyente) {
		this.excluyente = excluyente;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPara() {
		return this.para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

}