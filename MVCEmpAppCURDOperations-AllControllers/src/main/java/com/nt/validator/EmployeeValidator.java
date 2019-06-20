package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.EmployeeCommand;


public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(EmployeeCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		EmployeeCommand command=null;
		
		//type casting
		command=(EmployeeCommand)cmd;
		//write Server side form validation logics
		if(command.getEname()==null || command.getEname().length()==0){
			errors.rejectValue("ename","ename.required");
		}
		if(command.getDesg()==null || command.getDesg().length()==0){
			errors.rejectValue("desg","desg.required");
		}
		else if(command.getSalary()<=0){
			errors.rejectValue("salary","salary.required");
		}
	}//vlidate(-,-)
}//class
