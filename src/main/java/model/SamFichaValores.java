package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sam_ficha_valores database table.
 * 
 */
@Entity
@Table(name="sam_ficha_valores")
@NamedQuery(name="SamFichaValores.findAll", query="SELECT s FROM SamFichaValores s")
public class SamFichaValores implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="fv_cod_anexo")
	private int fvCodAnexo;

	@Column(name="fv_fich_codigo")
	private int fvFichCodigo;

	@Column(name="fv_observacion")
	private String fvObservacion;

	@Column(name="fv_val_codigo")
	private int fvValCodigo;

	@Column(name="fv_valor")
	private String fvValor;

	public SamFichaValores() {
	}

	public int getFvCodAnexo() {
		return this.fvCodAnexo;
	}

	public void setFvCodAnexo(int fvCodAnexo) {
		this.fvCodAnexo = fvCodAnexo;
	}

	public int getFvFichCodigo() {
		return this.fvFichCodigo;
	}

	public void setFvFichCodigo(int fvFichCodigo) {
		this.fvFichCodigo = fvFichCodigo;
	}

	public String getFvObservacion() {
		return this.fvObservacion;
	}

	public void setFvObservacion(String fvObservacion) {
		this.fvObservacion = fvObservacion;
	}

	public int getFvValCodigo() {
		return this.fvValCodigo;
	}

	public void setFvValCodigo(int fvValCodigo) {
		this.fvValCodigo = fvValCodigo;
	}

	public String getFvValor() {
		return this.fvValor;
	}

	public void setFvValor(String fvValor) {
		this.fvValor = fvValor;
	}

}