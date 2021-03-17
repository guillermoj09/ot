package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perifericos database table.
 * 
 */
@Entity
@Table(name="perifericos")
@NamedQuery(name="Periferico.findAll", query="SELECT p FROM Periferico p")
public class Periferico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer estado;

	@Column(name="id_device")
	private String idDevice;

	@Column(name="id_sam_ficha_hardware")
	private Integer idSamFichaHardware;

	private String marca;

	private String modelo;
	
	private String nombre;
	
	private String id_periferico;
	
	@ManyToOne
	@JoinColumn(name="id_instalacion")
	private Instalacion instalacion;
	
	public Periferico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEstado() {
		return this.estado;
	}
	
	public String getId_periferico() {
		return id_periferico;
	}

	public void setId_periferico(String id_periferico) {
		this.id_periferico = id_periferico;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getIdDevice() {
		return this.idDevice;
	}

	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	

	public Integer getIdSamFichaHardware() {
		return this.idSamFichaHardware;
	}

	public void setIdSamFichaHardware(Integer idSamFichaHardware) {
		this.idSamFichaHardware = idSamFichaHardware;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	

}