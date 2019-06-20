package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		StudentCommand command=null;
		
		//type casting
		command=(StudentCommand)cmd;
		//write Server side form validation logics
		if(command.getSno()==null || command.getSno()==0){
			errors.rejectValue("sno","sno.required");
		}
		
		if(command.getSname()==null || command.getSname().length()==0){
			errors.rejectValue("sname","sname.required");
		}
		if(command.getSadd()==null || command.getSadd().length()==0){
			errors.rejectValue("sadd","sadd.required");
		}
		else if(command.getSadd().length()<5){
			errors.rejectValue("sadd","sadd.minlength");
		}
	}//vlidate(-,-)
}//class
