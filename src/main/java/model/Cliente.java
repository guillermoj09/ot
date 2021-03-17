package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="act_password")
	private String actPassword;

	private String apellidos;

	private String app;

	@Column(name="app_activa")
	private String appActiva;

	private String ciudad;

	private String cobranza;

	private String comuna;

	@Column(name="Contacto")
	private String contacto;

	private String contrato;

	private String direccion;

	private String ejecutivo;

	@Column(name="Email")
	private String email;

	private int estado;

	@Column(name="fecha_activa")
	private Timestamp fechaActiva;

	@Column(name="fecha_baja")
	private Timestamp fechaBaja;

	@Column(name="fecha_bloqueo")
	private Timestamp fechaBloqueo;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	private int folio;

	private String fono1;

	private String fono2;

	@Column(name="geocoding_hist")
	private int geocodingHist;

	private int geocoding_UP;

	@Column(name="id_configuracion")
	private String idConfiguracion;

	@Column(name="informe_gps")
	private boolean informeGps;

	private String login;

	@Lob
	private String logo_B64;

	private String nivel;

	private String nombre;

	private int numerointerno;

	@Lob
	private String observaciones;

	private String password;

	private String piloto;

	private int prg;

	@Column(name="razon_social")
	private String razonSocial;

	private String rut;

	private String sitioGPS;

	private String tipo;

	@Column(name="tipo_cli")
	private int tipoCli;

	@Column(name="tipo_cliente")
	private String tipoCliente;

	@Column(name="tipo_inicio")
	private String tipoInicio;

	private int tipomapa;

	@Column(name="usuario_activa")
	private String usuarioActiva;

	@Column(name="usuario_baja")
	private String usuarioBaja;

	@Column(name="usuario_bloquea")
	private String usuarioBloquea;

	@Column(name="usuario_modifica")
	private String usuarioModifica;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getActPassword() {
		return this.actPassword;
	}

	public void setActPassword(String actPassword) {
		this.actPassword = actPassword;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getAppActiva() {
		return this.appActiva;
	}

	public void setAppActiva(String appActiva) {
		this.appActiva = appActiva;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCobranza() {
		return this.cobranza;
	}

	public void setCobranza(String cobranza) {
		this.cobranza = cobranza;
	}

	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContrato() {
		return this.contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEjecutivo() {
		return this.ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Timestamp getFechaActiva() {
		return this.fechaActiva;
	}

	public void setFechaActiva(Timestamp fechaActiva) {
		this.fechaActiva = fechaActiva;
	}

	public Timestamp getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Timestamp getFechaBloqueo() {
		return this.fechaBloqueo;
	}

	public void setFechaBloqueo(Timestamp fechaBloqueo) {
		this.fechaBloqueo = fechaBloqueo;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getFolio() {
		return this.folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public String getFono1() {
		return this.fono1;
	}

	public void setFono1(String fono1) {
		this.fono1 = fono1;
	}

	public String getFono2() {
		return this.fono2;
	}

	public void setFono2(String fono2) {
		this.fono2 = fono2;
	}

	public int getGeocodingHist() {
		return this.geocodingHist;
	}

	public void setGeocodingHist(int geocodingHist) {
		this.geocodingHist = geocodingHist;
	}

	public int getGeocoding_UP() {
		return this.geocoding_UP;
	}

	public void setGeocoding_UP(int geocoding_UP) {
		this.geocoding_UP = geocoding_UP;
	}

	public String getIdConfiguracion() {
		return this.idConfiguracion;
	}

	public void setIdConfiguracion(String idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public boolean getInformeGps() {
		return this.informeGps;
	}

	public void setInformeGps(boolean informeGps) {
		this.informeGps = informeGps;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogo_B64() {
		return this.logo_B64;
	}

	public void setLogo_B64(String logo_B64) {
		this.logo_B64 = logo_B64;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumerointerno() {
		return this.numerointerno;
	}

	public void setNumerointerno(int numerointerno) {
		this.numerointerno = numerointerno;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPiloto() {
		return this.piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public int getPrg() {
		return this.prg;
	}

	public void setPrg(int prg) {
		this.prg = prg;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getSitioGPS() {
		return this.sitioGPS;
	}

	public void setSitioGPS(String sitioGPS) {
		this.sitioGPS = sitioGPS;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTipoCli() {
		return this.tipoCli;
	}

	public void setTipoCli(int tipoCli) {
		this.tipoCli = tipoCli;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoInicio() {
		return this.tipoInicio;
	}

	public void setTipoInicio(String tipoInicio) {
		this.tipoInicio = tipoInicio;
	}

	public int getTipomapa() {
		return this.tipomapa;
	}

	public void setTipomapa(int tipomapa) {
		this.tipomapa = tipomapa;
	}

	public String getUsuarioActiva() {
		return this.usuarioActiva;
	}

	public void setUsuarioActiva(String usuarioActiva) {
		this.usuarioActiva = usuarioActiva;
	}

	public String getUsuarioBaja() {
		return this.usuarioBaja;
	}

	public void setUsuarioBaja(String usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}

	public String getUsuarioBloquea() {
		return this.usuarioBloquea;
	}

	public void setUsuarioBloquea(String usuarioBloquea) {
		this.usuarioBloquea = usuarioBloquea;
	}

	public String getUsuarioModifica() {
		return this.usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

}