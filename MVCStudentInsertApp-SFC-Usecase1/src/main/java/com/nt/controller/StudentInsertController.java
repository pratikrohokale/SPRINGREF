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
	public Object formBackingObject(HttpServletRequest request) throws Exception {
	   System.out.println("formBackingObject(-)");
		StudentCommand command=null;
	   command=new StudentCommand();
	   command.setSno(6789);
	   command.setSname("rajesh");
	   command.setSadd("hyd");
	   return command;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StudentDTO dto=null;
		String result=null; 
		//Convert Command obj to DTO 
		dto=new StudentDTO();
		BeanUtils.copyProperties(((StudentCommand)command),dto);
		//use Service class
		result=service.register(dto);
		//create and return MAV
		//return new ModelAndView("result","resultMsg",result);
		return new ModelAndView(getSuccessView(),"resultMsg",result);
	}//onSubmit(-,-,-,-)
}//class
