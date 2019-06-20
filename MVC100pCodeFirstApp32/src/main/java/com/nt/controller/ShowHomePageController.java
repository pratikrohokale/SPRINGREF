package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomePageController {
	
	@RequestMapping("/home.htm")
	public  String showHome(Map<String,Object> map){
		//put model data
		map.put("sysDate",new Date());
		return "welcome";
	}

}
