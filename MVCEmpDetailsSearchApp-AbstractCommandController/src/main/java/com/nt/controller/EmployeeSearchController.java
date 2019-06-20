package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.EmployeeSearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeSearchService;

public class EmployeeSearchController extends AbstractCommandController {
	private EmployeeSearchService service;

	public void setService(EmployeeSearchService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object command, BindException errors)
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
		return new ModelAndView("list_emps","searchDetails", listRDTO);
	}
}
