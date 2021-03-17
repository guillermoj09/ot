package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resumen_ifo database table.
 * 
 */
@Entity
@Table(name="resumen_ifo")
@NamedQuery(name="ResumenIfo.findAll", query="SELECT r FROM ResumenIfo r")
public class ResumenIfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="id_firma")
	private Long idFirma;

	private String observacion;

	@Column(name="id_ot")
	private Long idOt;

	public ResumenIfo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdFirma() {
		return this.idFirma;
	}

	public void setIdFirma(Long idFirma) {
		this.idFirma = idFirma;
	}

	public Long getIdOt() {
		return this.idOt;
	}

	public void setIdOt(Long idOt) {
		this.idOt = idOt;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}