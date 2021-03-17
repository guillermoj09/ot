package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tblValidaciones database table.
 * 
 */
@Entity
@Table(name="tblValidaciones")
@NamedQuery(name="TblValidacione.findAll", query="SELECT t FROM TblValidacione t")
public class TblValidacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idValidacion;

	private String codigoValidacion;

	private int confirmada;

	@Column(name="confirmado_por")
	private String confirmadoPor;

	private int desdetrans;

	@Column(name="fecha_confirmacion")
	private Timestamp fechaConfirmacion;

	private Timestamp fechaBdd;

	private Timestamp fechaIngreso;

	@Column(name="id_asistencia")
	private int idAsistencia;

	private String id_Cdt;

	private String id_Gps;

	private String id_Instalador;

	private String observacion;

	private int ot;

	private int tipoValidacion;

	private boolean vigencia;

	public TblValidacione() {
	}

	public int getIdValidacion() {
		return this.idValidacion;
	}

	public void setIdValidacion(int idValidacion) {
		this.idValidacion = idValidacion;
	}

	public String getCodigoValidacion() {
		return this.codigoValidacion;
	}

	public void setCodigoValidacion(String codigoValidacion) {
		this.codigoValidacion = codigoValidacion;
	}

	public int getConfirmada() {
		return this.confirmada;
	}

	public void setConfirmada(int confirmada) {
		this.confirmada = confirmada;
	}

	public String getConfirmadoPor() {
		return this.confirmadoPor;
	}

	public void setConfirmadoPor(String confirmadoPor) {
		this.confirmadoPor = confirmadoPor;
	}

	public int getDesdetrans() {
		return this.desdetrans;
	}

	public void setDesdetrans(int desdetrans) {
		this.desdetrans = desdetrans;
	}

	public Timestamp getFechaConfirmacion() {
		return this.fechaConfirmacion;
	}

	public void setFechaConfirmacion(Timestamp fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	public Timestamp getFechaBdd() {
		return this.fechaBdd;
	}

	public void setFechaBdd(Timestamp fechaBdd) {
		this.fechaBdd = fechaBdd;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public String getId_Cdt() {
		return this.id_Cdt;
	}

	public void setId_Cdt(String id_Cdt) {
		this.id_Cdt = id_Cdt;
	}

	public String getId_Gps() {
		return this.id_Gps;
	}

	public void setId_Gps(String id_Gps) {
		this.id_Gps = id_Gps;
	}

	public String getId_Instalador() {
		return this.id_Instalador;
	}

	public void setId_Instalador(String id_Instalador) {
		this.id_Instalador = id_Instalador;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getOt() {
		return this.ot;
	}

	public void setOt(int ot) {
		this.ot = ot;
	}

	public int getTipoValidacion() {
		return this.tipoValidacion;
	}

	public void setTipoValidacion(int tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public boolean getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

}