package cl.samtech.ot;

public class eventosweb {
	
	
	Integer planificadas;
	Integer realizadas;
		public Integer getPlanificadas() {
			return planificadas;
		}
		public void setPlanificadas(Integer planificadas) {
			this.planificadas = planificadas;
		}
		public Integer getRealizadas() {
			return realizadas;
		}
		public void setRealizadas(Integer realizadas) {
			this.realizadas = realizadas;
		}

		
		public void clearall() {
			this.planificadas=0;
			this.realizadas=0;
			
		}
		
		
}
