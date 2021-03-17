package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the validacion database table.
 * 
 */
@Entity
@NamedQuery(name="Validacion.findAll", query="SELECT v FROM Validacion v")
public class Validacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String estado;

	@Column(name="fecha_hora")
	private Timestamp fechaHora;

	@Column(name="id_gps")
	private String idGps;

	@Column(name="linea_log",columnDefinition="text")
	private String lineaLog;

	private Long ot;


	//bi-directional many-to-one association to TipoValidacion
	

	public Validacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Timestamp getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getIdGps() {
		return this.idGps;
	}

	public void setIdGps(String idGps) {
		this.idGps = idGps;
	}

	public String getLineaLog() {
		return this.lineaLog;
	}

	public void setLineaLog(String lineaLog) {
		this.lineaLog = lineaLog;
	}

	public Long getOt() {
		return this.ot;
	}

	public void setOt(Long ot) {
		this.ot = ot;
	}

	
}