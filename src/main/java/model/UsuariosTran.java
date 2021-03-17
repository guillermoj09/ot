package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_trans database table.
 * 
 */
@Entity
@Table(name="usuarios_trans")
@NamedQuery(name="UsuariosTran.findAll", query="SELECT u FROM UsuariosTran u")
public class UsuariosTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosTranPK id;

	@Column(name="acceso_cobranza")
	private boolean accesoCobranza;

	@Column(name="acceso_prospectos")
	private int accesoProspectos;

	private int alarma;

	private String apellidos;

	@Column(name="es_agenda")
	private int esAgenda;

	private boolean es_Cobrador;

	private String mail;

	private int nivel;

	private String nombres;

	private String password;

	@Column(name="perfil_agenda")
	private int perfilAgenda;

	@Column(name="perfil_cobranza")
	private String perfilCobranza;

	private String sucursal;

	private String tipo;

	@Column(name="trans_herramientas_usu")
	private int transHerramientasUsu;

	public UsuariosTran() {
	}

	public UsuariosTranPK getId() {
		return this.id;
	}

	public void setId(UsuariosTranPK id) {
		this.id = id;
	}

	public boolean getAccesoCobranza() {
		return this.accesoCobranza;
	}

	public void setAccesoCobranza(boolean accesoCobranza) {
		this.accesoCobranza = accesoCobranza;
	}

	public int getAccesoProspectos() {
		return this.accesoProspectos;
	}

	public void setAccesoProspectos(int accesoProspectos) {
		this.accesoProspectos = accesoProspectos;
	}

	public int getAlarma() {
		return this.alarma;
	}

	public void setAlarma(int alarma) {
		this.alarma = alarma;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEsAgenda() {
		return this.esAgenda;
	}

	public void setEsAgenda(int esAgenda) {
		this.esAgenda = esAgenda;
	}

	public boolean getEs_Cobrador() {
		return this.es_Cobrador;
	}

	public void setEs_Cobrador(boolean es_Cobrador) {
		this.es_Cobrador = es_Cobrador;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPerfilAgenda() {
		return this.perfilAgenda;
	}

	public void setPerfilAgenda(int perfilAgenda) {
		this.perfilAgenda = perfilAgenda;
	}

	public String getPerfilCobranza() {
		return this.perfilCobranza;
	}

	public void setPerfilCobranza(String perfilCobranza) {
		this.perfilCobranza = perfilCobranza;
	}

	public String getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTransHerramientasUsu() {
		return this.transHerramientasUsu;
	}

	public void setTransHerramientasUsu(int transHerramientasUsu) {
		this.transHerramientasUsu = transHerramientasUsu;
	}

}