package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sam_OT database table.
 * 
 */
@Entity
@Table(name="sam_OT")
@NamedQuery(name="Sam_OT.findAll", query="SELECT s FROM Sam_OT s")
public class Sam_OT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ott_id")
	private int ottId;

	@Column(name="ott_alimentacion")
	private int ottAlimentacion;

	@Column(name="ott_anexo")
	private int ottAnexo;

	@Column(name="ott_anio")
	private String ottAnio;

	private int ott_APN;

	@Column(name="ott_cod_usuario")
	private int ottCodUsuario;

	@Column(name="ott_color")
	private String ottColor;

	@Column(name="ott_com_central")
	private int ottComCentral;

	@Column(name="ott_comp")
	private String ottComp;

	@Column(name="ott_comuna")
	private String ottComuna;

	@Column(name="ott_contacto")
	private String ottContacto;

	@Column(name="ott_desc_trabajo")
	private String ottDescTrabajo;

	@Column(name="ott_detecta")
	private int ottDetecta;

	@Column(name="ott_estado")
	private int ottEstado;

	@Column(name="ott_fecha")
	private Timestamp ottFecha;

	@Column(name="ott_fecha_asistencia")
	private Timestamp ottFechaAsistencia;

	@Column(name="ott_fecha_cierra")
	private Timestamp ottFechaCierra;

	@Column(name="ott_fecha_ult_cert")
	private Timestamp ottFechaUltCert;

	@Column(name="ott_folio")
	private int ottFolio;

	@Column(name="ott_hfin")
	private String ottHfin;

	@Column(name="ott_hini")
	private String ottHini;


	@Column(name="ott_id_inst")
	private int ottIdInst;

	@Column(name="ott_idgps")
	private String ottIdgps;

	@Column(name="ott_imei")
	private String ottImei;

	@Column(name="ott_km")
	private double ottKm;

	@Column(name="ott_marca_gps")
	private String ottMarcaGps;

	@Column(name="ott_marca_modelo")
	private String ottMarcaModelo;

	@Column(name="ott_nombre")
	private String ottNombre;

	@Column(name="ott_num")
	private int ottNum;

	@Column(name="ott_num_fisica")
	private String ottNumFisica;

	@Column(name="ott_num_mvoz")
	private String ottNumMvoz;

	@Column(name="ott_num_serie")
	private String ottNumSerie;

	@Column(name="ott_num_tel")
	private String ottNumTel;

	@Column(name="ott_obs")
	private String ottObs;

	@Column(name="ott_patente")
	private String ottPatente;

	@Column(name="ott_pba_eve_espec")
	private int ottPbaEveEspec;

	@Column(name="ott_recepcion_gps")
	private int ottRecepcionGps;

	@Column(name="ott_tecnico_id")
	private int ottTecnicoId;

	@Column(name="ott_telefono")
	private String ottTelefono;

	@Column(name="ott_tipo_asistencia")
	private int ottTipoAsistencia;

	private int ott_tipVehi;

	@Column(name="ott_ubicacion")
	private String ottUbicacion;

	@Column(name="ott_val_limpiaparab")
	private int ottValLimpiaparab;

	@Column(name="ott_val_luz_atras")
	private int ottValLuzAtras;

	@Column(name="ott_val_luz_ppal")
	private int ottValLuzPpal;

	@Column(name="ott_val_radio")
	private int ottValRadio;

	@Column(name="ott_val_senalizadores")
	private int ottValSenalizadores;

	@Column(name="ott_val_testigo")
	private int ottValTestigo;

	@Column(name="ott_ver_limpiaparab")
	private int ottVerLimpiaparab;

	@Column(name="ott_ver_luz_atras")
	private int ottVerLuzAtras;

	@Column(name="ott_ver_luz_ppla")
	private int ottVerLuzPpla;

	@Column(name="ott_ver_radio")
	private int ottVerRadio;

	@Column(name="ott_ver_senalizadores")
	private int ottVerSenalizadores;

	@Column(name="ott_ver_testigo")
	private int ottVerTestigo;

	private String ott_VIN;

	@Column(name="ott_voltaje")
	private String ottVoltaje;

	public Sam_OT() {
	}

	public int getOttAlimentacion() {
		return this.ottAlimentacion;
	}

	public void setOttAlimentacion(int ottAlimentacion) {
		this.ottAlimentacion = ottAlimentacion;
	}

	public int getOttAnexo() {
		return this.ottAnexo;
	}

	public void setOttAnexo(int ottAnexo) {
		this.ottAnexo = ottAnexo;
	}

	public String getOttAnio() {
		return this.ottAnio;
	}

	public void setOttAnio(String ottAnio) {
		this.ottAnio = ottAnio;
	}

	public int getOtt_APN() {
		return this.ott_APN;
	}

	public void setOtt_APN(int ott_APN) {
		this.ott_APN = ott_APN;
	}

	public int getOttCodUsuario() {
		return this.ottCodUsuario;
	}

	public void setOttCodUsuario(int ottCodUsuario) {
		this.ottCodUsuario = ottCodUsuario;
	}

	public String getOttColor() {
		return this.ottColor;
	}

	public void setOttColor(String ottColor) {
		this.ottColor = ottColor;
	}

	public int getOttComCentral() {
		return this.ottComCentral;
	}

	public void setOttComCentral(int ottComCentral) {
		this.ottComCentral = ottComCentral;
	}

	public String getOttComp() {
		return this.ottComp;
	}

	public void setOttComp(String ottComp) {
		this.ottComp = ottComp;
	}

	public String getOttComuna() {
		return this.ottComuna;
	}

	public void setOttComuna(String ottComuna) {
		this.ottComuna = ottComuna;
	}

	public String getOttContacto() {
		return this.ottContacto;
	}

	public void setOttContacto(String ottContacto) {
		this.ottContacto = ottContacto;
	}

	public String getOttDescTrabajo() {
		return this.ottDescTrabajo;
	}

	public void setOttDescTrabajo(String ottDescTrabajo) {
		this.ottDescTrabajo = ottDescTrabajo;
	}

	public int getOttDetecta() {
		return this.ottDetecta;
	}

	public void setOttDetecta(int ottDetecta) {
		this.ottDetecta = ottDetecta;
	}

	public int getOttEstado() {
		return this.ottEstado;
	}

	public void setOttEstado(int ottEstado) {
		this.ottEstado = ottEstado;
	}

	public Timestamp getOttFecha() {
		return this.ottFecha;
	}

	public void setOttFecha(Timestamp ottFecha) {
		this.ottFecha = ottFecha;
	}

	public Timestamp getOttFechaAsistencia() {
		return this.ottFechaAsistencia;
	}

	public void setOttFechaAsistencia(Timestamp ottFechaAsistencia) {
		this.ottFechaAsistencia = ottFechaAsistencia;
	}

	public Timestamp getOttFechaCierra() {
		return this.ottFechaCierra;
	}

	public void setOttFechaCierra(Timestamp ottFechaCierra) {
		this.ottFechaCierra = ottFechaCierra;
	}

	public Timestamp getOttFechaUltCert() {
		return this.ottFechaUltCert;
	}

	public void setOttFechaUltCert(Timestamp ottFechaUltCert) {
		this.ottFechaUltCert = ottFechaUltCert;
	}

	public int getOttFolio() {
		return this.ottFolio;
	}

	public void setOttFolio(int ottFolio) {
		this.ottFolio = ottFolio;
	}

	public String getOttHfin() {
		return this.ottHfin;
	}

	public void setOttHfin(String ottHfin) {
		this.ottHfin = ottHfin;
	}

	public String getOttHini() {
		return this.ottHini;
	}

	public void setOttHini(String ottHini) {
		this.ottHini = ottHini;
	}

	public int getOttId() {
		return this.ottId;
	}

	public void setOttId(int ottId) {
		this.ottId = ottId;
	}

	public int getOttIdInst() {
		return this.ottIdInst;
	}

	public void setOttIdInst(int ottIdInst) {
		this.ottIdInst = ottIdInst;
	}

	public String getOttIdgps() {
		return this.ottIdgps;
	}

	public void setOttIdgps(String ottIdgps) {
		this.ottIdgps = ottIdgps;
	}

	public String getOttImei() {
		return this.ottImei;
	}

	public void setOttImei(String ottImei) {
		this.ottImei = ottImei;
	}

	public double getOttKm() {
		return this.ottKm;
	}

	public void setOttKm(double ottKm) {
		this.ottKm = ottKm;
	}

	public String getOttMarcaGps() {
		return this.ottMarcaGps;
	}

	public void setOttMarcaGps(String ottMarcaGps) {
		this.ottMarcaGps = ottMarcaGps;
	}

	public String getOttMarcaModelo() {
		return this.ottMarcaModelo;
	}

	public void setOttMarcaModelo(String ottMarcaModelo) {
		this.ottMarcaModelo = ottMarcaModelo;
	}

	public String getOttNombre() {
		return this.ottNombre;
	}

	public void setOttNombre(String ottNombre) {
		this.ottNombre = ottNombre;
	}

	public int getOttNum() {
		return this.ottNum;
	}

	public void setOttNum(int ottNum) {
		this.ottNum = ottNum;
	}

	public String getOttNumFisica() {
		return this.ottNumFisica;
	}

	public void setOttNumFisica(String ottNumFisica) {
		this.ottNumFisica = ottNumFisica;
	}

	public String getOttNumMvoz() {
		return this.ottNumMvoz;
	}

	public void setOttNumMvoz(String ottNumMvoz) {
		this.ottNumMvoz = ottNumMvoz;
	}

	public String getOttNumSerie() {
		return this.ottNumSerie;
	}

	public void setOttNumSerie(String ottNumSerie) {
		this.ottNumSerie = ottNumSerie;
	}

	public String getOttNumTel() {
		return this.ottNumTel;
	}

	public void setOttNumTel(String ottNumTel) {
		this.ottNumTel = ottNumTel;
	}

	public String getOttObs() {
		return this.ottObs;
	}

	public void setOttObs(String ottObs) {
		this.ottObs = ottObs;
	}

	public String getOttPatente() {
		return this.ottPatente;
	}

	public void setOttPatente(String ottPatente) {
		this.ottPatente = ottPatente;
	}

	public int getOttPbaEveEspec() {
		return this.ottPbaEveEspec;
	}

	public void setOttPbaEveEspec(int ottPbaEveEspec) {
		this.ottPbaEveEspec = ottPbaEveEspec;
	}

	public int getOttRecepcionGps() {
		return this.ottRecepcionGps;
	}

	public void setOttRecepcionGps(int ottRecepcionGps) {
		this.ottRecepcionGps = ottRecepcionGps;
	}

	public int getOttTecnicoId() {
		return this.ottTecnicoId;
	}

	public void setOttTecnicoId(int ottTecnicoId) {
		this.ottTecnicoId = ottTecnicoId;
	}

	public String getOttTelefono() {
		return this.ottTelefono;
	}

	public void setOttTelefono(String ottTelefono) {
		this.ottTelefono = ottTelefono;
	}

	public int getOttTipoAsistencia() {
		return this.ottTipoAsistencia;
	}

	public void setOttTipoAsistencia(int ottTipoAsistencia) {
		this.ottTipoAsistencia = ottTipoAsistencia;
	}

	public int getOtt_tipVehi() {
		return this.ott_tipVehi;
	}

	public void setOtt_tipVehi(int ott_tipVehi) {
		this.ott_tipVehi = ott_tipVehi;
	}

	public String getOttUbicacion() {
		return this.ottUbicacion;
	}

	public void setOttUbicacion(String ottUbicacion) {
		this.ottUbicacion = ottUbicacion;
	}

	public int getOttValLimpiaparab() {
		return this.ottValLimpiaparab;
	}

	public void setOttValLimpiaparab(int ottValLimpiaparab) {
		this.ottValLimpiaparab = ottValLimpiaparab;
	}

	public int getOttValLuzAtras() {
		return this.ottValLuzAtras;
	}

	public void setOttValLuzAtras(int ottValLuzAtras) {
		this.ottValLuzAtras = ottValLuzAtras;
	}

	public int getOttValLuzPpal() {
		return this.ottValLuzPpal;
	}

	public void setOttValLuzPpal(int ottValLuzPpal) {
		this.ottValLuzPpal = ottValLuzPpal;
	}

	public int getOttValRadio() {
		return this.ottValRadio;
	}

	public void setOttValRadio(int ottValRadio) {
		this.ottValRadio = ottValRadio;
	}

	public int getOttValSenalizadores() {
		return this.ottValSenalizadores;
	}

	public void setOttValSenalizadores(int ottValSenalizadores) {
		this.ottValSenalizadores = ottValSenalizadores;
	}

	public int getOttValTestigo() {
		return this.ottValTestigo;
	}

	public void setOttValTestigo(int ottValTestigo) {
		this.ottValTestigo = ottValTestigo;
	}

	public int getOttVerLimpiaparab() {
		return this.ottVerLimpiaparab;
	}

	public void setOttVerLimpiaparab(int ottVerLimpiaparab) {
		this.ottVerLimpiaparab = ottVerLimpiaparab;
	}

	public int getOttVerLuzAtras() {
		return this.ottVerLuzAtras;
	}

	public void setOttVerLuzAtras(int ottVerLuzAtras) {
		this.ottVerLuzAtras = ottVerLuzAtras;
	}

	public int getOttVerLuzPpla() {
		return this.ottVerLuzPpla;
	}

	public void setOttVerLuzPpla(int ottVerLuzPpla) {
		this.ottVerLuzPpla = ottVerLuzPpla;
	}

	public int getOttVerRadio() {
		return this.ottVerRadio;
	}

	public void setOttVerRadio(int ottVerRadio) {
		this.ottVerRadio = ottVerRadio;
	}

	public int getOttVerSenalizadores() {
		return this.ottVerSenalizadores;
	}

	public void setOttVerSenalizadores(int ottVerSenalizadores) {
		this.ottVerSenalizadores = ottVerSenalizadores;
	}

	public int getOttVerTestigo() {
		return this.ottVerTestigo;
	}

	public void setOttVerTestigo(int ottVerTestigo) {
		this.ottVerTestigo = ottVerTestigo;
	}

	public String getOtt_VIN() {
		return this.ott_VIN;
	}

	public void setOtt_VIN(String ott_VIN) {
		this.ott_VIN = ott_VIN;
	}

	public String getOttVoltaje() {
		return this.ottVoltaje;
	}

	public void setOttVoltaje(String ottVoltaje) {
		this.ottVoltaje = ottVoltaje;
	}

}