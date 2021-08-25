package com.felix.atmSim.controller;

import java.text.DecimalFormat;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.felix.atmSim.entity.User;
import com.felix.atmSim.service.UserService;
import com.felix.atmSim.user.CrmUser;
import com.felix.atmSim.user.CrmWithdrawDepositAmount;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	@Autowired
	public UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// allows the validation to trim empty strings to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/homepage")
	public String showAccountHomepage() {
		return "account";
	}
	
	@GetMapping("/showWithdrawCheckingPage")
	public String checkingAccountWithdrawPage(@SessionAttribute("user") User theUser, Model theModel) {
		String formatBalance = df.format(theUser.getCheckingBalance());
		CrmWithdrawDepositAmount theAmount = new CrmWithdrawDepositAmount();
		theModel.addAttribute("theAmount", theAmount);
		theModel.addAttribute("balance", formatBalance);
		return "checking-account-withdraw";
	}
	
	@PostMapping("/withdrawChecking")
	public String withdrawFromCheckingAccount(
			@Valid @ModelAttribute("theAmount") CrmWithdrawDepositAmount theAmount,
			BindingResult theBindingResult,
			@SessionAttribute("user") User theUser,
			Model theModel) {
		String formatedBalance = df.format(theUser.getCheckingBalance());
		theModel.addAttribute("balance", formatedBalance);
		
		// validate dollar and cent amount
		if (theBindingResult.hasErrors())
			return "checking-account-withdraw";
		
		if(theAmount.getCents().length() == 1)
			theAmount.setCents("0" + theAmount.getCents());
		
		double withdraw = Double.parseDouble(theAmount.getDollars() + "." + theAmount.getCents());
		double newBalance = theUser.getCheckingBalance() - withdraw;
		
		if(newBalance < 0) {
			theModel.addAttribute("negativeBalance", "Not enough funds");
			return "checking-account-withdraw";
		}
		
		formatedBalance = df.format(newBalance);
		theUser.setCheckingBalance(Double.parseDouble(formatedBalance));
		userService.update(theUser, false);
		theModel.addAttribute("balance", formatedBalance);
		return "checking-account-withdraw";
	}
	
	@GetMapping("/showDepositCheckingPage")
	public String checkingAccountDepositPage(@SessionAttribute("user") User theUser, Model theModel) {
		String formatBalance = df.format(theUser.getCheckingBalance());
		CrmWithdrawDepositAmount theAmount = new CrmWithdrawDepositAmount();
		theModel.addAttribute("theAmount", theAmount);
		theModel.addAttribute("balance", formatBalance);
		return "checking-account-deposit";
	}
	
	@PostMapping("/depositChecking")
	public String depositIntoCheckingAccount(
			@Valid @ModelAttribute("theAmount") CrmWithdrawDepositAmount theAmount,
			BindingResult theBindingResult,
			@SessionAttribute("user") User theUser,
			Model theModel) {
		String formatedBalance = df.format(theUser.getCheckingBalance());
		theModel.addAttribute("balance", formatedBalance);
		
		if (theBindingResult.hasErrors())
			return "checking-account-deposit";
		
		if(theAmount.getCents().length() == 1)
			theAmount.setCents("0" + theAmount.getCents());
		
		double deposit = Double.parseDouble(theAmount.getDollars() + "." + theAmount.getCents());
		double newBalance = theUser.getCheckingBalance() + deposit;
		
		if(newBalance > 99999.99) {
			theModel.addAttribute("maxedBalance", "Balance cannot exceed $99,999.99");
			return "checking-account-deposit";
		}
		
		formatedBalance = df.format(newBalance);
		theUser.setCheckingBalance(Double.parseDouble(formatedBalance));
		userService.update(theUser, false);
		theModel.addAttribute("balance", formatedBalance);
		return "checking-account-deposit";
	}
	
	@GetMapping("/showWithdrawSavingPage")
	public String savingAccountWithdrawPage(@SessionAttribute("user") User theUser, Model theModel) {
		String formatBalance = df.format(theUser.getSavingBalance());
		CrmWithdrawDepositAmount theAmount = new CrmWithdrawDepositAmount();
		theModel.addAttribute("theAmount", theAmount);
		theModel.addAttribute("balance", formatBalance);
		return "saving-account-withdraw";
	}
	
	@PostMapping("/withdrawSaving")
	public String withdrawFromSavingAccount(
			@Valid @ModelAttribute("theAmount") CrmWithdrawDepositAmount theAmount,
			BindingResult theBindingResult,
			@SessionAttribute("user") User theUser,
			Model theModel) {
		String formatedBalance = df.format(theUser.getSavingBalance());
		theModel.addAttribute("balance", formatedBalance);
		
		if (theBindingResult.hasErrors())
			return "saving-account-withdraw";
		
		if(theAmount.getCents().length() == 1)
			theAmount.setCents("0" + theAmount.getCents());
		
		double withdraw = Double.parseDouble(theAmount.getDollars() + "." + theAmount.getCents());
		double newBalance = theUser.getSavingBalance() - withdraw;
		
		if(newBalance < 0) {
			theModel.addAttribute("negativeBalance", "Not enough funds");
			return "saving-account-withdraw";
		}
		
		formatedBalance = df.format(newBalance);
		theUser.setSavingBalance(Double.parseDouble(formatedBalance));
		userService.update(theUser, false);
		theModel.addAttribute("balance", formatedBalance);
		return "saving-account-withdraw";
	}
	
	@GetMapping("/showDepositSavingPage")
	public String savingAccountDepositPage(@SessionAttribute("user") User theUser, Model theModel) {
		String formatBalance = df.format(theUser.getSavingBalance());
		CrmWithdrawDepositAmount theAmount = new CrmWithdrawDepositAmount();
		theModel.addAttribute("theAmount", theAmount);
		theModel.addAttribute("balance", formatBalance);
		return "saving-account-deposit";
	}
	
	@PostMapping("/depositSaving")
	public String depositIntoSavingAccount(
			@Valid @ModelAttribute("theAmount") CrmWithdrawDepositAmount theAmount,
			BindingResult theBindingResult,
			@SessionAttribute("user") User theUser,
			Model theModel) {
		String formatedBalance = df.format(theUser.getSavingBalance());
		theModel.addAttribute("balance", formatedBalance);
		
		if (theBindingResult.hasErrors())
			return "saving-account-deposit";
		
		if(theAmount.getCents().length() == 1)
			theAmount.setCents("0" + theAmount.getCents());
		
		double deposit = Double.parseDouble(theAmount.getDollars() + "." + theAmount.getCents());
		double newBalance = theUser.getSavingBalance() + deposit;
		
		if(newBalance > 99999.99) {
			theModel.addAttribute("maxedBalance", "Balance cannot exceed $99999.99");
			return "saving-account-deposit";
		}
		
		formatedBalance = df.format(newBalance);
		theUser.setSavingBalance(Double.parseDouble(formatedBalance));
		userService.update(theUser, false);
		theModel.addAttribute("balance", formatedBalance);
		return "saving-account-deposit";
	}
	
	@GetMapping("/editProfile")
	public String editProfilePage(Model theModel) {
		CrmUser crmUser = new CrmUser();
		theModel.addAttribute("crmUser", crmUser);
		return "edit-profile";
	}
	
	@PostMapping("/processProfileEdits")
	public String processProfileEdits(
			@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
			BindingResult theBindingResult,
			@SessionAttribute("user") User theUser,
			Model theModel) {
		if(theBindingResult.hasErrors())
			return "edit-profile";
		theUser.setFirstName(theCrmUser.getFirstName());
		theUser.setLastName(theCrmUser.getLastName());
		theUser.setPinNumber(theCrmUser.getPinNumber());
		userService.update(theUser, true);
		theModel.addAttribute("updatedProfileMessage", "Successfully updated profile.");
		return "account";
	}

}
