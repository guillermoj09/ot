package cl.samtech.ot.form;


public class FinalizarForm
{

    private String observaciones;
    private String img_val;
    private Long id_ot;
    private String fechaInicio;
    private String fechaFinal;
    private String folio;
    private String anexo;
    private String nombrecliente;
    private String rutcliente;
    private String cargo;
    private String email;
    private String horainicio;
    private String perifericos;
    private boolean validaracc;

    public FinalizarForm()
    {
    }
    
    public String getPerifericos() {
		return perifericos;
	}

	public void setPerifericos(String perifericos) {
		this.perifericos = perifericos;
	}

	public String getEmail()
    {
        return email;
    }
	
	public boolean isValidaracc() {
		return validaracc;
	}

	public void setValidaracc(boolean validaracc) {
		this.validaracc = validaracc;
	}

	public String getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}
	public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNombrecliente()
    {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente)
    {
        this.nombrecliente = nombrecliente;
    }

    public String getRutcliente()
    {
        return rutcliente;
    }

    public void setRutcliente(String rutcliente)
    {
        this.rutcliente = rutcliente;
    }

    public String getCargo()
    {
        return cargo;
    }

    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }

    public String getFolio()
    {
        return folio;
    }

    public void setFolio(String folio)
    {
        this.folio = folio;
    }

    public String getAnexo()
    {
        return anexo;
    }

    public void setAnexo(String anexo)
    {
        this.anexo = anexo;
    }

    public Long getId_ot()
    {
        return id_ot;
    }

    public void setId_ot(Long id_ot)
    {
        this.id_ot = id_ot;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public String getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public String getImg_val()
    {
        return img_val;
    }

    public void setImg_val(String img_val)
    {
        this.img_val = img_val;
    }
}
