package com.felix.atmSim.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstFieldName;
    private String secondFieldName;
    private String message;
    
    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
    	firstFieldName = constraintAnnotation.first();
	    secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean valid = true;
		try {
			// create beans for the field values
			final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
			final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
			
			//false if first and second object are not equal (either they're both null or have the same value)
            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		} catch(final Exception ignore) {
			// we can ignore
		}
		
		// if not equal, generate error message
		if(!valid) {
			context.buildConstraintViolationWithTemplate(message)
            .addPropertyNode(firstFieldName)
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
		}
		return valid;
	}

}
