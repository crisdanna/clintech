package br.com.fiap.clintech.appointment.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.clintech.appointment.dao.bean.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	
	@Query("select a from Appointment a where a.professionalId = ?1")
	List<Appointment> findByProfessionalId(Long id);
	
	@Query("select a from Appointment a, Treatment t where a.treatment.id = t.id and t.patient.id = ?1")
	List<Appointment> findByPatientId(Long id);
}
