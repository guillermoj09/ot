package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Device_Tipogps database table.
 * 
 */
@Entity
@Table(name="Device_Tipogps")
@NamedQuery(name="Device_Tipogp.findAll", query="SELECT d FROM Device_Tipogp d")
public class Device_Tipogp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_gps")
	private long idGps;

	private String alias;

	private String descripcion;

	@Column(name="Marca")
	private String marca;

	@Column(name="Modelo")
	private String modelo;

	@Column(name="tipo_gps")
	private String tipoGps;

	private int vigencia;

	public Device_Tipogp() {
	}

	public long getIdGps() {
		return this.idGps;
	}

	public void setIdGps(long idGps) {
		this.idGps = idGps;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoGps() {
		return this.tipoGps;
	}

	public void setTipoGps(String tipoGps) {
		this.tipoGps = tipoGps;
	}

	public int getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

}