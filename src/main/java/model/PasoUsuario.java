package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paso_usuario database table.
 * 
 */
@Entity
@Table(name="paso_usuario")
@NamedQuery(name="PasoUsuario.findAll", query="SELECT p FROM PasoUsuario p")
public class PasoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_paso")
	private long idPaso;

	private int admin;

	@Column(name="cli_admin")
	private int cliAdmin;

	private String empresa;

	private int invitado;

	private String paten;

	private String patente;

	private int usuario;

	@Column(name="usuario_login")
	private String usuarioLogin;

	private int ver;

	public PasoUsuario() {
	}

	public long getIdPaso() {
		return this.idPaso;
	}

	public void setIdPaso(long idPaso) {
		this.idPaso = idPaso;
	}

	public int getAdmin() {
		return this.admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getCliAdmin() {
		return this.cliAdmin;
	}

	public void setCliAdmin(int cliAdmin) {
		this.cliAdmin = cliAdmin;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getInvitado() {
		return this.invitado;
	}

	public void setInvitado(int invitado) {
		this.invitado = invitado;
	}

	public String getPaten() {
		return this.paten;
	}

	public void setPaten(String paten) {
		this.paten = paten;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getUsuario() {
		return this.usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioLogin() {
		return this.usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public int getVer() {
		return this.ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

}