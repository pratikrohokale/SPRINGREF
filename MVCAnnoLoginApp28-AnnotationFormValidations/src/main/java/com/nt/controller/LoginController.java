package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	
	@Inject
	private LoginService service;
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("userCmd")UserCommand cmd){
		return "login";
	}
	

	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object>map,@Valid @ModelAttribute("userCmd")UserCommand cmd,BindingResult errors){
		UserDTO dto=null;
		String resultMsg=null;
		//form validation related logic
		if(errors.hasErrors())
			return "login";
		//Convert cmd  obj to DTO obj
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		
		//use service class
		resultMsg=service.authenticate(dto);
		map.put("resultMsg",resultMsg);
		//return lvn
		return "login";
	}//processForm
	
	/*@InitBinder
	public void  myInitBinder(WebDataBinder binder){
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}*/
	
}//class
