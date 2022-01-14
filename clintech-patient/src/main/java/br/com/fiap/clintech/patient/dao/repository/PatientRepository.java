package br.com.fiap.clintech.patient.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.clintech.patient.dao.bean.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
	public List<Patient> findByName(String name);
	public List<Patient> findByLastname(String lastname);
	public List<Patient> findByEmail(String email);
}
