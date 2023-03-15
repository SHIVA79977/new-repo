package com.slokam.appointment.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.slokam.appointment.dto.AppointmentDTO;
import com.slokam.appointment.dto.Patient;
import com.slokam.appointment.entity.Appointment;
import com.slokam.appointment.exception.AppointmentException;
import com.slokam.appointment.feignclient.PatientFeignClient;
import com.slokam.appointment.repo.AppointmentRepo;
import com.slokam.appointment.service.IAppointmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppointmentServiceImpl implements IAppointmentService {

	private AppointmentRepo appointmentRepo;
	private PatientFeignClient patientFeignClient;

	public AppointmentServiceImpl(AppointmentRepo appointmentRepo, PatientFeignClient patientFeignClient) {
		this.appointmentRepo = appointmentRepo;
		this.patientFeignClient = patientFeignClient;
	}

	@Override
	public Appointment saveAppointment(AppointmentDTO appointmentDto) throws AppointmentException {
		Appointment app = new Appointment();
		if ( appointmentDto.getPatientid() == null) {
			Patient patient = new Patient();
			patient.setDob(appointmentDto.getDob());
			patient.setName(appointmentDto.getPatientName());
			patient.setPhone(appointmentDto.getPhone());
			// save Patient
			Patient patientReturn = patientFeignClient.savePatient(patient);
			app.setPatientid(patientReturn.getId());
		}else {
			app.setPatientid(appointmentDto.getPatientid());
		}
		
		// save Appointment
		app.setAppointmentDate(appointmentDto.getAppointmentDate());
		app.setTaken(new Date());
		appointmentRepo.save(app);
		

		return app;
	}

	@Override
	
	public Appointment getbyId(  Integer id) {
		
		Optional<Appointment> appointment=appointmentRepo.findById(id);
		
	Integer integer=appointment.get().getPatientid();
	Patient patient=patientFeignClient.getbyid(integer);
	log.info("--------------------"+patient);
		
		return appointment.get() ;
	}
	
	
	
}
