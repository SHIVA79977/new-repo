package com.slokam.appointment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.appointment.dto.AppointmentError;



@RestControllerAdvice
public class AppointmentExceptionHandler {

	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<AppointmentError> handlePatientException(AppointmentException ex){
		AppointmentError pr = new AppointmentError();
		pr.setErrorId("E1234");
		pr.setErrorMessage(ex.getMessage());
		ResponseEntity<AppointmentError> re = new ResponseEntity<AppointmentError>(pr,HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppointmentError> handleException(Exception ex){
		AppointmentError pr = new AppointmentError();
		pr.setErrorId("E1235");
		pr.setErrorMessage(ex.getMessage());
		ResponseEntity<AppointmentError> re = new ResponseEntity<AppointmentError>(pr,HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
}
