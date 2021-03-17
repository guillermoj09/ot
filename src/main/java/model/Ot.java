package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ot database table.
 * 
 */
@Entity
@NamedQuery(name="Ot.findAll", query="SELECT o FROM Ot o")
public class Ot implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Timestamp fechainicio;

	private Timestamp fechatermino;

	private String observaciones;
	
	private Integer estado;

	//bi-directional many-to-one association to FotoFirma
	
	
	//bi-directional many-to-one association to Instalacion
	@OneToMany(mappedBy="ot")
	private List<Instalacion> instalacions;

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Ot() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Timestamp getFechatermino() {
		return this.fechatermino;
	}

	public void setFechatermino(Timestamp fechatermino) {
		this.fechatermino = fechatermino;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public List<Instalacion> getInstalacions() {
		return this.instalacions;
	}

	public void setInstalacions(List<Instalacion> instalacions) {
		this.instalacions = instalacions;
	}

	public Instalacion addInstalacion(Instalacion instalacion) {
		getInstalacions().add(instalacion);
		instalacion.setOt(this);

		return instalacion;
	}

	public Instalacion removeInstalacion(Instalacion instalacion) {
		getInstalacions().remove(instalacion);
		instalacion.setOt(null);

		return instalacion;
	}

}