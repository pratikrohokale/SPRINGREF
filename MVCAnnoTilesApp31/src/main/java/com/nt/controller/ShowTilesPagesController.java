package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowTilesPagesController {
	
	@RequestMapping("/home.htm")
	public String showHomePage(){
		return "homeDef";
		
	}
	@RequestMapping("/link1.htm")
	public String showAddrsPage(){
		return "addrsDef";
		
	}
	@RequestMapping("/link2.htm")
	public String showCoursesPage(){
		return "coursesDef";
		
	}
	@RequestMapping("/link3.htm")
	public String showFacultiesPage(){
		return "facultiesDef";
		
	}



}
