package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the Instaladores_Device database table.
 * 
 */
@Entity
@NamedQuery(name="Instaladores_Device.findAll", query="SELECT i FROM Instaladores_Device i")
public class Instaladores_Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_instalacion")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idInstalacion;

	private Integer apn;

	private Integer bpanico;

	@Column(name="cod_anexo")
	private int codAnexo;

	@Column(name="cod_ficha")
	private int codFicha;

	private String comp;

	@Column(name="desc_falla")
	private String descFalla;

	private String empresa;

	private Timestamp fecha;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	@Column(name="fecha_libera")
	private Timestamp fechaLibera;

	@Column(name="fecha_libera_oper")
	private Timestamp fechaLiberaOper;

	@Column(name="id_gps")
	private String idGps;

	private String imei;

	private String instalador;

	private int liberado;

	@Column(name="liberado_x_oper")
	private int liberadoXOper;

	private String marca;

	@Column(name="mod_voz")
	private String modVoz;

	private String modelo;

	@Column(name="num_serie")
	private String numSerie;

	private String observacion;

	@Column(name="observacion_valida")
	private String observacionValida;

	@Column(name="OT")
	private String ot;

	@Column(name="otro_acc")
	private String otroAcc;

	private String patente;

	private int sw;

	@Column(name="tipo_falla")
	private String tipoFalla;

	@Column(name="tipo_instalacion")
	private String tipoInstalacion;

	private String ubicacion;

	@Column(name="usuario_libera")
	private int usuarioLibera;

	@Column(name="usuario_libera_x_oper")
	private int usuarioLiberaXOper;

	@Column(name="valida_sup")
	private BigDecimal validaSup;

	private String validador;

	private String vehiculo;

	@Column(name="VIN")
	private String vin;

	public Instaladores_Device() {
	}

	public long getIdInstalacion() {
		return idInstalacion;
	}

	public void setIdInstalacion(long idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public Integer getApn() {
		return apn;
	}

	public void setApn(Integer apn) {
		this.apn = apn;
	}

	public Integer getBpanico() {
		return bpanico;
	}

	public void setBpanico(Integer bpanico) {
		this.bpanico = bpanico;
	}

	public int getCodAnexo() {
		return codAnexo;
	}

	public void setCodAnexo(int codAnexo) {
		this.codAnexo = codAnexo;
	}

	public int getCodFicha() {
		return codFicha;
	}

	public void setCodFicha(int codFicha) {
		this.codFicha = codFicha;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getDescFalla() {
		return descFalla;
	}

	public void setDescFalla(String descFalla) {
		this.descFalla = descFalla;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaLibera() {
		return fechaLibera;
	}

	public void setFechaLibera(Timestamp fechaLibera) {
		this.fechaLibera = fechaLibera;
	}

	public Timestamp getFechaLiberaOper() {
		return fechaLiberaOper;
	}

	public void setFechaLiberaOper(Timestamp fechaLiberaOper) {
		this.fechaLiberaOper = fechaLiberaOper;
	}

	public String getIdGps() {
		return idGps;
	}

	public void setIdGps(String idGps) {
		this.idGps = idGps;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getInstalador() {
		return instalador;
	}

	public void setInstalador(String instalador) {
		this.instalador = instalador;
	}

	public int getLiberado() {
		return liberado;
	}

	public void setLiberado(int liberado) {
		this.liberado = liberado;
	}

	public int getLiberadoXOper() {
		return liberadoXOper;
	}

	public void setLiberadoXOper(int liberadoXOper) {
		this.liberadoXOper = liberadoXOper;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModVoz() {
		return modVoz;
	}

	public void setModVoz(String modVoz) {
		this.modVoz = modVoz;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacionValida() {
		return observacionValida;
	}

	public void setObservacionValida(String observacionValida) {
		this.observacionValida = observacionValida;
	}

	public String getOt() {
		return ot;
	}

	public void setOt(String ot) {
		this.ot = ot;
	}

	public String getOtroAcc() {
		return otroAcc;
	}

	public void setOtroAcc(String otroAcc) {
		this.otroAcc = otroAcc;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getSw() {
		return sw;
	}

	public void setSw(int sw) {
		this.sw = sw;
	}

	public String getTipoFalla() {
		return tipoFalla;
	}

	public void setTipoFalla(String tipoFalla) {
		this.tipoFalla = tipoFalla;
	}

	public String getTipoInstalacion() {
		return tipoInstalacion;
	}

	public void setTipoInstalacion(String tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getUsuarioLibera() {
		return usuarioLibera;
	}

	public void setUsuarioLibera(int usuarioLibera) {
		this.usuarioLibera = usuarioLibera;
	}

	public int getUsuarioLiberaXOper() {
		return usuarioLiberaXOper;
	}

	public void setUsuarioLiberaXOper(int usuarioLiberaXOper) {
		this.usuarioLiberaXOper = usuarioLiberaXOper;
	}

	public BigDecimal getValidaSup() {
		return validaSup;
	}

	public void setValidaSup(BigDecimal validaSup) {
		this.validaSup = validaSup;
	}

	public String getValidador() {
		return validador;
	}

	public void setValidador(String validador) {
		this.validador = validador;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	
}