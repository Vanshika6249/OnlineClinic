package com.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinic.model.Appointment;
import com.clinic.model.Doctors;
import com.clinic.model.Users;
import com.clinic.repository.AppointmentRepo;
import com.clinic.repository.UsersRepo;
import com.clinic.service.AppointmentService;
import com.clinic.service.DoctorsService;
import com.clinic.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	long loginid = 199;
	@Autowired
	private UsersService userService;

	@Autowired
	private UsersRepo userRepo;

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorsService doctorService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute Users users, HttpSession session) {
//		boolean f = userService.checkEmail(users.getEmail());
//		if(f)
//		{
//			//session.setAttribute("msg", "Already Exists");
//			System.out.print("Already Exists");
//		}
//		else
//		{
		users.setRole("user");
		Users user = userService.addUpdateUser(users);
		if (user != null) {
			// session.setAttribute("msg", "Register Successfully");
			System.out.print("Register Successfully");
		} else {
			//session.setAttribute("msg", "Something went wrong");
			System.out.print("Something went wrong");
		}

		// }

		return "login";
	}

	@PostMapping("/adoctor")
	public String adddoctor(@ModelAttribute Doctors doctors, HttpSession session) {
//		boolean f = userService.checkEmail(users.getEmail());
//		if(f)
//		{
//			System.out.print("Already Exists");
//		}
//		else
//		{

		Doctors doctor = doctorService.addUpdateDoctor(doctors);
		if (doctor != null) {
			System.out.print("Register Successfully");
		} else {
			System.out.print("Something went wrong");
		}
		// }

		return "admindashboard";
	}

	@PostMapping("/doLogin")
	public String login(@ModelAttribute Users users, Model m) {

		try {
			Users user = userRepo.findByEmailAndPassword(users.getEmail(), users.getPassword());
			System.out.print(user);
			System.out.print(users.getEmail());
			loginid = user.getId();
			System.out.println(user.getId());

			if (user != null) {
				if (user.getRole().equals("admin")) {
					return "admindashboard";
				} else {
					return "uuser";
				}
			} else {
				return "login";
			}

		} catch (Exception e) {

		}
		return "index";

	}

	@PostMapping("/edituserr")
	public String edituseerr(@ModelAttribute Users users, Model m, HttpSession session) {
		Users user = userService.findUserById(loginid);
		System.out.print(user);
		m.addAttribute("uservar", user);
		return "edituserProfile";
	}

	@PostMapping("/book")
	public String book(@ModelAttribute Appointment appo, HttpSession session) {
//		boolean f = userService.checkEmail(users.getEmail());
//		if(f)
//		{
//			System.out.print("Already Exists");
//		}
//		else
//		{
		// users.setRole("user");
		Appointment app = appointmentService.addAppointment(appo);
		if (app != null) {
			// String date = app.getDate().toString();
			System.out.println("Appointment Booked");
			//session.setAttribute("message", "Appointment Is Booked");
			return "uuser";
		} else {
			System.out.print("Something went wrong");
		//	session.setAttribute("message", "Something went wrong");
			return "bookappointment";
		}
		// }

		// return "login";
	}

	@PostMapping("/bookapp")
	public String bookapp(Model m) {
		
		Users user = userService.findUserById(loginid);
		System.out.print(user);
		m.addAttribute("uservar", user);
		//return "edituserProfile";
		return "bookappointment";
	}

	@PostMapping("/adddoc")
	public String adddoc() {
		return "addDoctor";
	}

	@PostMapping("/reta")
	public String reta() {
		return "admindashboard";
	}

	@PostMapping("/retb")
	public String retb() {
		return "userdashbaord";
	}

	@PostMapping("/logout")
	public String logout() {
		return "login";
	}

	@PostMapping("/foredit")
	public String foredit() {
		return "editDoc";
	}

//	@PostMapping("/edituserr")
//	public String edituserr()
//	{
//		return "edituserProfile";
//	}
	
	@PostMapping("/getapp")
	public String getAppointments(Model m)
	{
		Appointment appointment = appointmentService.findAppointmentById(loginid);
		System.out.print(appointment);
		m.addAttribute("uservar", appointment);
		//return "edituserProfile";
		return "appointments";
		
	}
	
	@PostMapping("/allapplist")
	public String allapplist(Model m)
	{
		List<Appointment> appointment = appointmentService.getApps();
		m.addAttribute("appvar",appointment);
		return "viewAllApp";
		
	}

}
