package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

@Controller
public class StudentInsertController{

	@Autowired
	private StudentService service;

	@RequestMapping(value="/student.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("stCmd") StudentCommand cmd){
		return "student";
	}
	

	@RequestMapping(value="/student.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,
			                  @ModelAttribute("stCmd") StudentCommand command,
			                  BindingResult errors){
		StudentDTO dto=null;
		String result=null; 
		//Convert Command obj to DTO 
		dto=new StudentDTO();
		BeanUtils.copyProperties(command,dto);
		//use Service class
		result=service.register(dto);
		//keep the result in model attribute
		map.put("resultMsg",result);
		return "result";
		
	}//onSubmit(-,-,-,-)
}//class
