package com.clinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.UserNotFoundException;
import com.clinic.model.Doctors;
import com.clinic.repository.DoctorsRepo;


@Service
public class DoctorsService 
{
	@Autowired
	private DoctorsRepo doctorsRepo;
	
	public List<Doctors> getAllDoctors() {
		return doctorsRepo.findAll();
	}

	public Doctors addUpdateDoctor(Doctors doctors) {
		return doctorsRepo.save(doctors);
	}

	public void deleteDoctorById(long id) {
		doctorsRepo.delete(getDoctorById(id));
	}
	
	public Doctors getDoctorById(long id)
	{
		Optional<Doctors> opt = doctorsRepo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new UserNotFoundException("Id: "+id+"Not Found");
		}
	}
	
//	public void updatedoc(String name, Doctors doctor)
//	{
//		Doctors doctors = doctorsRepo.findByName(name);
//		doctors.setName(doctor.getName());
//		doctors.setSpecialization(doctor.getSpecialization());
//		doctors.setExperience(doctor.getExperience());
//		
//		doctorsRepo.save(doctors);
//	}
	
	public void updatedoc(long id, Doctors doctor)
	{
		Doctors doctors = doctorsRepo.findById(id).get();
		doctors.setName(doctor.getName());
		doctors.setSpecialization(doctor.getSpecialization());
		doctors.setExperience(doctor.getExperience());
		
		doctorsRepo.save(doctors);
	}
	
	
	
	
}
