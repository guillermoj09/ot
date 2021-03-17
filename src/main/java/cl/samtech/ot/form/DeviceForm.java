package cl.samtech.ot.form;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DeviceForm {

	private Long ot_id;
	private String region;
	private String cliente_login;
	private String opcion;
	private String id_ibutton;
	private Long id_instalacion;
	private String id_device;
	private Object AI_0_Desc;
	private Object AI_1_Desc;
	private Object AI_2_Desc;
	private String estado_gps;
	private Integer id_gps;
	private double odometro;
	private int anio_vehiculo;
	private int anx;
	private String ciudad;
	private String txtlbarra;
	private Object borra;
	private String bpanico;
	private String comuna;
	private Object brand;
	private String id_cds;
	private Object brand2;
	private Object buzzer;
	private Object camara;
	private Object tipo_conx_protocolo;
	private Object can;
	private Integer id_cliente;
	private int candadoElect;
	private double capBalde;
	private double capCarga;
	private Object centroCosto;
	private String chofer;
	private Object cinturon;
	private String cjornada;
	private Object color;
	private String color_vehiculo;
	private String numero_interno;
	private int combustible;
	private String con_VPN;
	private double consumoMedio;
	private Object controlador;
	private BigDecimal correlativo;
	private BigDecimal corrimientoODO;
	private Object corteComb;
	private Object descripcion;
	private Object DI_1_Desc;
	private Object DI_2_Desc;
	private Object DI_3_Desc;
	private Object DI_4_Desc;
	private Object DI_5_Desc;
	private Object DI_6_Desc;
	private Object DI_7_Desc;
	private Object DO_0_Desc;
	private Object DO_1_Desc;
	private Object DO_2_Desc;
	private Object DO_3_Desc;
	private Object dualsim;
	private String compania_sim;
	private Object easycan;
	private int envioWs;
	private boolean esPortatil;
	private int es_TCP;
	private Object escond_Area;
	private Object escond_GM;
	private int modulovoz;
	private Object escond_HO;
	private String estado;
	private int estado_AR;
	private int estanque;
	private String faena;
	private Timestamp fechaAsigna;
	private Timestamp fechaInst;
	private String fwcan;
	private Object garmin;
	private String horometro;
	private String ibutto;
	private Object icono;
	private BigDecimal idChofer;
	private int idDetalle;
	private String idIbutton;
	private String txtibutton;
	private String txtmeye;
	private String txtbuzzer;
	private String txtmodulo;
	private String txtcandadoelect;
	private String idLbarra;
	private String txtcan;
	private int idTipoEstadoVehiculo;
	private int idTipoVehiculo;
	private String tipo_gps;
	private Object ID_Vehicle;
	private int idVehiculo;
	private Object imagen;
	private Object imei;
	private Object imei_GPS;
	private Object imei2;
	private Object instalador;
	private String ip;
	private double kilometraje;
	private String kopilot;
	private String lbarra;
	private String marcaCamion;
	private int microsd;
	private String mobileye;
	private String modelo;
	private Object modifAccion;
	private Timestamp modifFecha;
	private Object modifUsu;
	private Object modulo;
	private Object nombreTercero;
	private String num_contacto;
	private String num_abonado;
	private String num_interno;
	private String num_serie;
	private String observacion;
	private Object pagador;
	private int pasajero;
	private String patente;
	private double pesoBruto;
	private double pesoOperac;
	private int pesometro;
	private String txtccto;
	private Object phone;
	private Object phone2;
	private Object psolar;
	private String puertas;
	private String registro;
	private Object roaming;
	private Timestamp rxDate;
	private Object RX_NoM;
	private Object satelital;
	private Object sn;
	private String stemp;
	private Object stolva;
	private Object tercero_Sigla;
	private Object tipoGps;
	private Object tipoMotor;
	private int tipoSello;
	private String tipocan;
	private Object tx_NoM;
	private Object udp;
	private String usuarioAsigna;
	private String usuarioCamion;
	private String vin;
	private double voltolva;
	private Object volumetrico;
	private String wifi;
	private int wpsolar;

	public DeviceForm() {
	}

	public int getModulovoz() {
		return modulovoz;
	}

	public void setModulovoz(int modulovoz) {
		this.modulovoz = modulovoz;
	}
	
	public String getTxtccto() {
		return txtccto;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setTxtccto(String txtccto) {
		this.txtccto = txtccto;
	}

	public String getId_cds() {
		return id_cds;
	}

	public void setId_cds(String id_cds) {
		this.id_cds = id_cds;
	}

	public String getId_ibutton() {
		return id_ibutton;
	}

	public void setId_ibutton(String id_ibutton) {
		this.id_ibutton = id_ibutton;
	}

	public String getTxtmeye() {
		return txtmeye;
	}

	public void setTxtmeye(String txtmeye) {
		this.txtmeye = txtmeye;
	}

	public String getTxtbuzzer() {
		return txtbuzzer;
	}

	public void setTxtbuzzer(String txtbuzzer) {
		this.txtbuzzer = txtbuzzer;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getCliente_login() {
		return cliente_login;
	}

	public void setCliente_login(String cliente_login) {
		this.cliente_login = cliente_login;
	}

	public Long getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(Long id_instalacion) {
		this.id_instalacion = id_instalacion;
	}

	public Long getOt_id() {
		return ot_id;
	}

	public void setOt_id(Long ot_id) {
		this.ot_id = ot_id;
	}

	public String getId_device() {
		return id_device;
	}

	public void setId_device(String id_device) {
		this.id_device = id_device;
	}

	public Integer getId_gps() {
		return id_gps;
	}

	public void setId_gps(Integer id_gps) {
		this.id_gps = id_gps;
	}

	public Object getTipo_conx_protocolo() {
		return tipo_conx_protocolo;
	}

	public void setTipo_conx_protocolo(Object tipo_conx_protocolo) {
		this.tipo_conx_protocolo = tipo_conx_protocolo;
	}

	public String getColor_vehiculo() {
		return color_vehiculo;
	}

	public void setColor_vehiculo(String color_vehiculo) {
		this.color_vehiculo = color_vehiculo;
	}

	public String getNumero_interno() {
		return numero_interno;
	}

	public void setNumero_interno(String numero_interno) {
		this.numero_interno = numero_interno;
	}

	public String getTipo_gps() {
		return tipo_gps;
	}

	public void setTipo_gps(String tipo_gps) {
		this.tipo_gps = tipo_gps;
	}

	public String getCompania_sim() {
		return compania_sim;
	}

	public String getEstado_gps() {
		return estado_gps;
	}

	public void setEstado_gps(String estado_gps) {
		this.estado_gps = estado_gps;
	}

	public double getOdometro() {
		return odometro;
	}

	public void setOdometro(double odometro) {
		this.odometro = odometro;
	}

	public void setCompania_sim(String compania_sim) {
		this.compania_sim = compania_sim;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNum_abonado() {
		return num_abonado;
	}

	public void setNum_abonado(String num_abonado) {
		this.num_abonado = num_abonado;
	}

	public void setVoltolva(double voltolva) {
		this.voltolva = voltolva;
	}

	public Object getAI_0_Desc() {
		return AI_0_Desc;
	}

	public void setAI_0_Desc(Object AI_0_Desc) {
		this.AI_0_Desc = AI_0_Desc;
	}

	public Object getAI_1_Desc() {
		return AI_1_Desc;
	}

	public void setAI_1_Desc(Object AI_1_Desc) {
		this.AI_1_Desc = AI_1_Desc;
	}

	public Object getAI_2_Desc() {
		return AI_2_Desc;
	}

	public void setAI_2_Desc(Object AI_2_Desc) {
		this.AI_2_Desc = AI_2_Desc;
	}

	public int getAnio_vehiculo() {
		return anio_vehiculo;
	}

	public void setAnio_vehiculo(int anio_vehiculo) {
		this.anio_vehiculo = anio_vehiculo;
	}

	public int getAnx() {
		return anx;
	}

	public void setAnx(int anx) {
		this.anx = anx;
	}

	public Object getBorra() {
		return borra;
	}

	public void setBorra(Object borra) {
		this.borra = borra;
	}

	public String getBpanico() {
		return bpanico;
	}

	public void setBpanico(String bpanico) {
		this.bpanico = bpanico;
	}

	public Object getBrand() {
		return brand;
	}

	public void setBrand(Object brand) {
		this.brand = brand;
	}

	public Object getBrand2() {
		return brand2;
	}

	public void setBrand2(Object brand2) {
		this.brand2 = brand2;
	}

	public Object getBuzzer() {
		return buzzer;
	}

	public void setBuzzer(Object buzzer) {
		this.buzzer = buzzer;
	}

	public Object getCamara() {
		return camara;
	}

	public void setCamara(Object camara) {
		this.camara = camara;
	}

	public Object getCan() {
		return can;
	}

	public void setCan(Object can) {
		this.can = can;
	}

	public int getCandadoElect() {
		return candadoElect;
	}

	public void setCandadoElect(int candadoElect) {
		this.candadoElect = candadoElect;
	}

	public double getCapBalde() {
		return capBalde;
	}

	public void setCapBalde(double capBalde) {
		this.capBalde = capBalde;
	}

	public double getCapCarga() {
		return capCarga;
	}

	public void setCapCarga(double capCarga) {
		this.capCarga = capCarga;
	}

	public Object getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(Object centroCosto) {
		this.centroCosto = centroCosto;
	}

	public String getChofer() {
		return chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public Object getCinturon() {
		return cinturon;
	}

	public void setCinturon(Object cinturon) {
		this.cinturon = cinturon;
	}

	public String getCjornada() {
		return cjornada;
	}

	public void setCjornada(String cjornada) {
		this.cjornada = cjornada;
	}

	public Object getColor() {
		return color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public int getCombustible() {
		return combustible;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public String getCon_VPN() {
		return con_VPN;
	}

	public void setCon_VPN(String con_VPN) {
		this.con_VPN = con_VPN;
	}

	public double getConsumoMedio() {
		return consumoMedio;
	}

	public void setConsumoMedio(double consumoMedio) {
		this.consumoMedio = consumoMedio;
	}

	public Object getControlador() {
		return controlador;
	}

	public void setControlador(Object controlador) {
		this.controlador = controlador;
	}

	public BigDecimal getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(BigDecimal correlativo) {
		this.correlativo = correlativo;
	}

	public BigDecimal getCorrimientoODO() {
		return corrimientoODO;
	}

	public void setCorrimientoODO(BigDecimal corrimientoODO) {
		this.corrimientoODO = corrimientoODO;
	}

	public Object getCorteComb() {
		return corteComb;
	}

	public void setCorteComb(Object corteComb) {
		this.corteComb = corteComb;
	}

	public Object getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Object descripcion) {
		this.descripcion = descripcion;
	}

	public Object getDI_1_Desc() {
		return DI_1_Desc;
	}

	public void setDI_1_Desc(Object DI_1_Desc) {
		this.DI_1_Desc = DI_1_Desc;
	}

	public Object getDI_2_Desc() {
		return DI_2_Desc;
	}

	
	public String getTxtlbarra() {
		return txtlbarra;
	}

	public void setTxtlbarra(String txtlbarra) {
		this.txtlbarra = txtlbarra;
	}

	public void setDI_2_Desc(Object DI_2_Desc) {
		this.DI_2_Desc = DI_2_Desc;
	}

	public Object getDI_3_Desc() {
		return DI_3_Desc;
	}

	public void setDI_3_Desc(Object DI_3_Desc) {
		this.DI_3_Desc = DI_3_Desc;
	}

	public Object getDI_4_Desc() {
		return DI_4_Desc;
	}

	public void setDI_4_Desc(Object DI_4_Desc) {
		this.DI_4_Desc = DI_4_Desc;
	}

	public Object getDI_5_Desc() {
		return DI_5_Desc;
	}

	public void setDI_5_Desc(Object DI_5_Desc) {
		this.DI_5_Desc = DI_5_Desc;
	}

	public Object getDI_6_Desc() {
		return DI_6_Desc;
	}

	public void setDI_6_Desc(Object DI_6_Desc) {
		this.DI_6_Desc = DI_6_Desc;
	}

	public Object getDI_7_Desc() {
		return DI_7_Desc;
	}

	public void setDI_7_Desc(Object DI_7_Desc) {
		this.DI_7_Desc = DI_7_Desc;
	}

	public Object getDO_0_Desc() {
		return DO_0_Desc;
	}

	public void setDO_0_Desc(Object DO_0_Desc) {
		this.DO_0_Desc = DO_0_Desc;
	}

	public Object getDO_1_Desc() {
		return DO_1_Desc;
	}

	public void setDO_1_Desc(Object DO_1_Desc) {
		this.DO_1_Desc = DO_1_Desc;
	}

	public Object getDO_2_Desc() {
		return DO_2_Desc;
	}

	public void setDO_2_Desc(Object DO_2_Desc) {
		this.DO_2_Desc = DO_2_Desc;
	}

	public Object getDO_3_Desc() {
		return DO_3_Desc;
	}

	public void setDO_3_Desc(Object DO_3_Desc) {
		this.DO_3_Desc = DO_3_Desc;
	}

	public Object getDualsim() {
		return dualsim;
	}

	public void setDualsim(Object dualsim) {
		this.dualsim = dualsim;
	}

	public Object getEasycan() {
		return easycan;
	}

	public void setEasycan(Object easycan) {
		this.easycan = easycan;
	}

	public int getEnvioWs() {
		return envioWs;
	}

	public void setEnvioWs(int envioWs) {
		this.envioWs = envioWs;
	}

	public boolean getEsPortatil() {
		return esPortatil;
	}

	public void setEsPortatil(boolean esPortatil) {
		this.esPortatil = esPortatil;
	}

	public int getEs_TCP() {
		return es_TCP;
	}

	public void setEs_TCP(int es_TCP) {
		this.es_TCP = es_TCP;
	}

	public Object getEscond_Area() {
		return escond_Area;
	}

	public void setEscond_Area(Object escond_Area) {
		this.escond_Area = escond_Area;
	}

	public Object getEscond_GM() {
		return escond_GM;
	}

	public void setEscond_GM(Object escond_GM) {
		this.escond_GM = escond_GM;
	}

	public Object getEscond_HO() {
		return escond_HO;
	}

	public void setEscond_HO(Object escond_HO) {
		this.escond_HO = escond_HO;
	}

	public String getTxtcan() {
		return txtcan;
	}

	public void setTxtcan(String txtcan) {
		this.txtcan = txtcan;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getEstado_AR() {
		return estado_AR;
	}

	public void setEstado_AR(int estado_AR) {
		this.estado_AR = estado_AR;
	}

	public int getEstanque() {
		return estanque;
	}

	public void setEstanque(int estanque) {
		this.estanque = estanque;
	}

	public String getFaena() {
		return faena;
	}

	public void setFaena(String faena) {
		this.faena = faena;
	}

	public Timestamp getFechaAsigna() {
		return fechaAsigna;
	}

	public void setFechaAsigna(Timestamp fechaAsigna) {
		this.fechaAsigna = fechaAsigna;
	}

	public Timestamp getFechaInst() {
		return fechaInst;
	}

	public void setFechaInst(Timestamp fechaInst) {
		this.fechaInst = fechaInst;
	}

	public String getFwcan() {
		return fwcan;
	}

	public void setFwcan(String fwcan) {
		this.fwcan = fwcan;
	}

	public Object getGarmin() {
		return garmin;
	}

	public void setGarmin(Object garmin) {
		this.garmin = garmin;
	}

	public String getHorometro() {
		return horometro;
	}

	public void setHorometro(String horometro) {
		this.horometro = horometro;
	}

	public String getIbutto() {
		return ibutto;
	}

	public void setIbutto(String ibutto) {
		this.ibutto = ibutto;
	}

	public String getTxtcandadoelect() {
		return txtcandadoelect;
	}

	public void setTxtcandadoelect(String txtcandadoelect) {
		this.txtcandadoelect = txtcandadoelect;
	}

	public Object getIcono() {
		return icono;
	}

	public void setIcono(Object icono) {
		this.icono = icono;
	}

	public BigDecimal getIdChofer() {
		return idChofer;
	}

	public void setIdChofer(BigDecimal idChofer) {
		this.idChofer = idChofer;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getIdIbutton() {
		return idIbutton;
	}

	public void setIdIbutton(String idIbutto) {
		idIbutton = idIbutto;
	}

	public String getIdLbarra() {
		return idLbarra;
	}

	public void setIdLbarra(String idLbarra) {
		this.idLbarra = idLbarra;
	}

	public int getIdTipoEstadoVehiculo() {
		return idTipoEstadoVehiculo;
	}

	public void setIdTipoEstadoVehiculo(int idTipoEstadoVehiculo) {
		this.idTipoEstadoVehiculo = idTipoEstadoVehiculo;
	}

	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public Object getID_Vehicle() {
		return ID_Vehicle;
	}

	public void setID_Vehicle(Object ID_Vehicle) {
		this.ID_Vehicle = ID_Vehicle;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Object getImagen() {
		return imagen;
	}

	public void setImagen(Object imagen) {
		this.imagen = imagen;
	}

	public Object getImei() {
		return imei;
	}

	public void setImei(Object imei) {
		this.imei = imei;
	}

	public Object getImei_GPS() {
		return imei_GPS;
	}

	public void setImei_GPS(Object imei_GPS) {
		this.imei_GPS = imei_GPS;
	}

	public String getTxtmodulo() {
		return txtmodulo;
	}

	public void setTxtmodulo(String txtmodulo) {
		this.txtmodulo = txtmodulo;
	}

	public Object getImei2() {
		return imei2;
	}

	public void setImei2(Object imei2) {
		this.imei2 = imei2;
	}

	public Object getInstalador() {
		return instalador;
	}

	public void setInstalador(Object instalador) {
		this.instalador = instalador;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getKopilot() {
		return kopilot;
	}

	public void setKopilot(String kopilot) {
		this.kopilot = kopilot;
	}

	public String getLbarra() {
		return lbarra;
	}

	public void setLbarra(String lbarra) {
		this.lbarra = lbarra;
	}

	public String getMarcaCamion() {
		return marcaCamion;
	}

	public void setMarcaCamion(String marcaCamion) {
		this.marcaCamion = marcaCamion;
	}

	public int getMicrosd() {
		return microsd;
	}

	public void setMicrosd(int microsd) {
		this.microsd = microsd;
	}

	public String getMobileye() {
		return mobileye;
	}

	public void setMobileye(String mobileye) {
		this.mobileye = mobileye;
	}

	public String getTxtibutton() {
		return txtibutton;
	}

	public void setTxtibutton(String txtibutton) {
		this.txtibutton = txtibutton;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Object getModifAccion() {
		return modifAccion;
	}

	public void setModifAccion(Object modifAccion) {
		this.modifAccion = modifAccion;
	}

	public Timestamp getModifFecha() {
		return modifFecha;
	}

	public String getStemp() {
		return stemp;
	}

	public void setStemp(String stemp) {
		this.stemp = stemp;
	}

	public void setModifFecha(Timestamp modifFecha) {
		this.modifFecha = modifFecha;
	}

	public Object getModifUsu() {
		return modifUsu;
	}

	public void setModifUsu(Object modifUsu) {
		this.modifUsu = modifUsu;
	}

	public Object getModulo() {
		return modulo;
	}

	public void setModulo(Object modulo) {
		this.modulo = modulo;
	}

	public Object getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(Object nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public String getNum_contacto() {
		return num_contacto;
	}

	public void setNum_contacto(String num_contacto) {
		this.num_contacto = num_contacto;
	}

	public String getNum_interno() {
		return num_interno;
	}

	public void setNum_interno(String num_interno) {
		this.num_interno = num_interno;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Object getPagador() {
		return pagador;
	}

	public void setPagador(Object pagador) {
		this.pagador = pagador;
	}

	public int getPasajero() {
		return pasajero;
	}

	public void setPasajero(int pasajero) {
		this.pasajero = pasajero;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public double getPesoOperac() {
		return pesoOperac;
	}

	public void setPesoOperac(double pesoOperac) {
		this.pesoOperac = pesoOperac;
	}

	public int getPesometro() {
		return pesometro;
	}

	public void setPesometro(int pesometro) {
		this.pesometro = pesometro;
	}

	public Object getPhone() {
		return phone;
	}

	public void setPhone(Object phone) {
		this.phone = phone;
	}

	public Object getPhone2() {
		return phone2;
	}

	public void setPhone2(Object phone2) {
		this.phone2 = phone2;
	}

	public Object getPsolar() {
		return psolar;
	}

	public void setPsolar(Object psolar) {
		this.psolar = psolar;
	}

	public String getPuertas() {
		return puertas;
	}

	public void setPuertas(String puertas) {
		this.puertas = puertas;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Object getRoaming() {
		return roaming;
	}

	public void setRoaming(Object roaming) {
		this.roaming = roaming;
	}

	public Timestamp getRxDate() {
		return rxDate;
	}

	public void setRxDate(Timestamp rxDate) {
		this.rxDate = rxDate;
	}

	public Object getRX_NoM() {
		return RX_NoM;
	}

	public void setRX_NoM(Object RX_NoM) {
		this.RX_NoM = RX_NoM;
	}

	public Object getSatelital() {
		return satelital;
	}

	public void setSatelital(Object satelital) {
		this.satelital = satelital;
	}

	public Object getSn() {
		return sn;
	}

	public void setSn(Object sn) {
		this.sn = sn;
	}

	public Object getStolva() {
		return stolva;
	}

	public void setStolva(Object stolva) {
		this.stolva = stolva;
	}

	public Object getTercero_Sigla() {
		return tercero_Sigla;
	}

	public void setTercero_Sigla(Object tercero_Sigla) {
		this.tercero_Sigla = tercero_Sigla;
	}

	public Object getTipoGps() {
		return tipoGps;
	}

	public void setTipoGps(Object tipoGps) {
		this.tipoGps = tipoGps;
	}

	public Object getTipoMotor() {
		return tipoMotor;
	}

	public void setTipoMotor(Object tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	public int getTipoSello() {
		return tipoSello;
	}

	public void setTipoSello(int tipoSello) {
		this.tipoSello = tipoSello;
	}

	public String getTipocan() {
		return tipocan;
	}

	public void setTipocan(String tipocan) {
		this.tipocan = tipocan;
	}

	public Object getTx_NoM() {
		return tx_NoM;
	}

	public void setTx_NoM(Object tx_NoM) {
		this.tx_NoM = tx_NoM;
	}

	public Object getUdp() {
		return udp;
	}

	public void setUdp(Object udp) {
		this.udp = udp;
	}

	public String getUsuarioAsigna() {
		return usuarioAsigna;
	}

	public void setUsuarioAsigna(String usuarioAsigna) {
		this.usuarioAsigna = usuarioAsigna;
	}

	public String getUsuarioCamion() {
		return usuarioCamion;
	}

	public void setUsuarioCamion(String usuarioCamion) {
		this.usuarioCamion = usuarioCamion;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getVoltolva() {
		return voltolva;
	}

	public void setVolTolva(double voltolva) {
		this.voltolva = voltolva;
	}

	public Object getVolumetrico() {
		return volumetrico;
	}

	public void setVolumetrico(Object volumetrico) {
		this.volumetrico = volumetrico;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public int getWpsolar() {
		return wpsolar;
	}

	public void setWpsolar(int wpsolar) {
		this.wpsolar = wpsolar;
	}
}
