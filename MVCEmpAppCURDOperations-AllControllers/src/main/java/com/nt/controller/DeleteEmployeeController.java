package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.ListEmployeeService;

public class DeleteEmployeeController extends AbstractController {
   public void setService(ListEmployeeService service) {
		this.service = service;
	}


private ListEmployeeService service;
   
   
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no=0;
		String deleteMsg;
		List<EmployeeDTO> listDTO=null;
		ModelAndView mav=null;
		//read employee number
		no=Integer.parseInt(req.getParameter("empno"));
		//use SErvice class
		deleteMsg=service.removeEmployeeByNo(no);
		listDTO=service.getAllEmployees();
		//create and return MAV
		mav=new ModelAndView();
		mav.addObject("operationMsg",deleteMsg);
		mav.addObject("listEmps",listDTO);
		mav.setViewName("list_emps");
		return mav;
	}

}
