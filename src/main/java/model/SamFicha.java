package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sam_ficha database table.
 * 
 */
@Entity
@Table(name="sam_ficha")
@NamedQuery(name="SamFicha.findAll", query="SELECT s FROM SamFicha s")
public class SamFicha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fich_codigo")
	private int fichCodigo;

	private int actualiza;

	@Column(name="fich_alias")
	private String fichAlias;

	@Column(name="fich_cant_moviles")
	private int fichCantMoviles;

	@Column(name="fich_cantidad_total")
	private int fichCantidadTotal;

	@Column(name="fich_cargo_comercial")
	private String fichCargoComercial;

	@Column(name="fich_cargo_fact")
	private String fichCargoFact;

	@Column(name="fich_cargo_inst")
	private String fichCargoInst;

	@Column(name="fich_cargo_rl")
	private String fichCargoRl;

	@Column(name="fich_cargo_usu")
	private String fichCargoUsu;

	@Column(name="fich_cel_comercial")
	private String fichCelComercial;

	@Column(name="fich_celu_fact")
	private String fichCeluFact;

	@Column(name="fich_celu_inst")
	private String fichCeluInst;

	@Column(name="fich_celu_rl")
	private String fichCeluRl;

	@Column(name="fich_celu_usu")
	private String fichCeluUsu;

	@Column(name="fich_ciudad")
	private String fichCiudad;

	@Column(name="fich_comuna")
	private String fichComuna;

	@Column(name="fich_contrato")
	private int fichContrato;

	@Column(name="fich_cuando_modifica")
	private Timestamp fichCuandoModifica;

	@Column(name="fich_desarrollo_espacial")
	private double fichDesarrolloEspacial;

	@Column(name="fich_df")
	private int fichDf;

	@Column(name="fich_dia_pago")
	private int fichDiaPago;

	@Column(name="fich_direccion")
	private String fichDireccion;

	@Column(name="fich_directo_comercial")
	private String fichDirectoComercial;

	@Column(name="fich_directo_fact")
	private String fichDirectoFact;

	@Column(name="fich_directo_inst")
	private String fichDirectoInst;

	@Column(name="fich_directo_rl")
	private String fichDirectoRl;

	@Column(name="fich_directo_usu")
	private String fichDirectoUsu;

	@Column(name="fich_estado")
	private int fichEstado;

	@Column(name="fich_fecha_cnto")
	private String fichFechaCnto;

	@Column(name="fich_fecha_ingreso")
	private Timestamp fichFechaIngreso;

	@Column(name="fich_giro")
	private String fichGiro;

	@Column(name="fich_id_cliente_sf")
	private int fichIdClienteSf;

	@Column(name="fich_login")
	private String fichLogin;

	@Column(name="fich_login_cliente")
	private String fichLoginCliente;

	@Column(name="fich_mail_comercial")
	private String fichMailComercial;

	@Column(name="fich_mail_fact")
	private String fichMailFact;

	@Column(name="fich_mail_inst")
	private String fichMailInst;

	@Column(name="fich_mail_rl")
	private String fichMailRl;

	@Column(name="fich_mail_usu")
	private String fichMailUsu;

	@Column(name="fich_nom_comercial")
	private String fichNomComercial;

	@Column(name="fich_nom_fact")
	private String fichNomFact;

	@Column(name="fich_nom_fnta")
	private String fichNomFnta;

	@Column(name="fich_nom_inst")
	private String fichNomInst;

	@Column(name="fich_nom_rl")
	private String fichNomRl;

	@Column(name="fich_nom_usu")
	private String fichNomUsu;

	@Column(name="fich_nombre")
	private String fichNombre;

	@Column(name="fich_num_contrato")
	private String fichNumContrato;

	@Column(name="fich_periodo_contrato")
	private double fichPeriodoContrato;

	@Column(name="fich_periodo_demo")
	private int fichPeriodoDemo;

	@Column(name="fich_periodo_leasing")
	private double fichPeriodoLeasing;

	@Column(name="fich_quien_modifica")
	private String fichQuienModifica;

	@Column(name="fich_razon_social")
	private String fichRazonSocial;

	@Column(name="fich_recargo_tralado")
	private double fichRecargoTralado;

	@Column(name="fich_requ_facturacion")
	private String fichRequFacturacion;

	@Column(name="fich_rut")
	private String fichRut;

	@Column(name="fich_ruta_file")
	private String fichRutaFile;

	@Column(name="fich_telefono")
	private String fichTelefono;

	@Column(name="fich_tipcli_codigo")
	private int fichTipcliCodigo;

	@Column(name="fich_tipo_demo")
	private int fichTipoDemo;

	@Column(name="fich_tipo_empresa")
	private String fichTipoEmpresa;

	@Column(name="fich_usu_codigo")
	private int fichUsuCodigo;

	@Column(name="fich_usu_modifica")
	private int fichUsuModifica;

	@Column(name="fich_valor_arri_gps")
	private double fichValorArriGps;

	@Column(name="fich_valor_arri_otrso")
	private double fichValorArriOtrso;

	@Column(name="fich_valor_gps")
	private double fichValorGps;

	@Column(name="fich_valor_mod_voz")
	private double fichValorModVoz;

	@Column(name="fich_valor_otros_serv")
	private double fichValorOtrosServ;

	@Column(name="fich_valor_serv_mes")
	private double fichValorServMes;

	@Column(name="fich_valor_serv_mes_mobileye")
	private double fichValorServMesMobileye;

	@Column(name="fich_venta_leasing")
	private double fichVentaLeasing;

	public SamFicha() {
	}

	public int getFichCodigo() {
		return this.fichCodigo;
	}

	public void setFichCodigo(int fichCodigo) {
		this.fichCodigo = fichCodigo;
	}

	public int getActualiza() {
		return this.actualiza;
	}

	public void setActualiza(int actualiza) {
		this.actualiza = actualiza;
	}

	public String getFichAlias() {
		return this.fichAlias;
	}

	public void setFichAlias(String fichAlias) {
		this.fichAlias = fichAlias;
	}

	public int getFichCantMoviles() {
		return this.fichCantMoviles;
	}

	public void setFichCantMoviles(int fichCantMoviles) {
		this.fichCantMoviles = fichCantMoviles;
	}

	public int getFichCantidadTotal() {
		return this.fichCantidadTotal;
	}

	public void setFichCantidadTotal(int fichCantidadTotal) {
		this.fichCantidadTotal = fichCantidadTotal;
	}

	public String getFichCargoComercial() {
		return this.fichCargoComercial;
	}

	public void setFichCargoComercial(String fichCargoComercial) {
		this.fichCargoComercial = fichCargoComercial;
	}

	public String getFichCargoFact() {
		return this.fichCargoFact;
	}

	public void setFichCargoFact(String fichCargoFact) {
		this.fichCargoFact = fichCargoFact;
	}

	public String getFichCargoInst() {
		return this.fichCargoInst;
	}

	public void setFichCargoInst(String fichCargoInst) {
		this.fichCargoInst = fichCargoInst;
	}

	public String getFichCargoRl() {
		return this.fichCargoRl;
	}

	public void setFichCargoRl(String fichCargoRl) {
		this.fichCargoRl = fichCargoRl;
	}

	public String getFichCargoUsu() {
		return this.fichCargoUsu;
	}

	public void setFichCargoUsu(String fichCargoUsu) {
		this.fichCargoUsu = fichCargoUsu;
	}

	public String getFichCelComercial() {
		return this.fichCelComercial;
	}

	public void setFichCelComercial(String fichCelComercial) {
		this.fichCelComercial = fichCelComercial;
	}

	public String getFichCeluFact() {
		return this.fichCeluFact;
	}

	public void setFichCeluFact(String fichCeluFact) {
		this.fichCeluFact = fichCeluFact;
	}

	public String getFichCeluInst() {
		return this.fichCeluInst;
	}

	public void setFichCeluInst(String fichCeluInst) {
		this.fichCeluInst = fichCeluInst;
	}

	public String getFichCeluRl() {
		return this.fichCeluRl;
	}

	public void setFichCeluRl(String fichCeluRl) {
		this.fichCeluRl = fichCeluRl;
	}

	public String getFichCeluUsu() {
		return this.fichCeluUsu;
	}

	public void setFichCeluUsu(String fichCeluUsu) {
		this.fichCeluUsu = fichCeluUsu;
	}

	public String getFichCiudad() {
		return this.fichCiudad;
	}

	public void setFichCiudad(String fichCiudad) {
		this.fichCiudad = fichCiudad;
	}

	public String getFichComuna() {
		return this.fichComuna;
	}

	public void setFichComuna(String fichComuna) {
		this.fichComuna = fichComuna;
	}

	public int getFichContrato() {
		return this.fichContrato;
	}

	public void setFichContrato(int fichContrato) {
		this.fichContrato = fichContrato;
	}

	public Timestamp getFichCuandoModifica() {
		return this.fichCuandoModifica;
	}

	public void setFichCuandoModifica(Timestamp fichCuandoModifica) {
		this.fichCuandoModifica = fichCuandoModifica;
	}

	public double getFichDesarrolloEspacial() {
		return this.fichDesarrolloEspacial;
	}

	public void setFichDesarrolloEspacial(double fichDesarrolloEspacial) {
		this.fichDesarrolloEspacial = fichDesarrolloEspacial;
	}

	public int getFichDf() {
		return this.fichDf;
	}

	public void setFichDf(int fichDf) {
		this.fichDf = fichDf;
	}

	public int getFichDiaPago() {
		return this.fichDiaPago;
	}

	public void setFichDiaPago(int fichDiaPago) {
		this.fichDiaPago = fichDiaPago;
	}

	public String getFichDireccion() {
		return this.fichDireccion;
	}

	public void setFichDireccion(String fichDireccion) {
		this.fichDireccion = fichDireccion;
	}

	public String getFichDirectoComercial() {
		return this.fichDirectoComercial;
	}

	public void setFichDirectoComercial(String fichDirectoComercial) {
		this.fichDirectoComercial = fichDirectoComercial;
	}

	public String getFichDirectoFact() {
		return this.fichDirectoFact;
	}

	public void setFichDirectoFact(String fichDirectoFact) {
		this.fichDirectoFact = fichDirectoFact;
	}

	public String getFichDirectoInst() {
		return this.fichDirectoInst;
	}

	public void setFichDirectoInst(String fichDirectoInst) {
		this.fichDirectoInst = fichDirectoInst;
	}

	public String getFichDirectoRl() {
		return this.fichDirectoRl;
	}

	public void setFichDirectoRl(String fichDirectoRl) {
		this.fichDirectoRl = fichDirectoRl;
	}

	public String getFichDirectoUsu() {
		return this.fichDirectoUsu;
	}

	public void setFichDirectoUsu(String fichDirectoUsu) {
		this.fichDirectoUsu = fichDirectoUsu;
	}

	public int getFichEstado() {
		return this.fichEstado;
	}

	public void setFichEstado(int fichEstado) {
		this.fichEstado = fichEstado;
	}

	public String getFichFechaCnto() {
		return this.fichFechaCnto;
	}

	public void setFichFechaCnto(String fichFechaCnto) {
		this.fichFechaCnto = fichFechaCnto;
	}

	public Timestamp getFichFechaIngreso() {
		return this.fichFechaIngreso;
	}

	public void setFichFechaIngreso(Timestamp fichFechaIngreso) {
		this.fichFechaIngreso = fichFechaIngreso;
	}

	public String getFichGiro() {
		return this.fichGiro;
	}

	public void setFichGiro(String fichGiro) {
		this.fichGiro = fichGiro;
	}

	public int getFichIdClienteSf() {
		return this.fichIdClienteSf;
	}

	public void setFichIdClienteSf(int fichIdClienteSf) {
		this.fichIdClienteSf = fichIdClienteSf;
	}

	public String getFichLogin() {
		return this.fichLogin;
	}

	public void setFichLogin(String fichLogin) {
		this.fichLogin = fichLogin;
	}

	public String getFichLoginCliente() {
		return this.fichLoginCliente;
	}

	public void setFichLoginCliente(String fichLoginCliente) {
		this.fichLoginCliente = fichLoginCliente;
	}

	public String getFichMailComercial() {
		return this.fichMailComercial;
	}

	public void setFichMailComercial(String fichMailComercial) {
		this.fichMailComercial = fichMailComercial;
	}

	public String getFichMailFact() {
		return this.fichMailFact;
	}

	public void setFichMailFact(String fichMailFact) {
		this.fichMailFact = fichMailFact;
	}

	public String getFichMailInst() {
		return this.fichMailInst;
	}

	public void setFichMailInst(String fichMailInst) {
		this.fichMailInst = fichMailInst;
	}

	public String getFichMailRl() {
		return this.fichMailRl;
	}

	public void setFichMailRl(String fichMailRl) {
		this.fichMailRl = fichMailRl;
	}

	public String getFichMailUsu() {
		return this.fichMailUsu;
	}

	public void setFichMailUsu(String fichMailUsu) {
		this.fichMailUsu = fichMailUsu;
	}

	public String getFichNomComercial() {
		return this.fichNomComercial;
	}

	public void setFichNomComercial(String fichNomComercial) {
		this.fichNomComercial = fichNomComercial;
	}

	public String getFichNomFact() {
		return this.fichNomFact;
	}

	public void setFichNomFact(String fichNomFact) {
		this.fichNomFact = fichNomFact;
	}

	public String getFichNomFnta() {
		return this.fichNomFnta;
	}

	public void setFichNomFnta(String fichNomFnta) {
		this.fichNomFnta = fichNomFnta;
	}

	public String getFichNomInst() {
		return this.fichNomInst;
	}

	public void setFichNomInst(String fichNomInst) {
		this.fichNomInst = fichNomInst;
	}

	public String getFichNomRl() {
		return this.fichNomRl;
	}

	public void setFichNomRl(String fichNomRl) {
		this.fichNomRl = fichNomRl;
	}

	public String getFichNomUsu() {
		return this.fichNomUsu;
	}

	public void setFichNomUsu(String fichNomUsu) {
		this.fichNomUsu = fichNomUsu;
	}

	public String getFichNombre() {
		return this.fichNombre;
	}

	public void setFichNombre(String fichNombre) {
		this.fichNombre = fichNombre;
	}

	public String getFichNumContrato() {
		return this.fichNumContrato;
	}

	public void setFichNumContrato(String fichNumContrato) {
		this.fichNumContrato = fichNumContrato;
	}

	public double getFichPeriodoContrato() {
		return this.fichPeriodoContrato;
	}

	public void setFichPeriodoContrato(double fichPeriodoContrato) {
		this.fichPeriodoContrato = fichPeriodoContrato;
	}

	public int getFichPeriodoDemo() {
		return this.fichPeriodoDemo;
	}

	public void setFichPeriodoDemo(int fichPeriodoDemo) {
		this.fichPeriodoDemo = fichPeriodoDemo;
	}

	public double getFichPeriodoLeasing() {
		return this.fichPeriodoLeasing;
	}

	public void setFichPeriodoLeasing(double fichPeriodoLeasing) {
		this.fichPeriodoLeasing = fichPeriodoLeasing;
	}

	public String getFichQuienModifica() {
		return this.fichQuienModifica;
	}

	public void setFichQuienModifica(String fichQuienModifica) {
		this.fichQuienModifica = fichQuienModifica;
	}

	public String getFichRazonSocial() {
		return this.fichRazonSocial;
	}

	public void setFichRazonSocial(String fichRazonSocial) {
		this.fichRazonSocial = fichRazonSocial;
	}

	public double getFichRecargoTralado() {
		return this.fichRecargoTralado;
	}

	public void setFichRecargoTralado(double fichRecargoTralado) {
		this.fichRecargoTralado = fichRecargoTralado;
	}

	public String getFichRequFacturacion() {
		return this.fichRequFacturacion;
	}

	public void setFichRequFacturacion(String fichRequFacturacion) {
		this.fichRequFacturacion = fichRequFacturacion;
	}

	public String getFichRut() {
		return this.fichRut;
	}

	public void setFichRut(String fichRut) {
		this.fichRut = fichRut;
	}

	public String getFichRutaFile() {
		return this.fichRutaFile;
	}

	public void setFichRutaFile(String fichRutaFile) {
		this.fichRutaFile = fichRutaFile;
	}

	public String getFichTelefono() {
		return this.fichTelefono;
	}

	public void setFichTelefono(String fichTelefono) {
		this.fichTelefono = fichTelefono;
	}

	public int getFichTipcliCodigo() {
		return this.fichTipcliCodigo;
	}

	public void setFichTipcliCodigo(int fichTipcliCodigo) {
		this.fichTipcliCodigo = fichTipcliCodigo;
	}

	public int getFichTipoDemo() {
		return this.fichTipoDemo;
	}

	public void setFichTipoDemo(int fichTipoDemo) {
		this.fichTipoDemo = fichTipoDemo;
	}

	public String getFichTipoEmpresa() {
		return this.fichTipoEmpresa;
	}

	public void setFichTipoEmpresa(String fichTipoEmpresa) {
		this.fichTipoEmpresa = fichTipoEmpresa;
	}

	public int getFichUsuCodigo() {
		return this.fichUsuCodigo;
	}

	public void setFichUsuCodigo(int fichUsuCodigo) {
		this.fichUsuCodigo = fichUsuCodigo;
	}

	public int getFichUsuModifica() {
		return this.fichUsuModifica;
	}

	public void setFichUsuModifica(int fichUsuModifica) {
		this.fichUsuModifica = fichUsuModifica;
	}

	public double getFichValorArriGps() {
		return this.fichValorArriGps;
	}

	public void setFichValorArriGps(double fichValorArriGps) {
		this.fichValorArriGps = fichValorArriGps;
	}

	public double getFichValorArriOtrso() {
		return this.fichValorArriOtrso;
	}

	public void setFichValorArriOtrso(double fichValorArriOtrso) {
		this.fichValorArriOtrso = fichValorArriOtrso;
	}

	public double getFichValorGps() {
		return this.fichValorGps;
	}

	public void setFichValorGps(double fichValorGps) {
		this.fichValorGps = fichValorGps;
	}

	public double getFichValorModVoz() {
		return this.fichValorModVoz;
	}

	public void setFichValorModVoz(double fichValorModVoz) {
		this.fichValorModVoz = fichValorModVoz;
	}

	public double getFichValorOtrosServ() {
		return this.fichValorOtrosServ;
	}

	public void setFichValorOtrosServ(double fichValorOtrosServ) {
		this.fichValorOtrosServ = fichValorOtrosServ;
	}

	public double getFichValorServMes() {
		return this.fichValorServMes;
	}

	public void setFichValorServMes(double fichValorServMes) {
		this.fichValorServMes = fichValorServMes;
	}

	public double getFichValorServMesMobileye() {
		return this.fichValorServMesMobileye;
	}

	public void setFichValorServMesMobileye(double fichValorServMesMobileye) {
		this.fichValorServMesMobileye = fichValorServMesMobileye;
	}

	public double getFichVentaLeasing() {
		return this.fichVentaLeasing;
	}

	public void setFichVentaLeasing(double fichVentaLeasing) {
		this.fichVentaLeasing = fichVentaLeasing;
	}

}