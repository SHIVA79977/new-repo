package com.slokam.patient.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.PatientException;
import com.slokam.patient.service.IPatientService;

@RestController
@RequestMapping("hello")
public class PatientController {

	@Autowired
	private IPatientService patientService;
	@PostMapping("save")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) throws PatientException, URISyntaxException {
		patientService.savePatient(patient);
		URI uri = new URI("/patient/"+patient.getId());
		return ResponseEntity.created(uri).body(patient);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Patient> getByPatientId(@PathVariable Integer id) throws PatientException{
		Patient patient = patientService.getPatientById(id);
		return ResponseEntity.ok(patient);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Patient>> getAllPatients() throws PatientException{
		List<Patient> patients = patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
}
