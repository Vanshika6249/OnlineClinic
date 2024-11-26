package com.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.model.Appointment;
import com.clinic.model.Doctors;
import com.clinic.model.Users;
import com.clinic.repository.AppointmentRepo;


@Service
public class AppointmentService {
	
	@Autowired 
	AppointmentRepo appointmentRepo;
	
	public Appointment addAppointment(Appointment appointment) {
		
		return appointmentRepo.save(appointment);
	}
	
	public List<Appointment> getApps() {
		return appointmentRepo.findAll();
	}

//	public Appointment findAppointmentById(long loginid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public Appointment findAppointmentById(long loginid)
	{
		return appointmentRepo.findById(loginid).get();
	}
	
	

}
