package com.slokam.patient.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.PatientException;
import com.slokam.patient.repo.IPatientRepo;
import com.slokam.patient.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepo patientRepo;
	
	@Override
	public Patient savePatient(Patient patient)throws PatientException {
		if(patient!=null) {
		  patientRepo.save(patient);
		}else  {
			throw new PatientException("Patient not saved/updated.");
		}
		return patient;
	}
	
	@Override
	public Patient getPatientById(Integer pid) throws PatientException{

		Optional<Patient> patientOptional = patientRepo.findById(pid);
		
		if(patientOptional.isPresent()) {
			return patientOptional.get();
		}else {
			throw new PatientException("Patient not available.");
		}
	
	}
	
	@Override
	public List<Patient> getAllPatients() throws PatientException{
		List<Patient> patients = patientRepo.findAll();
		if(patients==null || patients.isEmpty()) {
			throw new PatientException("No Patient data available.");
		}
		return patients;
	}
}
