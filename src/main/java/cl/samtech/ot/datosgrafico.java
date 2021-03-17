package cl.samtech.ot;

public class datosgrafico {
	
	
	private String planificadas ;
	private String realizadas ;
	private String fechaGrafico ;
	

	public String getFechaGrafico() {
		return fechaGrafico;
	}

	public void setFechaGrafico(String fechaGrafico) {
		this.fechaGrafico = fechaGrafico;
	}

	public String getRealizadas() {
		return realizadas;
	}

	public String getPlanificadas() {
		return planificadas;
	}

	public void setPlanificadas(String planificadas) {
		this.planificadas = planificadas;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setRealizadas(String realizadas) {
		this.realizadas = realizadas;
	}

	private String total ;

}
