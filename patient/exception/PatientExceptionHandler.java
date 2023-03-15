package com.slokam.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.patient.entity.PatientError;

@RestControllerAdvice
public class PatientExceptionHandler {

	@ExceptionHandler(PatientException.class)
	public ResponseEntity<PatientError> handlePatientException(PatientException ex){
		PatientError pr = new PatientError();
		pr.setErrorId("E1234");
		pr.setErrorMessage(ex.getMessage());
		ResponseEntity<PatientError> re = new ResponseEntity<PatientError>(pr,HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<PatientError> handleException(Exception ex){
		PatientError pr = new PatientError();
		pr.setErrorId("E1235");
		pr.setErrorMessage(ex.getMessage());
		ResponseEntity<PatientError> re = new ResponseEntity<PatientError>(pr,HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
}
