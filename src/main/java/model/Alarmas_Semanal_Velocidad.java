package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Alarmas_Semanal_Velocidad database table.
 * 
 */
@Entity
@NamedQuery(name="Alarmas_Semanal_Velocidad.findAll", query="SELECT a FROM Alarmas_Semanal_Velocidad a")
public class Alarmas_Semanal_Velocidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long TMP_id;

	private String TMP_Chofer;

	private String TMP_cliente;

	private String TMP_descripcion;

	private Timestamp TMP_escritura;

	private String TMP_Faena;

	private Timestamp TMP_Fecha_Hora;

	private String TMP_Latitud;

	private String TMP_Longitud;

	private String TMP_Patente;

	private String TMP_tiempo;

	private String TMP_tipo;

	private int TMP_velocidad;

	public Alarmas_Semanal_Velocidad() {
	}

	public long getTMP_id() {
		return this.TMP_id;
	}

	public void setTMP_id(long TMP_id) {
		this.TMP_id = TMP_id;
	}

	public String getTMP_Chofer() {
		return this.TMP_Chofer;
	}

	public void setTMP_Chofer(String TMP_Chofer) {
		this.TMP_Chofer = TMP_Chofer;
	}

	public String getTMP_cliente() {
		return this.TMP_cliente;
	}

	public void setTMP_cliente(String TMP_cliente) {
		this.TMP_cliente = TMP_cliente;
	}

	public String getTMP_descripcion() {
		return this.TMP_descripcion;
	}

	public void setTMP_descripcion(String TMP_descripcion) {
		this.TMP_descripcion = TMP_descripcion;
	}

	public Timestamp getTMP_escritura() {
		return this.TMP_escritura;
	}

	public void setTMP_escritura(Timestamp TMP_escritura) {
		this.TMP_escritura = TMP_escritura;
	}

	public String getTMP_Faena() {
		return this.TMP_Faena;
	}

	public void setTMP_Faena(String TMP_Faena) {
		this.TMP_Faena = TMP_Faena;
	}

	public Timestamp getTMP_Fecha_Hora() {
		return this.TMP_Fecha_Hora;
	}

	public void setTMP_Fecha_Hora(Timestamp TMP_Fecha_Hora) {
		this.TMP_Fecha_Hora = TMP_Fecha_Hora;
	}

	public String getTMP_Latitud() {
		return this.TMP_Latitud;
	}

	public void setTMP_Latitud(String TMP_Latitud) {
		this.TMP_Latitud = TMP_Latitud;
	}

	public String getTMP_Longitud() {
		return this.TMP_Longitud;
	}

	public void setTMP_Longitud(String TMP_Longitud) {
		this.TMP_Longitud = TMP_Longitud;
	}

	public String getTMP_Patente() {
		return this.TMP_Patente;
	}

	public void setTMP_Patente(String TMP_Patente) {
		this.TMP_Patente = TMP_Patente;
	}

	public String getTMP_tiempo() {
		return this.TMP_tiempo;
	}

	public void setTMP_tiempo(String TMP_tiempo) {
		this.TMP_tiempo = TMP_tiempo;
	}

	public String getTMP_tipo() {
		return this.TMP_tipo;
	}

	public void setTMP_tipo(String TMP_tipo) {
		this.TMP_tipo = TMP_tipo;
	}

	public int getTMP_velocidad() {
		return this.TMP_velocidad;
	}

	public void setTMP_velocidad(int TMP_velocidad) {
		this.TMP_velocidad = TMP_velocidad;
	}

}