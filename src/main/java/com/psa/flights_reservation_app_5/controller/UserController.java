package com.psa.flights_reservation_app_5.controller;

import com.psa.flights_reservation_app_5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.psa.flights_reservation_app_5.entities.User;
import com.psa.flights_reservation_app_5.repository.UserRepoInf;

@Controller
public class UserController {

	private static User user;
	@Autowired
	private UserRepoInf uri;

	@Autowired
	private UserService userService;
	
	@RequestMapping("/showReg")
	public String showReg(Model model) {
		model.addAttribute("user", new User());
		return "login/showReg";
	}

	@GetMapping("/dashboard")
	public String home(ModelMap map) {
		map.addAttribute("message" ,"Welcome"+ user.getFirstName()+" "+user.getLastName());
		// Redirect to the dashboard
		return "dashboard";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user, Model model){

		// Check if the user already exists by username or email (adjust the condition based on your needs)
		if (userService.isEmailExists(user.getEmail())) {
			model.addAttribute("message", "User with the provided username or email already exists!");
			return "/login/login"; // Redirect to the registration page with an error message
		}

		uri.save(user);
		model.addAttribute("message", "User created successfully!");

		return "/login/login";
	}
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "/login/login";
	}

	@RequestMapping("/index")
	public String logout() {
		return "redirect:/";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(ModelMap modelmap,@RequestParam("email") String email,@RequestParam("password") String password) {
		 user=uri.findByEmail(email);

		 if(user!=null&&password.equals(user.getPassword())&&email.equals(user.getEmail())) {
			modelmap.addAttribute("message", "Welcome "+ user.getFirstName()+user.getLastName()+"!");

			return "/dashboard";
		}
		else {
			modelmap.addAttribute("message", "invalid credentials");

			return "/login/login";
		}
	}
}
