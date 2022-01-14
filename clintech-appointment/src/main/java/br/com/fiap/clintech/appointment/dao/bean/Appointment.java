package br.com.fiap.clintech.appointment.dao.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "appointment_id_seq")
	@SequenceGenerator(name = "appointment_id_seq", allocationSize = 1)
	private Long id;
	
	private LocalDate date;
	private LocalTime time;
	
	private Long professionalId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "treatmentId")
	private Treatment treatment;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Long getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}
	public Treatment getTreatment() {
		return treatment;
	}
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** APPOINTMENT **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Date: ").append(this.getDate()).append("\n");
		sb.append("Time: ").append(this.getTime()).append("\n");
		sb.append("Professional ID:").append(this.professionalId).append("\n");
		sb.append(this.getTreatment().toString()).append("\n");
				
		return sb.toString();
	}
}
