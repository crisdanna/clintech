package br.com.fiap.clintech.appointment.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.clintech.appointment.dao.bean.Treatment;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

	List<Treatment> findByPatientId(Long id);
}
