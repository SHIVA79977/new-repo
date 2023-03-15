package com.slokam.appointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.appointment.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
 
	
	
}
