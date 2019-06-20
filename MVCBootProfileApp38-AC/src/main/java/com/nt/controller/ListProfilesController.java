package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.ProfileDTO;
import com.nt.service.ListProfilesService;

@Controller
public class ListProfilesController {
	@Autowired
    private ListProfilesService service; 
	
	@RequestMapping("/home.htm")
	public String showHomePage(){
		return "home";
	}
	
	@RequestMapping("/profiles.htm")
	public String showProfiles(Map<String,Object> map){
		List<ProfileDTO> listDTO=null;
		//use Service
		listDTO=service.getProfiles();
		//add to Model Attribute
		map.put("profilesList",listDTO);
		return "show_profiles";
	}
	
	
}
