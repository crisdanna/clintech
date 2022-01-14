package br.com.fiap.clintech.professional.dao.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "person_specialties")
public class Specialty implements Serializable {

	@Id
	@Column(name = "specialties_id")
	private Long id;
	
	@Id
	@Column(name = "professional_id")
	private Long professionalId;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public Long getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}
}
