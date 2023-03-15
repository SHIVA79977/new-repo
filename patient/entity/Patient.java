package com.slokam.patient.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Date dob;
	private Long phone;
	
	
	
	
}
