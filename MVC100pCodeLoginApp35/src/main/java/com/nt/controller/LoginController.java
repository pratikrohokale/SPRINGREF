package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
   private LoginService service;
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public  String showForm(@ModelAttribute("userCmd")UserCommand cmd){
		return "login";
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@ModelAttribute("userCmd") UserCommand cmd){
		UserDTO dto=null;
		String resultMsg=null;
	  //Convert Cmd object to DTO
		dto=new UserDTO();
	   BeanUtils.copyProperties(cmd, dto);
	   //use Service
	   resultMsg=service.authenticate(dto);
	   //put data in model attribute
	   map.put("resMsg",resultMsg);
	   return "login";
	}

}
