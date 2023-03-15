package com.slokam.appointment.exception;

public class AppointmentException extends Exception {

	public AppointmentException() {
		
	}
	public AppointmentException(String message) {
		super(message);
	}
	public AppointmentException(String message,Throwable th) {
		super(message,th);
	}
}
