package com.slokam.appointment.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.slokam.appointment.dto.Patient;

@FeignClient(name="PATIENT")
public interface PatientFeignClient {

	@PostMapping("save")
	public Patient savePatient(Patient patient);
	@GetMapping("get/{id}")
	public Patient getbyid(@PathVariable Integer id);
}
