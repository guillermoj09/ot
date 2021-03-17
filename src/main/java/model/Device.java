package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the device database table.
 * 
 */
@Entity
@Table(name="device")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEVICE")
	private String idDevice;

	private String AI_0_Desc;

	private String AI_1_Desc;

	private String AI_2_Desc;
	
	private int mvoz;

	@Column(name="Anio_vehiculo")
	private int anio_vehiculo;

	private int anx;

	private String borra;

	private String bpanico;
	
	@Column(name="id_CDS")
	private String IdCds;

	@Column(name="Brand")
	private String brand;

	@Column(name="Brand2")
	private String brand2;

	private String buzzer;

	private String camara;

	@Column(name="CAN")
	private String can;

	@Column(name="candado_elect")
	private int candadoElect;

	@Column(name="cap_balde")
	private double capBalde;

	@Column(name="cap_carga")
	private double capCarga;

	@Column(name="centro_costo")
	private String centroCosto;

	@Column(name="Chofer")
	private String chofer;

	private String cinturon;

	private String cjornada;

	private String color;

	private int combustible;

	@Column(name="Con_VPN")
	private String con_VPN;

	@Column(name="consumo_medio")
	private double consumoMedio;

	private String controlador;

	private BigDecimal correlativo;

	private BigDecimal corrimientoODO;

	@Column(name="corte_comb")
	private String corteComb;

	private String descripcion;

	private String DI_1_Desc;

	private String DI_2_Desc;

	private String DI_3_Desc;

	private String DI_4_Desc;

	private String DI_5_Desc;

	private String DI_6_Desc;

	private String DI_7_Desc;

	private String DO_0_Desc;

	private String DO_1_Desc;

	private String DO_2_Desc;

	private String DO_3_Desc;

	private String dualsim;

	private String easycan;

	@Column(name="envio_ws")
	private int envioWs;

	@Column(name="es_portatil")
	private boolean esPortatil;

	private int es_TCP;
	
	
	public int getMvoz() {
		return mvoz;
	}

	public void setMvoz(int mvoz) {
		this.mvoz = mvoz;
	}

	@Column(name="Escond_Area")
	private String escond_Area;

	@Column(name="Escond_GM")
	private String escond_GM;

	@Column(name="Escond_HO")
	private String escond_HO;

	private String estado;

	private int estado_AR;

	private int estanque;

	private String faena;

	@Column(name="fecha_asigna")
	private Timestamp fechaAsigna;

	@Column(name="fecha_inst")
	private Timestamp fechaInst;

	@Column(name="Fwcan")
	private String fwcan;

	private String garmin;

	private String horometro;

	private String ibutto;

	private String icono;

	@Column(name="id_chofer")
	private BigDecimal idChofer;

	@Column(name="id_detalle")
	private int idDetalle;

	@Column(name="id_ibutto")
	private String idIbutto;

	@Column(name="id_lbarra")
	private String idLbarra;

	@Column(name="id_tipo_estado_vehiculo")
	private int idTipoEstadoVehiculo;

	@Column(name="id_tipo_vehiculo")
	private int idTipoVehiculo;

	private String ID_Vehicle;

	@Column(name="id_vehiculo")
	private int idVehiculo;

	private String imagen;

	private String imei;

	@Column(name="Imei_GPS")
	private String imei_GPS;

	private String imei2;

	private String instalador;

	@Column(name="IP")
	private String ip;

	@Column(name="Kilometraje")
	private double kilometraje;

	private String kopilot;

	private String lbarra;

	@Column(name="marca_camion")
	private String marcaCamion;

	private int microsd;

	private String mobileye;

	@Column(name="Modelo")
	private String modelo;

	@Column(name="modif_accion")
	private String modifAccion;

	@Column(name="modif_fecha")
	private Timestamp modifFecha;

	@Column(name="modif_usu")
	private String modifUsu;

	@Column(name="Modulo")
	private String modulo;

	@Column(name="NombreTercero")
	private String nombreTercero;

	@Column(name="Num_contacto")
	private String num_contacto;

	@Column(name="Num_interno")
	private String num_interno;

	@Column(name="num_serie")
	private String numSerie;

	private String observaciones;

	private String pagador;

	private int pasajero;

	private String patente;

	@Column(name="peso_bruto")
	private double pesoBruto;

	@Column(name="peso_operac")
	private double pesoOperac;

	private int pesometro;

	@Column(name="Phone")
	private String phone;

	@Column(name="Phone2")
	private String phone2;

	private String psolar;

	private String puertas;

	@Lob
	@Column(name="Registro")
	private String registro;

	private String roaming;

	@Column(name="RX_DATE")
	private Timestamp rxDate;

	private String RX_NoM;

	private String satelital;

	@Column(name="SN")
	private String sn;

	@Column(name="STEMP")
	private String stemp;

	private String stolva;

	@Column(name="Tercero_Sigla")
	private String tercero_Sigla;

	@Column(name="tipo_gps")
	private String tipoGps;

	@Column(name="tipo_motor")
	private String tipoMotor;

	@Column(name="tipo_sello")
	private int tipoSello;

	@Column(name="Tipocan")
	private String tipocan;

	@Column(name="Tx_NoM")
	private String tx_NoM;

	@Column(name="UDP")
	private String udp;

	@Column(name="usuario_asigna")
	private String usuarioAsigna;

	@Column(name="usuario_camion")
	private String usuarioCamion;

	@Column(name="VIN")
	private String vin;

	@Column(name="vol_tolva")
	private double volTolva;

	private String volumetrico;

	private String wifi;

	@Column(name="Wpsolar")
	private int wpsolar;

	public Device() {
	}

	public String getIdDevice() {
		return this.idDevice;
	}

	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}
	
	public String getIdCds() {
		return IdCds;
	}

	public void setIdCds(String idCds) {
		IdCds = idCds;
	}

	public String getAI_0_Desc() {
		return this.AI_0_Desc;
	}

	public void setAI_0_Desc(String AI_0_Desc) {
		this.AI_0_Desc = AI_0_Desc;
	}

	public String getAI_1_Desc() {
		return this.AI_1_Desc;
	}

	public void setAI_1_Desc(String AI_1_Desc) {
		this.AI_1_Desc = AI_1_Desc;
	}

	public String getAI_2_Desc() {
		return this.AI_2_Desc;
	}

	public void setAI_2_Desc(String AI_2_Desc) {
		this.AI_2_Desc = AI_2_Desc;
	}

	public int getAnio_vehiculo() {
		return this.anio_vehiculo;
	}

	public void setAnio_vehiculo(int anio_vehiculo) {
		this.anio_vehiculo = anio_vehiculo;
	}

	public int getAnx() {
		return this.anx;
	}

	public void setAnx(int anx) {
		this.anx = anx;
	}

	public String getBorra() {
		return this.borra;
	}

	public void setBorra(String borra) {
		this.borra = borra;
	}

	public String getBpanico() {
		return this.bpanico;
	}

	public void setBpanico(String bpanico) {
		this.bpanico = bpanico;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand2() {
		return this.brand2;
	}

	public void setBrand2(String brand2) {
		this.brand2 = brand2;
	}

	public String getBuzzer() {
		return this.buzzer;
	}

	public void setBuzzer(String buzzer) {
		this.buzzer = buzzer;
	}

	public String getCamara() {
		return this.camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}

	public String getCan() {
		return this.can;
	}

	public void setCan(String can) {
		this.can = can;
	}

	public int getCandadoElect() {
		return this.candadoElect;
	}

	public void setCandadoElect(int candadoElect) {
		this.candadoElect = candadoElect;
	}

	public double getCapBalde() {
		return this.capBalde;
	}

	public void setCapBalde(double capBalde) {
		this.capBalde = capBalde;
	}

	public double getCapCarga() {
		return this.capCarga;
	}

	public void setCapCarga(double capCarga) {
		this.capCarga = capCarga;
	}

	public String getCentroCosto() {
		return this.centroCosto;
	}

	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}

	public String getChofer() {
		return this.chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public String getCinturon() {
		return this.cinturon;
	}

	public void setCinturon(String cinturon) {
		this.cinturon = cinturon;
	}

	public String getCjornada() {
		return this.cjornada;
	}

	public void setCjornada(String cjornada) {
		this.cjornada = cjornada;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCombustible() {
		return this.combustible;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public String getCon_VPN() {
		return this.con_VPN;
	}

	public void setCon_VPN(String con_VPN) {
		this.con_VPN = con_VPN;
	}

	public double getConsumoMedio() {
		return this.consumoMedio;
	}

	public void setConsumoMedio(double consumoMedio) {
		this.consumoMedio = consumoMedio;
	}

	public String getControlador() {
		return this.controlador;
	}

	public void setControlador(String controlador) {
		this.controlador = controlador;
	}

	public BigDecimal getCorrelativo() {
		return this.correlativo;
	}

	public void setCorrelativo(BigDecimal correlativo) {
		this.correlativo = correlativo;
	}

	public BigDecimal getCorrimientoODO() {
		return this.corrimientoODO;
	}

	public void setCorrimientoODO(BigDecimal corrimientoODO) {
		this.corrimientoODO = corrimientoODO;
	}

	public String getCorteComb() {
		return this.corteComb;
	}

	public void setCorteComb(String corteComb) {
		this.corteComb = corteComb;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDI_1_Desc() {
		return this.DI_1_Desc;
	}

	public void setDI_1_Desc(String DI_1_Desc) {
		this.DI_1_Desc = DI_1_Desc;
	}

	public String getDI_2_Desc() {
		return this.DI_2_Desc;
	}

	public void setDI_2_Desc(String DI_2_Desc) {
		this.DI_2_Desc = DI_2_Desc;
	}

	public String getDI_3_Desc() {
		return this.DI_3_Desc;
	}

	public void setDI_3_Desc(String DI_3_Desc) {
		this.DI_3_Desc = DI_3_Desc;
	}

	public String getDI_4_Desc() {
		return this.DI_4_Desc;
	}

	public void setDI_4_Desc(String DI_4_Desc) {
		this.DI_4_Desc = DI_4_Desc;
	}

	public String getDI_5_Desc() {
		return this.DI_5_Desc;
	}

	public void setDI_5_Desc(String DI_5_Desc) {
		this.DI_5_Desc = DI_5_Desc;
	}

	public String getDI_6_Desc() {
		return this.DI_6_Desc;
	}

	public void setDI_6_Desc(String DI_6_Desc) {
		this.DI_6_Desc = DI_6_Desc;
	}

	public String getDI_7_Desc() {
		return this.DI_7_Desc;
	}

	public void setDI_7_Desc(String DI_7_Desc) {
		this.DI_7_Desc = DI_7_Desc;
	}

	public String getDO_0_Desc() {
		return this.DO_0_Desc;
	}

	public void setDO_0_Desc(String DO_0_Desc) {
		this.DO_0_Desc = DO_0_Desc;
	}

	public String getDO_1_Desc() {
		return this.DO_1_Desc;
	}

	public void setDO_1_Desc(String DO_1_Desc) {
		this.DO_1_Desc = DO_1_Desc;
	}

	public String getDO_2_Desc() {
		return this.DO_2_Desc;
	}

	public void setDO_2_Desc(String DO_2_Desc) {
		this.DO_2_Desc = DO_2_Desc;
	}

	public String getDO_3_Desc() {
		return this.DO_3_Desc;
	}

	public void setDO_3_Desc(String DO_3_Desc) {
		this.DO_3_Desc = DO_3_Desc;
	}

	public String getDualsim() {
		return this.dualsim;
	}

	public void setDualsim(String dualsim) {
		this.dualsim = dualsim;
	}

	public String getEasycan() {
		return this.easycan;
	}

	public void setEasycan(String easycan) {
		this.easycan = easycan;
	}

	public int getEnvioWs() {
		return this.envioWs;
	}

	public void setEnvioWs(int envioWs) {
		this.envioWs = envioWs;
	}

	public boolean getEsPortatil() {
		return this.esPortatil;
	}

	public void setEsPortatil(boolean esPortatil) {
		this.esPortatil = esPortatil;
	}

	public int getEs_TCP() {
		return this.es_TCP;
	}

	public void setEs_TCP(int es_TCP) {
		this.es_TCP = es_TCP;
	}

	public String getEscond_Area() {
		return this.escond_Area;
	}

	public void setEscond_Area(String escond_Area) {
		this.escond_Area = escond_Area;
	}

	public String getEscond_GM() {
		return this.escond_GM;
	}

	public void setEscond_GM(String escond_GM) {
		this.escond_GM = escond_GM;
	}

	public String getEscond_HO() {
		return this.escond_HO;
	}

	public void setEscond_HO(String escond_HO) {
		this.escond_HO = escond_HO;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getEstado_AR() {
		return this.estado_AR;
	}

	public void setEstado_AR(int estado_AR) {
		this.estado_AR = estado_AR;
	}

	public int getEstanque() {
		return this.estanque;
	}

	public void setEstanque(int estanque) {
		this.estanque = estanque;
	}

	public String getFaena() {
		return this.faena;
	}

	public void setFaena(String faena) {
		this.faena = faena;
	}

	public Timestamp getFechaAsigna() {
		return this.fechaAsigna;
	}

	public void setFechaAsigna(Timestamp fechaAsigna) {
		this.fechaAsigna = fechaAsigna;
	}

	public Timestamp getFechaInst() {
		return this.fechaInst;
	}

	public void setFechaInst(Timestamp fechaInst) {
		this.fechaInst = fechaInst;
	}

	public String getFwcan() {
		return this.fwcan;
	}

	public void setFwcan(String fwcan) {
		this.fwcan = fwcan;
	}

	public String getGarmin() {
		return this.garmin;
	}

	public void setGarmin(String garmin) {
		this.garmin = garmin;
	}

	public String getHorometro() {
		return this.horometro;
	}

	public void setHorometro(String horometro) {
		this.horometro = horometro;
	}

	public String getIbutto() {
		return this.ibutto;
	}

	public void setIbutto(String ibutto) {
		this.ibutto = ibutto;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public BigDecimal getIdChofer() {
		return this.idChofer;
	}

	public void setIdChofer(BigDecimal idChofer) {
		this.idChofer = idChofer;
	}

	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getIdIbutto() {
		return this.idIbutto;
	}

	public void setIdIbutto(String idIbutto) {
		this.idIbutto = idIbutto;
	}

	public String getIdLbarra() {
		return this.idLbarra;
	}

	public void setIdLbarra(String idLbarra) {
		this.idLbarra = idLbarra;
	}

	public int getIdTipoEstadoVehiculo() {
		return this.idTipoEstadoVehiculo;
	}

	public void setIdTipoEstadoVehiculo(int idTipoEstadoVehiculo) {
		this.idTipoEstadoVehiculo = idTipoEstadoVehiculo;
	}

	public int getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getID_Vehicle() {
		return this.ID_Vehicle;
	}

	public void setID_Vehicle(String ID_Vehicle) {
		this.ID_Vehicle = ID_Vehicle;
	}

	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImei_GPS() {
		return this.imei_GPS;
	}

	public void setImei_GPS(String imei_GPS) {
		this.imei_GPS = imei_GPS;
	}

	public String getImei2() {
		return this.imei2;
	}

	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}

	public String getInstalador() {
		return this.instalador;
	}

	public void setInstalador(String instalador) {
		this.instalador = instalador;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public double getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getKopilot() {
		return this.kopilot;
	}

	public void setKopilot(String kopilot) {
		this.kopilot = kopilot;
	}

	public String getLbarra() {
		return this.lbarra;
	}

	public void setLbarra(String lbarra) {
		this.lbarra = lbarra;
	}

	public String getMarcaCamion() {
		return this.marcaCamion;
	}

	public void setMarcaCamion(String marcaCamion) {
		this.marcaCamion = marcaCamion;
	}

	public int getMicrosd() {
		return this.microsd;
	}

	public void setMicrosd(int microsd) {
		this.microsd = microsd;
	}

	public String getMobileye() {
		return this.mobileye;
	}

	public void setMobileye(String mobileye) {
		this.mobileye = mobileye;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModifAccion() {
		return this.modifAccion;
	}

	public void setModifAccion(String modifAccion) {
		this.modifAccion = modifAccion;
	}

	public Timestamp getModifFecha() {
		return this.modifFecha;
	}

	public void setModifFecha(Timestamp modifFecha) {
		this.modifFecha = modifFecha;
	}

	public String getModifUsu() {
		return this.modifUsu;
	}

	public void setModifUsu(String modifUsu) {
		this.modifUsu = modifUsu;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getNombreTercero() {
		return this.nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public String getNum_contacto() {
		return this.num_contacto;
	}

	public void setNum_contacto(String num_contacto) {
		this.num_contacto = num_contacto;
	}

	public String getNum_interno() {
		return this.num_interno;
	}

	public void setNum_interno(String num_interno) {
		this.num_interno = num_interno;
	}

	public String getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPagador() {
		return this.pagador;
	}

	public void setPagador(String pagador) {
		this.pagador = pagador;
	}

	public int getPasajero() {
		return this.pasajero;
	}

	public void setPasajero(int pasajero) {
		this.pasajero = pasajero;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public double getPesoBruto() {
		return this.pesoBruto;
	}

	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public double getPesoOperac() {
		return this.pesoOperac;
	}

	public void setPesoOperac(double pesoOperac) {
		this.pesoOperac = pesoOperac;
	}

	public int getPesometro() {
		return this.pesometro;
	}

	public void setPesometro(int pesometro) {
		this.pesometro = pesometro;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPsolar() {
		return this.psolar;
	}

	public void setPsolar(String psolar) {
		this.psolar = psolar;
	}

	public String getPuertas() {
		return this.puertas;
	}

	public void setPuertas(String puertas) {
		this.puertas = puertas;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getRoaming() {
		return this.roaming;
	}

	public void setRoaming(String roaming) {
		this.roaming = roaming;
	}

	public Timestamp getRxDate() {
		return this.rxDate;
	}

	public void setRxDate(Timestamp rxDate) {
		this.rxDate = rxDate;
	}

	public String getRX_NoM() {
		return this.RX_NoM;
	}

	public void setRX_NoM(String RX_NoM) {
		this.RX_NoM = RX_NoM;
	}

	public String getSatelital() {
		return this.satelital;
	}

	public void setSatelital(String satelital) {
		this.satelital = satelital;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getStemp() {
		return this.stemp;
	}

	public void setStemp(String stemp) {
		this.stemp = stemp;
	}

	public String getStolva() {
		return this.stolva;
	}

	public void setStolva(String stolva) {
		this.stolva = stolva;
	}

	public String getTercero_Sigla() {
		return this.tercero_Sigla;
	}

	public void setTercero_Sigla(String tercero_Sigla) {
		this.tercero_Sigla = tercero_Sigla;
	}

	public String getTipoGps() {
		return this.tipoGps;
	}

	public void setTipoGps(String tipoGps) {
		this.tipoGps = tipoGps;
	}

	public String getTipoMotor() {
		return this.tipoMotor;
	}

	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	public int getTipoSello() {
		return this.tipoSello;
	}

	public void setTipoSello(int tipoSello) {
		this.tipoSello = tipoSello;
	}

	public String getTipocan() {
		return this.tipocan;
	}

	public void setTipocan(String tipocan) {
		this.tipocan = tipocan;
	}

	public String getTx_NoM() {
		return this.tx_NoM;
	}

	public void setTx_NoM(String tx_NoM) {
		this.tx_NoM = tx_NoM;
	}

	public String getUdp() {
		return this.udp;
	}

	public void setUdp(String udp) {
		this.udp = udp;
	}

	public String getUsuarioAsigna() {
		return this.usuarioAsigna;
	}

	public void setUsuarioAsigna(String usuarioAsigna) {
		this.usuarioAsigna = usuarioAsigna;
	}

	public String getUsuarioCamion() {
		return this.usuarioCamion;
	}

	public void setUsuarioCamion(String usuarioCamion) {
		this.usuarioCamion = usuarioCamion;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getVolTolva() {
		return this.volTolva;
	}

	public void setVolTolva(double volTolva) {
		this.volTolva = volTolva;
	}

	public String getVolumetrico() {
		return this.volumetrico;
	}

	public void setVolumetrico(String volumetrico) {
		this.volumetrico = volumetrico;
	}

	public String getWifi() {
		return this.wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public int getWpsolar() {
		return this.wpsolar;
	}

	public void setWpsolar(int wpsolar) {
		this.wpsolar = wpsolar;
	}

}