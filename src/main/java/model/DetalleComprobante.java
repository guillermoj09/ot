package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_comprobante database table.
 * 
 */
@Entity
@Table(name="detalle_comprobante")
@NamedQuery(name="DetalleComprobante.findAll", query="SELECT d FROM DetalleComprobante d")
public class DetalleComprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	@Column(name="id_instalacion")
	private Integer idInstalacion;

	@Column(name="id_ot")
	private Integer idOt;

	//bi-directional many-to-one association to Comprobante
	@ManyToOne
	@JoinColumn(name="id_comprobante")
	private Comprobante comprobante;

	public DetalleComprobante() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdInstalacion() {
		return this.idInstalacion;
	}

	public void setIdInstalacion(Integer idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public Integer getIdOt() {
		return this.idOt;
	}

	public void setIdOt(Integer idOt) {
		this.idOt = idOt;
	}

	public Comprobante getComprobante() {
		return this.comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

}