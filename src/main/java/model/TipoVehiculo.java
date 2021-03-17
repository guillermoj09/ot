package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tipo_vehiculo database table.
 * 
 */
@Entity
@Table(name="tipo_vehiculo")
@NamedQuery(name="TipoVehiculo.findAll", query="SELECT t FROM TipoVehiculo t")
public class TipoVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int camion;

	private String descripcion;

	private int estado;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="id_sgomt")
	private int idSgomt;

	private int maquina;

	public TipoVehiculo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCamion() {
		return this.camion;
	}

	public void setCamion(int camion) {
		this.camion = camion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdSgomt() {
		return this.idSgomt;
	}

	public void setIdSgomt(int idSgomt) {
		this.idSgomt = idSgomt;
	}

	public int getMaquina() {
		return this.maquina;
	}

	public void setMaquina(int maquina) {
		this.maquina = maquina;
	}

}