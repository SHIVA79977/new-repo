package com.slokam.patient.exception;

import net.bytebuddy.implementation.bytecode.Throw;

public class PatientException extends Exception{

	public PatientException() {
		
	}
	public PatientException(String message) {
		super(message);
	}
	
	public PatientException(String message, Throwable th) {
		super(message,th);
	}
}
