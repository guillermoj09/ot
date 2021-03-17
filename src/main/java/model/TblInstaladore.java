package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_instaladores database table.
 * 
 */
@Entity
@Table(name="tbl_instaladores")
@NamedQuery(name="TblInstaladore.findAll", query="SELECT t FROM TblInstaladore t")
public class TblInstaladore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_instalador")
	private String idInstalador;

	private String apellidos;

	@Column(name="es_bodeguero")
	private String esBodeguero;

	@Column(name="es_cv")
	private String esCv;

	@Column(name="es_instalador")
	private String esInstalador;

	private String mail;

	private String nombre;

	private String password;

	private String perfil;

	@Column(name="perfil_bodega")
	private String perfilBodega;

	private String sucursal;

	private String tipo;

	@Column(name="tipo_admin")
	private int tipoAdmin;

	private boolean vigencia;

	public TblInstaladore() {
	}

	public String getIdInstalador() {
		return this.idInstalador;
	}

	public void setIdInstalador(String idInstalador) {
		this.idInstalador = idInstalador;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEsBodeguero() {
		return this.esBodeguero;
	}

	public void setEsBodeguero(String esBodeguero) {
		this.esBodeguero = esBodeguero;
	}

	public String getEsCv() {
		return this.esCv;
	}

	public void setEsCv(String esCv) {
		this.esCv = esCv;
	}

	public String getEsInstalador() {
		return this.esInstalador;
	}

	public void setEsInstalador(String esInstalador) {
		this.esInstalador = esInstalador;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfilBodega() {
		return this.perfilBodega;
	}

	public void setPerfilBodega(String perfilBodega) {
		this.perfilBodega = perfilBodega;
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

	public int getTipoAdmin() {
		return this.tipoAdmin;
	}

	public void setTipoAdmin(int tipoAdmin) {
		this.tipoAdmin = tipoAdmin;
	}

	public boolean getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

}