package br.com.fiap.clintech.appointment.dto;

public class PatientDto{
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PATIENT DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
				
		return sb.toString();
	}
}
