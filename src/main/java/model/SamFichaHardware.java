package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sam_ficha_hardware database table.
 * 
 */
@Entity
@Table(name="sam_ficha_hardware")
@NamedQuery(name="SamFichaHardware.findAll", query="SELECT s FROM SamFichaHardware s")
public class SamFichaHardware implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="fh_cod_anexo")
	private int fhCodAnexo;

	@Column(name="fh_codigo_oc")
	private int fhCodigoOc;

	@Column(name="fh_fich_codigo")
	private int fhFichCodigo;
	
	@Id
	@Column(name="fh_har_codigo")
	private int fhHarCodigo;

	@Column(name="fh_observacion")
	private String fhObservacion;

	public SamFichaHardware() {
	}

	public int getFhCodAnexo() {
		return this.fhCodAnexo;
	}

	public void setFhCodAnexo(int fhCodAnexo) {
		this.fhCodAnexo = fhCodAnexo;
	}

	public int getFhCodigoOc() {
		return this.fhCodigoOc;
	}

	public void setFhCodigoOc(int fhCodigoOc) {
		this.fhCodigoOc = fhCodigoOc;
	}

	public int getFhFichCodigo() {
		return this.fhFichCodigo;
	}

	public void setFhFichCodigo(int fhFichCodigo) {
		this.fhFichCodigo = fhFichCodigo;
	}

	public int getFhHarCodigo() {
		return this.fhHarCodigo;
	}

	public void setFhHarCodigo(int fhHarCodigo) {
		this.fhHarCodigo = fhHarCodigo;
	}

	public String getFhObservacion() {
		return this.fhObservacion;
	}

	public void setFhObservacion(String fhObservacion) {
		this.fhObservacion = fhObservacion;
	}

}