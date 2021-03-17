package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the logs database table.
 * 
 */
@Entity
@Table(name="logs")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="\"buscarChar\"")
	private String buscarChar;

	private String operador;

	private String ubicacion;

	private String valor;

	//bi-directional many-to-one association to TipoValidacion
	@ManyToOne
	@JoinColumn(name="id_tipo_validacion")
	private TipoValidacion tipoValidacion;

	public Log() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuscarChar() {
		return this.buscarChar;
	}

	public void setBuscarChar(String buscarChar) {
		this.buscarChar = buscarChar;
	}

	public String getOperador() {
		return this.operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public TipoValidacion getTipoValidacion() {
		return this.tipoValidacion;
	}

	public void setTipoValidacion(TipoValidacion tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

}