package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentInsertController extends SimpleFormController {

	private StudentService service;

	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		StudentDTO dto=null;
		String result=null;
		StudentCommand cmd=null;
		//typecasting
		cmd=(StudentCommand)command;
		
	     //Write logic for Application Errors
		if(((StudentCommand)command).getSadd().equals("hyderabad")){
			errors.rejectValue("sadd","sadd.notAllowed");
			return showForm(req,res,errors);
		}
		//Convert Command obj to DTO 
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd,dto);
		dto.setSno(cmd.getSno().intValue());
		
		//use Service class
		result=service.register(dto);
		//create and return MAV
		//return new ModelAndView("result","resultMsg",result);
		return new ModelAndView(getSuccessView(),"resultMsg",result);
	}//onSubmit(-,-,-,-)
}//class
