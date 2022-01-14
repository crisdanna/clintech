package br.com.fiap.clintech.appointment.dao.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "treatment")
public class Treatment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "treatment_id_seq")
	@SequenceGenerator(name = "treatment_id_seq", allocationSize = 1)
	private Long id;
	
	private int authorizationNumber;
	
	private Long procedureId;
	private Long patientId;
	
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
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** TREATMENT **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Authorization Number: ").append(this.getAuthorizationNumber()).append("\n");
		sb.append("Patient ID: ").append(this.getPatientId()).append("\n");
		sb.append("Procedure ID: ").append(this.getProcedureId()).append("\n");
				
		return sb.toString();
	}
}
