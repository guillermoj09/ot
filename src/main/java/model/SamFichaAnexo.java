package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sam_ficha_anexo database table.
 * 
 */
@Entity
@Table(name="sam_ficha_anexo")
@NamedQuery(name="SamFichaAnexo.findAll", query="SELECT s FROM SamFichaAnexo s")
public class SamFichaAnexo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="fa_cod_anexo")
	private int faCodAnexo;
	
	@Column(name="fa_actualiza")
	private Timestamp faActualiza;

	@Column(name="fa_bloqueado")
	private int faBloqueado;

	

	@Column(name="fa_cod_cliente")
	private int faCodCliente;

	@Column(name="fa_cod_ficha")
	private int faCodFicha;

	@Column(name="fa_contacto")
	private String faContacto;

	@Column(name="fa_direccion")
	private String faDireccion;

	@Column(name="fa_fecha_cambio")
	private Timestamp faFechaCambio;

	@Column(name="fa_fecha_ingreso")
	private Timestamp faFechaIngreso;

	@Column(name="fa_id_estado")
	private int faIdEstado;

	private int fa_inst_CV;

	@Column(name="fa_inst_trans")
	private int faInstTrans;

	@Column(name="fa_num_oc")
	private String faNumOc;

	@Column(name="fa_obs")
	private String faObs;

	@Column(name="fa_pagador")
	private String faPagador;

	@Column(name="fa_ruta_oc")
	private String faRutaOc;

	@Column(name="fa_usu_modifica")
	private int faUsuModifica;

	@Column(name="fa_valorfuerazona")
	private String faValorfuerazona;

	public SamFichaAnexo() {
	}

	public Timestamp getFaActualiza() {
		return this.faActualiza;
	}

	public void setFaActualiza(Timestamp faActualiza) {
		this.faActualiza = faActualiza;
	}

	public int getFaBloqueado() {
		return this.faBloqueado;
	}

	public void setFaBloqueado(int faBloqueado) {
		this.faBloqueado = faBloqueado;
	}

	public int getFaCodAnexo() {
		return this.faCodAnexo;
	}

	public void setFaCodAnexo(int faCodAnexo) {
		this.faCodAnexo = faCodAnexo;
	}

	public int getFaCodCliente() {
		return this.faCodCliente;
	}

	public void setFaCodCliente(int faCodCliente) {
		this.faCodCliente = faCodCliente;
	}

	public int getFaCodFicha() {
		return this.faCodFicha;
	}

	public void setFaCodFicha(int faCodFicha) {
		this.faCodFicha = faCodFicha;
	}

	public String getFaContacto() {
		return this.faContacto;
	}

	public void setFaContacto(String faContacto) {
		this.faContacto = faContacto;
	}

	public String getFaDireccion() {
		return this.faDireccion;
	}

	public void setFaDireccion(String faDireccion) {
		this.faDireccion = faDireccion;
	}

	public Timestamp getFaFechaCambio() {
		return this.faFechaCambio;
	}

	public void setFaFechaCambio(Timestamp faFechaCambio) {
		this.faFechaCambio = faFechaCambio;
	}

	public Timestamp getFaFechaIngreso() {
		return this.faFechaIngreso;
	}

	public void setFaFechaIngreso(Timestamp faFechaIngreso) {
		this.faFechaIngreso = faFechaIngreso;
	}

	public int getFaIdEstado() {
		return this.faIdEstado;
	}

	public void setFaIdEstado(int faIdEstado) {
		this.faIdEstado = faIdEstado;
	}

	public int getFa_inst_CV() {
		return this.fa_inst_CV;
	}

	public void setFa_inst_CV(int fa_inst_CV) {
		this.fa_inst_CV = fa_inst_CV;
	}

	public int getFaInstTrans() {
		return this.faInstTrans;
	}

	public void setFaInstTrans(int faInstTrans) {
		this.faInstTrans = faInstTrans;
	}

	public String getFaNumOc() {
		return this.faNumOc;
	}

	public void setFaNumOc(String faNumOc) {
		this.faNumOc = faNumOc;
	}

	public String getFaObs() {
		return this.faObs;
	}

	public void setFaObs(String faObs) {
		this.faObs = faObs;
	}

	public String getFaPagador() {
		return this.faPagador;
	}

	public void setFaPagador(String faPagador) {
		this.faPagador = faPagador;
	}

	public String getFaRutaOc() {
		return this.faRutaOc;
	}

	public void setFaRutaOc(String faRutaOc) {
		this.faRutaOc = faRutaOc;
	}

	public int getFaUsuModifica() {
		return this.faUsuModifica;
	}

	public void setFaUsuModifica(int faUsuModifica) {
		this.faUsuModifica = faUsuModifica;
	}

	public String getFaValorfuerazona() {
		return this.faValorfuerazona;
	}

	public void setFaValorfuerazona(String faValorfuerazona) {
		this.faValorfuerazona = faValorfuerazona;
	}

}