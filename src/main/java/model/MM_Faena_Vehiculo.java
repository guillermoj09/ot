package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the MM_Faena_Vehiculos database table.
 * 
 */
@Entity
@Table(name="MM_Faena_Vehiculos")
@NamedQuery(name="MM_Faena_Vehiculo.findAll", query="SELECT m FROM MM_Faena_Vehiculo m")
public class MM_Faena_Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long FV_cod;

	private int FV_cliente_propietario;

	private int FV_faena;

	private Timestamp FV_fecha_asigna;

	private String FV_usuario_asigna;

	private String FV_vehiculo;

	public MM_Faena_Vehiculo() {
	}

	public long getFV_cod() {
		return this.FV_cod;
	}

	public void setFV_cod(long FV_cod) {
		this.FV_cod = FV_cod;
	}

	public int getFV_cliente_propietario() {
		return this.FV_cliente_propietario;
	}

	public void setFV_cliente_propietario(int FV_cliente_propietario) {
		this.FV_cliente_propietario = FV_cliente_propietario;
	}

	public int getFV_faena() {
		return this.FV_faena;
	}

	public void setFV_faena(int FV_faena) {
		this.FV_faena = FV_faena;
	}

	public Timestamp getFV_fecha_asigna() {
		return this.FV_fecha_asigna;
	}

	public void setFV_fecha_asigna(Timestamp FV_fecha_asigna) {
		this.FV_fecha_asigna = FV_fecha_asigna;
	}

	public String getFV_usuario_asigna() {
		return this.FV_usuario_asigna;
	}

	public void setFV_usuario_asigna(String FV_usuario_asigna) {
		this.FV_usuario_asigna = FV_usuario_asigna;
	}

	public String getFV_vehiculo() {
		return this.FV_vehiculo;
	}

	public void setFV_vehiculo(String FV_vehiculo) {
		this.FV_vehiculo = FV_vehiculo;
	}

}