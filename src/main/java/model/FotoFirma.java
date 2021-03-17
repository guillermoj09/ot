package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the foto_firma database table.
 * 
 */
@Entity
@Table(name="foto_firma")
@NamedQuery(name="FotoFirma.findAll", query="SELECT f FROM FotoFirma f")
public class FotoFirma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nombre;

	private String url;

	//bi-directional many-to-one association to Comprobante
	@OneToMany(mappedBy="fotoFirma")
	private List<Comprobante> comprobantes;

	public FotoFirma() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comprobante> getComprobantes() {
		return this.comprobantes;
	}

	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}

	public Comprobante addComprobante(Comprobante comprobante) {
		getComprobantes().add(comprobante);
		comprobante.setFotoFirma(this);

		return comprobante;
	}

	public Comprobante removeComprobante(Comprobante comprobante) {
		getComprobantes().remove(comprobante);
		comprobante.setFotoFirma(null);

		return comprobante;
	}

}