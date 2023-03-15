package com.slokam.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AddressType {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	
	
}
