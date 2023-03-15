package com.slokam.patient.service;

import java.util.List;

import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.PatientException;

public interface IPatientService {

	public abstract Patient savePatient(Patient patient) throws PatientException;
	public abstract Patient getPatientById(Integer pid) throws PatientException;
	public abstract List<Patient> getAllPatients()throws PatientException;
	
}
