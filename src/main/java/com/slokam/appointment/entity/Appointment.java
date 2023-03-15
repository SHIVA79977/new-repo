package com.slokam.appointment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue
	private Integer id;
	private Date appointmentDate;
	private Date taken;
	private Integer patientid;
	
	
	
	
}
