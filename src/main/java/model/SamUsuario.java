package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sam_usuario database table.
 * 
 */
@Entity
@Table(name="sam_usuario")
@NamedQuery(name="SamUsuario.findAll", query="SELECT s FROM SamUsuario s")
public class SamUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usu_codigo")
	private int usuCodigo;

	@Column(name="es_comercial")
	private int esComercial;

	@Column(name="usu_area")
	private String usuArea;

	@Column(name="usu_clave")
	private String usuClave;

	private String usu_cod_CV;

	@Column(name="usu_df")
	private int usuDf;

	@Column(name="usu_estado")
	private int usuEstado;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_tipo")
	private int usuTipo;

	public SamUsuario() {
	}

	public int getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(int usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public int getEsComercial() {
		return this.esComercial;
	}

	public void setEsComercial(int esComercial) {
		this.esComercial = esComercial;
	}

	public String getUsuArea() {
		return this.usuArea;
	}

	public void setUsuArea(String usuArea) {
		this.usuArea = usuArea;
	}

	public String getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public String getUsu_cod_CV() {
		return this.usu_cod_CV;
	}

	public void setUsu_cod_CV(String usu_cod_CV) {
		this.usu_cod_CV = usu_cod_CV;
	}

	public int getUsuDf() {
		return this.usuDf;
	}

	public void setUsuDf(int usuDf) {
		this.usuDf = usuDf;
	}

	public int getUsuEstado() {
		return this.usuEstado;
	}

	public void setUsuEstado(int usuEstado) {
		this.usuEstado = usuEstado;
	}

	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuMail() {
		return this.usuMail;
	}

	public void setUsuMail(String usuMail) {
		this.usuMail = usuMail;
	}

	public int getUsuTipo() {
		return this.usuTipo;
	}

	public void setUsuTipo(int usuTipo) {
		this.usuTipo = usuTipo;
	}

}