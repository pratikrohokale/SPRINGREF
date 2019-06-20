package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.ReferenceDataCommand;

public class ReferenceDataValidator implements Validator {

	@Override
	public boolean supports(Class<?> cmd) {
		return cmd.isAssignableFrom(ReferenceDataCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		ReferenceDataCommand command=null;
		//type casting
		command=(ReferenceDataCommand)cmd;
		//form validation logic
		if(command.getName().equals("") ||command.getName().length()==0)
			errors.rejectValue("name","name.required");
		
		if(command.getAddrs().equals("") ||command.getAddrs().length()==0)
			errors.rejectValue("addrs","addrs.required");
		
		if(command.getCountry().indexOf("--")>=0)
			errors.rejectValue("country","country.required");
		
		if(command.getHobies()==null || command.getHobies().length==0 )
			errors.rejectValue("hobies","hobies.required");
		
		if(command.getCourses()==null || command.getCourses().length==0)
			errors.rejectValue("courses","courses.required");
	}
}
