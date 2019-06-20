package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.nt.command.RegisterCommand;
import com.nt.dto.RegisterDTO;
import com.nt.service.NaukriRegistrationService;

public class RegisterWizardFormController extends AbstractWizardFormController {
	private NaukriRegistrationService service;
	
	public void setService(NaukriRegistrationService service) {
		this.service = service;
	}

	@Override
	public ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		return new ModelAndView("welcome");
	}

	@Override
	public ModelAndView processFinish(HttpServletRequest req,HttpServletResponse res, Object cmd,
			BindException errors) throws Exception {
		RegisterCommand command=null;
		RegisterDTO dto=null;
		String regMsg=null;
		//Typecasting
		command=(RegisterCommand)cmd;
		//Convert Command to DTO
		dto=new RegisterDTO();
		BeanUtils.copyProperties(command,dto);
		//use service
		regMsg=service.register(dto);
		//create and return MAV
		return new ModelAndView("result","regMsg",regMsg);
	}

}
