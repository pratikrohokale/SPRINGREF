package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		UserCommand command=null;
		//type casting
		command=(UserCommand)cmd;
		//form validation logic
		if(command.getUname().equals("")||command.getUname().length()==0)
			errors.rejectValue("uname","uname.required");
		
		if(command.getPwd().equals("") || command.getPwd().length()==0)
			errors.rejectValue("pwd","pwd.required");
		else if(command.getPwd().length()<4) 
			errors.rejectValue("pwd","pwd.length");
	}//validate(-,-)
}//class
