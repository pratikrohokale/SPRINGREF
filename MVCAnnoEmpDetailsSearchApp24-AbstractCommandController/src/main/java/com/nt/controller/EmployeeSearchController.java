package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.EmployeeSearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeSearchService;

@Controller
public class EmployeeSearchController {
    @Autowired
	private EmployeeSearchService service;

	
    @RequestMapping("/performSearch.htm")
	public String handle(Map<String,Object> map,@ModelAttribute EmployeeSearchCommand command)
			throws Exception {
		EmployeeSearchCommand cmd=null;
		EmployeeDTO dto=null;
		List<EmployeeResultDTO> listRDTO=null;
		//Convert Command to DTO
		cmd=(EmployeeSearchCommand)command;
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use SErvice
		listRDTO=service.search(dto);
		map.put("listEmps",listRDTO);
		return "list_emps";
	}
}
