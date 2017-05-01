package com.springtest.common.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springtest.model.User;

@Service
public class ProductValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
	}
}
