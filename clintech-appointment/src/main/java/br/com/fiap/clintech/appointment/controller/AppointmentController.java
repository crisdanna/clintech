package br.com.fiap.clintech.appointment.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.clintech.appointment.dao.bean.Appointment;
import br.com.fiap.clintech.appointment.dao.bean.Patient;
import br.com.fiap.clintech.appointment.dao.bean.Procedure;
import br.com.fiap.clintech.appointment.dao.bean.Treatment;
import br.com.fiap.clintech.appointment.dto.AppointmentDto;
import br.com.fiap.clintech.appointment.dto.TreatmentDto;
import br.com.fiap.clintech.appointment.service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	private static transient Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	private AppointmentService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public AppointmentDto saveAppointment(@RequestBody AppointmentDto appointment) {
		Appointment savedAppointment = this.service.saveAppointment(convertToEntity(appointment));
		return this.convertToDto(savedAppointment);
	}
	
	@GetMapping("/{id}")
	public AppointmentDto getAppointment(@PathVariable("id") Long id) {
		return convertToDto(this.service.getAppointment(id));
	}
	
	@GetMapping("/list/{id}")
	public List<AppointmentDto> getAppointmentsByPatient(@PathVariable("id") Long id) {
		return convertToDtoList(this.service.getAppointmentsByPatient(id));
	}
	
	@DeleteMapping("/{id}")
	public String deleteAppointment(@PathVariable("id") Long id) {
		try {
			this.service.deleteAppointment(this.service.getAppointment(id));
		}catch(Exception e) {
			logger.error("Unable to delete appointment.", e);
		}
		return "Appointment deleted.";
	}
	
	private AppointmentDto convertToDto(Appointment appointment) {
		AppointmentDto appointmentDto = modelMapper.map(appointment, AppointmentDto.class);
		appointmentDto.setTreatment(this.convertTreatmentToDto(appointment.getTreatment()));
		appointmentDto.setDate(appointment.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		
	    return appointmentDto;
	}
	
	private List<AppointmentDto> convertToDtoList(List<Appointment> appointments) {
		logger.info("Appointments to convert: {}", appointments.size());
		List<AppointmentDto> appointmentsList = new ArrayList<AppointmentDto>();
		appointments.forEach(appointment -> {
			appointmentsList.add(convertToDto(appointment));
		});
		
		return appointmentsList;
	}
	
	private Appointment convertToEntity(AppointmentDto appointmentDto){
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		appointment.setDate(LocalDate.parse(appointmentDto.getDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		appointment.setTime(LocalTime.parse(appointmentDto.getTime(), DateTimeFormatter.ofPattern("HH:mm")));
		
		appointment.setTreatment(this.convertTreatmentToEntity(appointmentDto.getTreatment()));
				
		return appointment;
	}
		
	public TreatmentDto convertTreatmentToDto(Treatment treatment) {
		
		return modelMapper.map(treatment, TreatmentDto.class);
	}
	
	public Treatment convertTreatmentToEntity(TreatmentDto treatmentDto){
		Treatment treatment = modelMapper.map(treatmentDto, Treatment.class);
		treatment.setPatient(modelMapper.map(treatmentDto.getPatient(), Patient.class));
		treatment.setProcedure(modelMapper.map(treatmentDto.getProcedure(), Procedure.class));
		
		return treatment;
	}
}
