package com.slokam.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name="atid")
	private AddressType type;
	private String houseNumber;
	private String city;
	@ManyToOne
	@JoinColumn(name="pid")
	private Patient patient;
	
	
}
