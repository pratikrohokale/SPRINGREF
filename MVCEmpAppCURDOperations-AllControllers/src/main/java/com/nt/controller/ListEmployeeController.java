package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.ListEmployeeService;

public class ListEmployeeController extends AbstractController {
	private ListEmployeeService service;

	public void setService(ListEmployeeService service) {
		this.service = service;
	}//method

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<EmployeeDTO> listDTO=null;
	   //use Service
		listDTO=service.getAllEmployees();
		return new ModelAndView("list_emps","listEmps",listDTO);
	}//method
	
}//class
