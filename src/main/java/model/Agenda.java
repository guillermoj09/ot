package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@Table(name="agenda")
@NamedQuery(name="Agenda.findAll", query="SELECT a FROM Agenda a")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="actividad_id")
	private String actividadId;

	private int allDay;

	private String area;

	@Column(name="cliente_id")
	private int clienteId;

	private String color;

	private int completado;

	private String contacto;

	private String descripcion;

	private String direccion;

	private String empresa;

	private int estado;

	private Timestamp fecha;

	@Column(name="fecha_comienzo")
	private Timestamp fechaComienzo;

	@Column(name="fecha_final")
	private Timestamp fechaFinal;

	@Column(name="fecha_modifica")
	private Timestamp fechaModifica;

	private String folio;

	@Column(name="folio_anexo")
	private String folioAnexo;

	private String patentes;

	@Column(name="pedido_id")
	private int pedidoId;

	private String telefono;

	private String textcolor;

	@Column(name="tipo_contacto")
	private String tipoContacto;

	@Column(name="tipo_contrato")
	private String tipoContrato;

	private String titulo;

	private String url;

	private String usuario;

	@Column(name="usuario_asigna")
	private String usuarioAsigna;

	@Column(name="usuario_modifica")
	private String usuarioModifica;

	public Agenda() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActividadId() {
		return this.actividadId;
	}

	public void setActividadId(String actividadId) {
		this.actividadId = actividadId;
	}

	public int getAllDay() {
		return this.allDay;
	}

	public void setAllDay(int allDay) {
		this.allDay = allDay;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCompletado() {
		return this.completado;
	}

	public void setCompletado(int completado) {
		this.completado = completado;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaComienzo() {
		return this.fechaComienzo;
	}

	public void setFechaComienzo(Timestamp fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public Timestamp getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Timestamp getFechaModifica() {
		return this.fechaModifica;
	}

	public void setFechaModifica(Timestamp fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFolioAnexo() {
		return this.folioAnexo;
	}

	public void setFolioAnexo(String folioAnexo) {
		this.folioAnexo = folioAnexo;
	}

	public String getPatentes() {
		return this.patentes;
	}

	public void setPatentes(String patentes) {
		this.patentes = patentes;
	}

	public int getPedidoId() {
		return this.pedidoId;
	}

	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTextcolor() {
		return this.textcolor;
	}

	public void setTextcolor(String textcolor) {
		this.textcolor = textcolor;
	}

	public String getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioAsigna() {
		return this.usuarioAsigna;
	}

	public void setUsuarioAsigna(String usuarioAsigna) {
		this.usuarioAsigna = usuarioAsigna;
	}

	public String getUsuarioModifica() {
		return this.usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

}