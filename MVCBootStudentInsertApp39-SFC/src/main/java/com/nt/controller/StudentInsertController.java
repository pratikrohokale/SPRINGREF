package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentInsertService;

@Controller
public class StudentInsertController {
	@Autowired
	private StudentInsertService service;

	@GetMapping(value="/home.htm")
	public String showForm(@ModelAttribute("stCmd")StudentCommand cmd){
		return "student";
	}
	
	@PostMapping(value="/home.htm")
	public String processForm(Map<String,Object> map,@ModelAttribute("stCmd")StudentCommand cmd){
	    StudentDTO dto=null;
	    String resMsg=null;
	    System.out.println(cmd);
		//Convert Cmd to DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		resMsg=service.registerStudent(dto);
		map.put("resMsg",resMsg);
		return "student";
	}
	
	
}
