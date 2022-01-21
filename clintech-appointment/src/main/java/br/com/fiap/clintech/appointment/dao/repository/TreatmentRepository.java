package br.com.fiap.clintech.appointment.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.clintech.appointment.dao.bean.Treatment;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

	@Query("select t from Treatment t where t.patient.id = ?1")
	List<Treatment> findByPatient(Long id);
}
