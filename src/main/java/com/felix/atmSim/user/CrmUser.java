package com.felix.atmSim.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.felix.atmSim.validation.FieldMatch;

@FieldMatch.List({ @FieldMatch(first="pinNumber", second="matchingPinNumber", message="The pin numbers must match") })
public class CrmUser {
	
	@NotNull(message="is required")
	@Size(min=4, max=4, message="please enter a 4 digit pin number")
	private String pinNumber;
	
	@NotNull(message="is required")
	@Size(min=4, max=4, message="should match your 4 digit pin number")
	private String matchingPinNumber;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	private String accountNumber;
	
	public CrmUser() {
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getMatchingPinNumber() {
		return matchingPinNumber;
	}

	public void setMatchingPinNumber(String matchingPinNumber) {
		this.matchingPinNumber = matchingPinNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "CrmUser [pinNumber=" + pinNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountNumber=" + accountNumber + "]";
	}

}
