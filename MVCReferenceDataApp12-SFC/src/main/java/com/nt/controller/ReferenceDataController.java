package com.nt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.ReferenceDataCommand;

public class ReferenceDataController extends SimpleFormController {

	@Override
	public Map referenceData(HttpServletRequest request) throws Exception {
		System.out.println("referenceData(-)");
		Map<String,List<String>>map=null;
        List<String> listCountries =null;
        List<String> listHobies=null;
        List<String> listCourses=null;
        
        map=new HashMap();
        
         listCountries=new ArrayList();
          listCountries.add("--select country--");listCountries.add("india");listCountries.add("pak"); listCountries.add("china");
         map.put("countries",listCountries);

        listHobies=new ArrayList();
         listHobies.add("travelling"); listHobies.add("swimming"); listHobies.add("cooking");
         map.put("hobies",listHobies);

        listCourses=new ArrayList();
         listCourses.add("java");listCourses.add(".net"); 
         listCourses.add("phyton");
         map.put("courses",listCourses);
     
    return map;
	}//method
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
        return new ModelAndView("result","cmdData" ,((ReferenceDataCommand)command));		
	}
	
	
}//class
