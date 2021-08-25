package com.felix.atmSim.user;

import com.felix.atmSim.validation.ValidCentAmount;
import com.felix.atmSim.validation.ValidDollarAmount;

public class CrmWithdrawDepositAmount {
	
	@ValidDollarAmount
	private String dollars;
	
	@ValidCentAmount
	private String cents;

	public CrmWithdrawDepositAmount() {
	}

	public String getDollars() {
		return dollars;
	}

	public void setDollars(String dollarAmount) {
		this.dollars = dollarAmount;
	}

	public String getCents() {
		return cents;
	}

	public void setCents(String centAmount) {
		this.cents = centAmount;
	}

}
