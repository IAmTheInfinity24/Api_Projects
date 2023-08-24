package com.psa.flights_reservation_app_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flights_reservation_app_5.entities.User;
import com.psa.flights_reservation_app_5.repository.UserRepoInf;

@Controller
public class UserController {
	
	@Autowired
	private UserRepoInf uri;
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user){
		uri.save(user);
		return "/login/login";
	}
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "/login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(ModelMap modelmap,@RequestParam("email") String email,@RequestParam("password") String password) {
		User user=uri.findByEmail(email);
		if(user.getPassword().equals(password)&&user.getEmail().equals(email))
			return "findFlights";
		else
			modelmap.addAttribute("error", "invalid credentials");
		return "/login/login";
	}
}
