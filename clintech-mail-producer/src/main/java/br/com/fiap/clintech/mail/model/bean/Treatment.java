package br.com.fiap.clintech.mail.model.bean;

public class Treatment {
	
	private Long id;
	
	private int authorizationNumber;
	
	private Procedure procedure;
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
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
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
		sb.append(this.getProcedure().toString()).append("\n");
		sb.append(this.patient.toString()).append("\n");
				
		return sb.toString();
	}
}
