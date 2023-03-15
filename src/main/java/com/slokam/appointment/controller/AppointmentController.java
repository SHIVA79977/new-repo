package com.slokam.appointment.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.appointment.dto.AppointmentDTO;
import com.slokam.appointment.entity.Appointment;
import com.slokam.appointment.exception.AppointmentException;
import com.slokam.appointment.service.IAppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService  appointmentService;
	
	@PostMapping
	public ResponseEntity<Appointment> saveAppointment(@RequestBody AppointmentDTO appointmentDto) throws AppointmentException, URISyntaxException {
	
		Appointment appointment = appointmentService.saveAppointment(appointmentDto);
		URI url = new URI("appointment/"+appointment.getId()); 
		return ResponseEntity.created(url).body(appointment);
	}
	@GetMapping("/get/{id}")
	public Appointment getbyId(@PathVariable Integer id) {
		Appointment appointment	=appointmentService.getbyId(id);
		return appointment;
		
	}
	
}
