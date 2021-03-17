package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the comprobante database table.
 * 
 */
@Entity
@NamedQuery(name="Comprobante.findAll", query="SELECT c FROM Comprobante c")
public class Comprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	private Timestamp fecha;

	private String observacion;
	
	private String anexo;
	
	private String folio;

	//bi-directional many-to-one association to FotoFirma
	@ManyToOne
	@JoinColumn(name="id_foto_firma")
	private FotoFirma fotoFirma;

	//bi-directional many-to-one association to DetalleComprobante
	@OneToMany(mappedBy="comprobante")
	private List<DetalleComprobante> detalleComprobantes;

	public Comprobante() {
	}
	
	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}


	public String getFolio() {
		return folio;
	}


	public void setFolio(String folio) {
		this.folio = folio;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public FotoFirma getFotoFirma() {
		return this.fotoFirma;
	}

	public void setFotoFirma(FotoFirma fotoFirma) {
		this.fotoFirma = fotoFirma;
	}

	public List<DetalleComprobante> getDetalleComprobantes() {
		return this.detalleComprobantes;
	}

	public void setDetalleComprobantes(List<DetalleComprobante> detalleComprobantes) {
		this.detalleComprobantes = detalleComprobantes;
	}

	public DetalleComprobante addDetalleComprobante(DetalleComprobante detalleComprobante) {
		getDetalleComprobantes().add(detalleComprobante);
		detalleComprobante.setComprobante(this);

		return detalleComprobante;
	}

	public DetalleComprobante removeDetalleComprobante(DetalleComprobante detalleComprobante) {
		getDetalleComprobantes().remove(detalleComprobante);
		detalleComprobante.setComprobante(null);

		return detalleComprobante;
	}

}