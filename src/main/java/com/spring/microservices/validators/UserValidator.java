package com.spring.microservices.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.microservices.entities.UserEntity;
import com.spring.microservices.services.UserService;

/**
 * @author sunilsingh
 */
public class UserValidator implements Validator {

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		if (userService.isUserEnabled() != 'T')
			;
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if (userService.isUserEnabled() != 'T') {
			errors.rejectValue("enabled", "enabled.required");
		}
	}

}
