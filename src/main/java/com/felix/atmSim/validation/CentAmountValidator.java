package com.felix.atmSim.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CentAmountValidator implements ConstraintValidator<ValidCentAmount, String> {
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String CENT_PATTERN = "\\d\\d?";

	@Override
	public boolean isValid(String cents, ConstraintValidatorContext context) {
		pattern = Pattern.compile(CENT_PATTERN);
		if(cents == null)
			return false;
		matcher = pattern.matcher(cents);
		return matcher.matches();
	}

}
