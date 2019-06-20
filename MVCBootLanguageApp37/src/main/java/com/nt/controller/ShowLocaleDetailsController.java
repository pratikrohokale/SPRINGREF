package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.LocaleDetailsService;

@Controller
public class ShowLocaleDetailsController {
	@Autowired
	private LocaleDetailsService service;
	
  @RequestMapping("/languages.htm")
  public  String showLanguages(Map<String,Object> map){
	  List<String>  list=null;
	  //use Service
	  list=service.getAllLanguages();
	  //put in Model Attribute
	  map.put("langList",list);
	  return "result";
  }
  
  @RequestMapping("/countries.htm")
  public  String showCountries(Map<String,Object> map){
	  List<String>  list=null;
	  //use Service
	  list=service.getAllCountries();
	  //put in Model Attribute
	  map.put("countryList",list);
	  return "result";
  }
	
}
