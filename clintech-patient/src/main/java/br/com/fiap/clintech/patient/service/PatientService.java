package br.com.fiap.clintech.patient.service;

import java.util.List;

import br.com.fiap.clintech.patient.dao.bean.Patient;

public interface PatientService {
	void savePatient(Patient patient);
	Patient getPatient(Long id);
	void deletePatient(Patient patient);
	List<Patient> getAllPatients();
}
