package com.slokam.appointment.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
public class Patient {


	private Integer id;
	private String name;
	private Date dob;
	private Long phone;
	
	
	
	
}
