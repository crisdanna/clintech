package br.com.fiap.clintech.mail.model.bean;

public class Treatment {
	
	private Long id;
	
	private int authorizationNumber;
	
	private Long procedureId;
	private Patient patient;
	
	public int getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(int authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public Long getProcedureId() {
		return procedureId;
	}
	public void setProcedureId(Long procedureId) {
		this.procedureId = procedureId;
	}

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** TREATMENT **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Authorization Number: ").append(this.getAuthorizationNumber()).append("\n");
		sb.append("Procedure ID: ").append(this.getProcedureId()).append("\n");
		sb.append(this.patient.toString()).append("\n");
				
		return sb.toString();
	}
}
