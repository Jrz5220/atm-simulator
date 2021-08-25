package com.felix.atmSim.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.felix.atmSim.entity.User;
import com.felix.atmSim.service.UserService;
import com.felix.atmSim.user.CrmUser;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// allows the validation to trim empty strings to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationPage(Model theModel) {
		CrmUser crmUser = getCrmUserWithValidAccountNum();
		theModel.addAttribute("crmUser", crmUser);
		return "register";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, BindingResult theBindingResult, Model theModel) {
		if(theBindingResult.hasErrors())
			return "register";
		try {
			userService.save(theCrmUser);
			logger.info("Successfully created user with account number: " + theCrmUser.getAccountNumber());
		} catch(Exception e) {
			theModel.addAttribute("registerError", "Failed to register account");
			return "login";
		}
		return "registration-confirmation";
	}
	
	// returns a CrmUser with a new account number
	private CrmUser getCrmUserWithValidAccountNum() {
		int max = 9999;
		int min = 1000;
		int range = max - min + 1;
		int accountNumber = (int)(Math.random() * range) + min;
		logger.info(">>> Processing account number for: " + accountNumber);
		String stringAccountNumber = String.valueOf(accountNumber);
		User existing = userService.findByAccountNumber(stringAccountNumber);
		while(existing != null) {
			logger.warning(">>> User account number already exists: " + accountNumber);
			accountNumber = (int)(Math.random() * range) + min;
			existing = userService.findByAccountNumber(stringAccountNumber);
		}
		CrmUser crmUser = new CrmUser();
		crmUser.setAccountNumber(String.valueOf(accountNumber));
		return crmUser;
	}

}
