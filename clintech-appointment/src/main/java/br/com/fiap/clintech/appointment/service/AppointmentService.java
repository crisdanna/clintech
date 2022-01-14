package br.com.fiap.clintech.appointment.service;

import java.util.List;

import br.com.fiap.clintech.appointment.dao.bean.Appointment;

public interface AppointmentService {
	Appointment saveAppointment(Appointment appointment);
	Appointment getAppointment(Long id);
	void deleteAppointment(Appointment appointment);
	List<Appointment> getAppointmentsByPatient(Long id);
	List<Appointment> getAppointmentsByProffessional(Long id);
}
