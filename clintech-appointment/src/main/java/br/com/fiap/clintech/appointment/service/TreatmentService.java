package br.com.fiap.clintech.appointment.service;

import java.util.List;

import br.com.fiap.clintech.appointment.dao.bean.Treatment;

public interface TreatmentService {
	void saveTreatment(Treatment treatment);
	Treatment getTreatment(Long id);
	void deleteTreatment(Treatment treatment);
	List<Treatment> getTreatmentsByPatient(Long id);
}
