package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modelos_perifericos database table.
 * 
 */
@Entity
@Table(name="modelos_perifericos")
@NamedQuery(name="ModelosPeriferico.findAll", query="SELECT m FROM ModelosPeriferico m")
public class ModelosPeriferico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="id_sam_ficha_hardware")
	private Integer idSamFichaHardware;

	private String modelo;

	private String nombre;

	public ModelosPeriferico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdSamFichaHardware() {
		return this.idSamFichaHardware;
	}

	public void setIdSamFichaHardware(Integer idSamFichaHardware) {
		this.idSamFichaHardware = idSamFichaHardware;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}