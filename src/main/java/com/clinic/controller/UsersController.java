package com.clinic.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.model.Doctors;
import com.clinic.model.Users;
import com.clinic.service.*;

import jakarta.servlet.http.HttpSession;



@Controller
//@RequestMapping("/users")
public class UsersController
{
	@Autowired
	UsersService usersService;
	
	@PostMapping("/updateuserdata")
	public String updateuserdata(HttpSession session, Model model,@ModelAttribute Users users)
	{
		try
		{
			usersService.updateuser(users.getName(),users);
//			List<Doctors> doc = doctorsService.getAllDoctors();
//			m.addAttribute("docvar",doc);
			return "uuser";
			
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
//			List<Doctors> doctor = doctorsService.getAllDoctors();
//			m.addAttribute("docvar",doctor);
			return "edituserProfile";
		}
			
	}
	
	
	
	
	
	

}



