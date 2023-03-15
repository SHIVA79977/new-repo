package com.slokam.appointment.service;

import com.slokam.appointment.dto.AppointmentDTO;
import com.slokam.appointment.entity.Appointment;
import com.slokam.appointment.exception.AppointmentException;

public interface IAppointmentService {

	public Appointment saveAppointment(AppointmentDTO appointment) throws AppointmentException;
	public Appointment getbyId(Integer id);
}
