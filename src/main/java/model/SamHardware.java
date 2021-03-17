package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sam_hardware database table.
 * 
 */
@Entity
@Table(name="sam_hardware")
@NamedQuery(name="SamHardware.findAll", query="SELECT s FROM SamHardware s")
public class SamHardware implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="har_codigo")
	private int harCodigo;

	@Column(name="har_check")
	private String harCheck;

	@Column(name="har_nombre")
	private String harNombre;

	@Column(name="har_orden")
	private int harOrden;

	@Column(name="har_tip_emp")
	private int harTipEmp;

	@Column(name="har_tip_hardware")
	private int harTipHardware;

	@Column(name="har_vigencia")
	private int harVigencia;

	public SamHardware() {
	}

	public int getHarCodigo() {
		return this.harCodigo;
	}

	public void setHarCodigo(int harCodigo) {
		this.harCodigo = harCodigo;
	}

	public String getHarCheck() {
		return this.harCheck;
	}

	public void setHarCheck(String harCheck) {
		this.harCheck = harCheck;
	}

	public String getHarNombre() {
		return this.harNombre;
	}

	public void setHarNombre(String harNombre) {
		this.harNombre = harNombre;
	}

	public int getHarOrden() {
		return this.harOrden;
	}

	public void setHarOrden(int harOrden) {
		this.harOrden = harOrden;
	}

	public int getHarTipEmp() {
		return this.harTipEmp;
	}

	public void setHarTipEmp(int harTipEmp) {
		this.harTipEmp = harTipEmp;
	}

	public int getHarTipHardware() {
		return this.harTipHardware;
	}

	public void setHarTipHardware(int harTipHardware) {
		this.harTipHardware = harTipHardware;
	}

	public int getHarVigencia() {
		return this.harVigencia;
	}

	public void setHarVigencia(int harVigencia) {
		this.harVigencia = harVigencia;
	}

}