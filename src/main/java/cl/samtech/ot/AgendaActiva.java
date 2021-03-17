package cl.samtech.ot;

import java.sql.Timestamp;

public class AgendaActiva {
	
	private long id;
	
	private String responsable;
	
	private String actividadId;
	
	private int instalaciones;

	private int allDay;

	private String area;
	
	private String login_cliente;
	
	private int clienteId;

	private String color;

	private int completado;

	private String contacto;

	private String descripcion;

	private String direccion;

	private String empresa;

	private int estado;

	private Timestamp fecha;

	
	private Timestamp fechaComienzo;

	
	private Timestamp fechaFinal;

	
	private Timestamp fechaModifica;

	private String folio;

	
	private String folioAnexo;

	private String patentes;

	
	private int pedidoId;

	private String telefono;

	private String textcolor;

	
	private String tipoContacto;

	
	private String tipoContrato;

	private String titulo;

	private String url;

	private String usuario;
	
	private long countInst;
	
	private String usuarioAsigna;

	
	private String usuarioModifica;

	public AgendaActiva() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getCountInst() {
		return countInst;
	}
	
	public int getInstalaciones() {
		return instalaciones;
	}

	public void setInstalaciones(int instalaciones) {
		this.instalaciones = instalaciones;
	}

	public void setCountInst(long countInst) {
		this.countInst = countInst;
	}

	public String getLogin_cliente() {
		return login_cliente;
	}

	public void setLogin_cliente(String login_cliente) {
		this.login_cliente = login_cliente;
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
	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
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