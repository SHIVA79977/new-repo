package com.slokam.appointment.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AppointmentDTO {

	private Integer id;
	private Date appointmentDate;
	
	private Integer patientid;
	private String patientName;
	private Date dob;
	private Long phone;
	
	
	
}
