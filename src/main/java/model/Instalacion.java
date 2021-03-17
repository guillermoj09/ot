package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instalacion database table.
 * 
 */
@Entity
@NamedQuery(name="Instalacion.findAll", query="SELECT i FROM Instalacion i")
public class Instalacion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	@Column(name="anio_vehiculo")
	private String anioVehiculo;
	
	@Column(name="observacion")
	private String observacion;
	
	private String cliente;

	@Column(name="color_vehiculo")
	private String colorVehiculo;

	@Column(name="compania_sim")
	private String companiaSim;
	
	private String region;
	
	@Column(name="dual_sim")
	private String dualSim;

	@Column(name="estado_gps")
	private String estadoGps;

	private String faena;

	@Column(name="id_device")
	private String idDevice;
	
	private String  ciudad;
	
	private String imei;

	@Column(name="marca_vehiculo")
	private String marcaVehiculo;

	@Column(name="modelo_vehiculo")
	private String modeloVehiculo;

	@Column(name="num_abonado")
	private String numAbonado;

	@Column(name="num_chip")
	private String numChip;

	@Column(name="num_interno_veh")
	private String numInternoVeh;

	private double odometro;

	private String patente;
	
	private Timestamp fechainicio;
	
	private Integer estado;

	@Column(name="tipo_conex_prot")
	private String tipoConexProt;

	@Column(name="tipo_conex_vpn")
	private String tipoConexVpn;

	@Column(name="tipo_gps")
	private String tipoGps;

	@Column(name="tipo_vehiculo")
	private String tipoVehiculo;

	@Column(name="vin_vehiculo")
	private String vinVehiculo;

	@Column(name="voltaje__vehiculo")
	private double voltajeVehiculo;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="instalacion",cascade = CascadeType.PERSIST)
	private List<Foto> fotos;
	
	@OneToMany(mappedBy="instalacion",cascade = CascadeType.PERSIST)
	private List<Periferico> perificos;
	
	//bi-directional many-to-one association to Ot
	@ManyToOne
	@JoinColumn(name="id_ot")
	private Ot ot;
	
	private Integer anexo;
	
	public Instalacion() {
	}

	public Long getId() {
		return this.id;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnexo() {
		return anexo;
	}

	public void setAnexo(Integer anexo) {
		this.anexo = anexo;
	}

	public String getCiudad() {
		return ciudad;
	}
	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getEstado() {
		return estado;
	}
	
	public Timestamp getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getAnioVehiculo() {
		return this.anioVehiculo;
	}

	public void setAnioVehiculo(String anioVehiculo) {
		this.anioVehiculo = anioVehiculo;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getColorVehiculo() {
		return this.colorVehiculo;
	}

	public void setColorVehiculo(String colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public String getCompaniaSim() {
		return this.companiaSim;
	}

	public void setCompaniaSim(String companiaSim) {
		this.companiaSim = companiaSim;
	}

	public String getDualSim() {
		return this.dualSim;
	}

	public void setDualSim(String dualSim) {
		this.dualSim = dualSim;
	}

	public String getEstadoGps() {
		return this.estadoGps;
	}

	public void setEstadoGps(String estadoGps) {
		this.estadoGps = estadoGps;
	}

	public String getFaena() {
		return this.faena;
	}

	public void setFaena(String faena) {
		this.faena = faena;
	}

	public String getIdDevice() {
		return this.idDevice;
	}

	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getMarcaVehiculo() {
		return this.marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public String getModeloVehiculo() {
		return this.modeloVehiculo;
	}

	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public String getNumAbonado() {
		return this.numAbonado;
	}

	public void setNumAbonado(String numAbonado) {
		this.numAbonado = numAbonado;
	}

	public String getNumChip() {
		return this.numChip;
	}

	public void setNumChip(String numChip) {
		this.numChip = numChip;
	}

	public String getNumInternoVeh() {
		return this.numInternoVeh;
	}

	public void setNumInternoVeh(String numInternoVeh) {
		this.numInternoVeh = numInternoVeh;
	}

	public double getOdometro() {
		return this.odometro;
	}

	public void setOdometro(double odometro) {
		this.odometro = odometro;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getTipoConexProt() {
		return this.tipoConexProt;
	}

	public void setTipoConexProt(String tipoConexProt) {
		this.tipoConexProt = tipoConexProt;
	}

	public String getTipoConexVpn() {
		return this.tipoConexVpn;
	}

	public void setTipoConexVpn(String tipoConexVpn) {
		this.tipoConexVpn = tipoConexVpn;
	}

	public String getTipoGps() {
		return this.tipoGps;
	}

	public void setTipoGps(String tipoGps) {
		this.tipoGps = tipoGps;
	}

	public String getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getVinVehiculo() {
		return this.vinVehiculo;
	}

	public void setVinVehiculo(String vinVehiculo) {
		this.vinVehiculo = vinVehiculo;
	}

	public double getVoltajeVehiculo() {
		return this.voltajeVehiculo;
	}

	public void setVoltajeVehiculo(double voltajeVehiculo) {
		this.voltajeVehiculo = voltajeVehiculo;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setInstalacion(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setInstalacion(null);

		return foto;
	}
	
	public List<Periferico> getPerificos() {
		return perificos;
	}

	public void setPerificos(List<Periferico> perificos) {
		this.perificos = perificos;
	}
	
	public Ot getOt() {
		return this.ot;
	}

	public void setOt(Ot ot) {
		this.ot = ot;
	}

}