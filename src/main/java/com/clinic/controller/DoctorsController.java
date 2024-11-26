package com.clinic.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.model.Appointment;
import com.clinic.model.Doctors;
import com.clinic.model.Users;
import com.clinic.service.AppointmentService;
import com.clinic.service.DoctorsService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/doctors")
public class DoctorsController
{
	@Autowired
	DoctorsService doctorsService;
	
	@Autowired
	AppointmentService appointmentService;
	

	@PostMapping("/getall")
	public String getAllDoctors(Model m)
	{
		List<Doctors> doctors = doctorsService.getAllDoctors();
		m.addAttribute("docvar",doctors);
		return "userdashboard";
		
	}
	
	
	
	@PostMapping("/viewall")
	public String getDoctors(Model m)
	{
		List<Doctors> doctors = doctorsService.getAllDoctors();
		m.addAttribute("docvar",doctors);
		return "viewDoctor";
		
	}
	
	@PostMapping("/forupdate")
	public String forupdate(Model m)
	{
		List<Doctors> doctors = doctorsService.getAllDoctors();
		m.addAttribute("docvar",doctors);
		return "editDoc";
		
	}
	
	@PostMapping("/fordelete")
	public String fordelete(Model m)
	{
		List<Doctors> doctors = doctorsService.getAllDoctors();
		m.addAttribute("docvar",doctors);
		return "deletedoc";
		
	}
	
	@PostMapping("/delete")
	public String deletedoc(@RequestParam long id,Model m)
	{
//		try
//		{
//			
			doctorsService.deleteDoctorById(id);
			List<Doctors> doctors = doctorsService.getAllDoctors();
			m.addAttribute("docvar",doctors);
			return "viewDoctor";
		    
//	}
//		catch(Exception e)
//		{
//			
//		}
		//return "deletedoc";
	}
	
	@PostMapping("/editdoc")
	public String editdoc(Model m, @RequestParam long id)
	{
		Doctors doctors = doctorsService.getDoctorById(id);
		m.addAttribute("doctor", doctors);
		return "updateDoctorprofile";
	}
	
	@PostMapping("/docupdate")
	public String docupdate(@ModelAttribute Doctors doctors,HttpSession session, Model m)
	{
//		boolean f = userService.checkEmail(users.getEmail());
//		if(f)
//		{
//			System.out.print("Already Exists");
//		}
//		else
//		{
		try
		{
			doctorsService.updatedoc(doctors.getId(),doctors);
			//doctorsService.updatedoc(doctors.getName(), doctors);
			List<Doctors> doc = doctorsService.getAllDoctors();
			m.addAttribute("docvar",doc);
			return "viewDoctor";
			
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
			List<Doctors> doctor = doctorsService.getAllDoctors();
			m.addAttribute("docvar",doctor);
			return "viewDoctor";
		}
			
			
	}
	

	
	
	
	


}
