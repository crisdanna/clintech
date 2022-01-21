package br.com.fiap.clintech.appointment.service;

import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.clintech.appointment.dao.bean.Appointment;
import br.com.fiap.clintech.appointment.dao.bean.Treatment;
import br.com.fiap.clintech.appointment.dao.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	private static transient Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	@Autowired
	private AppointmentRepository repository;
	
	@Autowired
	private TreatmentService treatmentService;
	
	@Override
	@Transactional
	public Appointment saveAppointment(Appointment appointment) {
		
		Treatment treatment = null;
		try{
			List<Treatment> treatments = this.treatmentService.getTreatmentsByPatient(appointment.getTreatment().getPatient().getId());
			
			Stream<Treatment> existingTreatment = treatments.stream()
				.filter(t -> t.getProcedure().getId() == appointment.getTreatment().getProcedure().getId());
			treatment = existingTreatment.findFirst().get();
		}catch (Exception e) {
			logger.warn("No treatment found for patient and procedure.", e);
		}
		
		if(treatment == null) {
			treatment = this.treatmentService.saveTreatment(appointment.getTreatment());
		}
		
		appointment.setTreatment(treatment);
				
		return this.repository.save(appointment);
	}

	@Override
	public Appointment getAppointment(Long id) {
		return this.repository.findById(id).get();
	}
	
	@Override
	public void deleteAppointment(Appointment appointment) {
		this.repository.delete(appointment);
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(Long id) {
		return this.repository.findByPatientId(id);
	}

	@Override
	public List<Appointment> getAppointmentsByProffessional(Long id) {
		return this.repository.findByProfessionalId(id);
	}

}
