package com.felix.atmSim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.felix.atmSim.service.UserService;

@Controller
public class AtmController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	public String showAccountHomePage() {
		return "account";
	}

}
