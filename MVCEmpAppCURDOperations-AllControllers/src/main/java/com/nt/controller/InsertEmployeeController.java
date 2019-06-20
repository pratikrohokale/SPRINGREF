package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.service.ListEmployeeService;

public class InsertEmployeeController extends SimpleFormController {
  
	private ListEmployeeService service;
	
	  public void setService(ListEmployeeService service) {
			this.service = service;
		}
	  
	  @Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		  EmployeeCommand cmd=null;
		  EmployeeDTO dto=null;
		  String insertMsg=null;
		  List<EmployeeDTO> listDTO=null;
		  ModelAndView mav=null;
		  //type Casting
		  cmd=(EmployeeCommand)command;
		  //Convert EmployeeCommand to EmployeeDTO
		  dto=new EmployeeDTO();
		  BeanUtils.copyProperties(cmd,dto);
		  //use Service
		  insertMsg=service.register(dto);
		  listDTO=service.getAllEmployees();
		  //create and return MAV Object
		  mav=new ModelAndView();
		  mav.addObject("operationMsg",insertMsg);
		  mav.addObject("listEmps",listDTO);
		  mav.setViewName("list_emps");
		return mav;
	}
}
