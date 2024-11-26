package com.clinic.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

	
}
