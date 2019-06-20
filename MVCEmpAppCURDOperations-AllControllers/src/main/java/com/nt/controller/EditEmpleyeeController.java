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

public class EditEmpleyeeController extends SimpleFormController {
  private ListEmployeeService service;

  public void setService(ListEmployeeService service) {
		this.service = service;
	}
   
	@Override
	public Object formBackingObject(HttpServletRequest req) throws Exception {
		System.out.println("EditEmployeeController:: formBackingObject(-)");
		EmployeeDTO dto=null;
		EmployeeCommand cmd=null;
		//use service
		dto=service.getEmployeeByNo(Integer.parseInt(req.getParameter("empno")));
		//create Command class obj having DTO class object data
		cmd=new EmployeeCommand();
		BeanUtils.copyProperties(dto, cmd);
		return cmd;
	}
	
	@Override
		public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
				BindException errors) throws Exception {
		 EmployeeCommand cmd=null;
		 EmployeeDTO dto=null;
		 List<EmployeeDTO> listDTO=null;
		 cmd=(EmployeeCommand)command;
		 String editMsg=null;
		 ModelAndView mav=null;
		 
		//Convert Command obj to DTO class object
		 dto=new EmployeeDTO();
		 BeanUtils.copyProperties(cmd, dto);
		 //use Service
		 editMsg=service.modifyEmployeeByNo(dto);
		 listDTO=service.getAllEmployees();
		 //create and return  MAV object
		 mav=new ModelAndView();
		 mav.addObject("operationMsg",editMsg);
		 mav.addObject("listEmps",listDTO);
		 mav.setViewName("list_emps");
		 return mav;
		}//onSyumbit(-,-,-,-)
}//class
