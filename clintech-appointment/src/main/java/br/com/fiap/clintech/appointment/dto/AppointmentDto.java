package br.com.fiap.clintech.appointment.dto;

public class AppointmentDto {

	private Long id;
	
	private String date;
	private String time;
	private ProfessionalDto professional;
	private TreatmentDto treatment;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public ProfessionalDto getProfessional() {
		return professional;
	}
	public void setProfessional(ProfessionalDto professional) {
		this.professional = professional;
	}
	public TreatmentDto getTreatment() {
		return treatment;
	}
	public void setTreatment(TreatmentDto treatment) {
		this.treatment = treatment;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** APPOINTMENT DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Date: ").append(this.getDate()).append("\n");
		sb.append("Time: ").append(this.getTime()).append("\n");
		sb.append(this.professional.toString()).append("\n");
		sb.append(this.treatment.toString()).append("\n");
				
		return sb.toString();
	}
}
