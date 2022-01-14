package br.com.fiap.clintech.professional.service;

import java.util.List;

import br.com.fiap.clintech.professional.dao.bean.Professional;

public interface ProfessionalService {
	void saveProfessional(Professional professional);
	Professional getProfessional(Long id);
	void deleteProfessional(Professional professional);
	List<Professional> getAllProfessionals();
}
