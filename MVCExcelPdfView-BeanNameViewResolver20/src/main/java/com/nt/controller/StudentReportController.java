package com.nt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.dto.StudentDTO;

public class StudentReportController extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
	  List<StudentDTO> studList=null;
	  StudentDTO dto=null,dto1=null;
	  String reportType=null;
	  
	  studList=new ArrayList();
		dto=new StudentDTO();
		dto1=new StudentDTO();
		dto.setSno(1001); dto.setSname("raja"); dto.setSadd("hyd");
		dto1.setSno(456); dto1.setSname("rani");dto1.setSadd("vizag");
		studList.add(dto); studList.add(dto1);
		reportType=req.getParameter("report");
        //create and return MAV object		
		if(reportType.equalsIgnoreCase("excel"))
		  return new ModelAndView("excelReport","studList",studList);
		else
			return new ModelAndView("pdfReport","studList",studList);	
	}//method
}//class
