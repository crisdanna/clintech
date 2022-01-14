package br.com.fiap.clintech.professional.dto;

import java.util.List;

public class ProfessionalDto extends PersonDto{
	private List<SpecialtyDto> specialties;

	public List<SpecialtyDto> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<SpecialtyDto> specialties) {
		this.specialties = specialties;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PROFESSIONAL DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Last Name: ").append(this.getLastname()).append("\n");
		sb.append("Phone: ").append(this.getPhone()).append("\n");
		
		return sb.toString();
	}
}
