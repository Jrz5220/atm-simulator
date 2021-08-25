package com.felix.atmSim.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DollarAmountValidator implements ConstraintValidator<ValidDollarAmount, String> {
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String DOLLAR_PATTERN = "([1-9]\\d?\\d?\\d?)?\\d";
	
	@Override
	public boolean isValid(String dollars, ConstraintValidatorContext context) {
		pattern = Pattern.compile(DOLLAR_PATTERN);
		if(dollars == null)
			return false;
		matcher = pattern.matcher(dollars);
		return matcher.matches();
	}

}
