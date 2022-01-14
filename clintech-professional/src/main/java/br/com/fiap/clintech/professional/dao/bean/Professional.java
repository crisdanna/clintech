package br.com.fiap.clintech.professional.dao.bean;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("2")
public class Professional extends Person {

	@OneToMany(mappedBy = "professionalId")
	private List<Specialty> specialties;

	public List<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PROFESSIONAL **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Last Name: ").append(this.getLastname()).append("\n");
		sb.append("Phone: ").append(this.getPhone()).append("\n");
				
		return sb.toString();
	}
}
