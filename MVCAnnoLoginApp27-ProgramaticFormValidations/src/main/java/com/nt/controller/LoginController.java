package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {
	
	@Inject
	private LoginService service;
	@Inject
	private LoginValidator validator;
	
	/*@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(Map<String,Object>map){
		UserCommand cmd=null;
		cmd=new UserCommand();
		map.put("userCmd",cmd);
		return "login";
	}*/
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("userCmd")UserCommand cmd){
		return "login";
	}
	

	/*@ModelAttribute("domains")
	public List<String> populateDomains(){
		List<String> list=null;
		list=new ArrayList();
		list.add("gmail.com");
		list.add("yahoo.com");
		list.add("rediff.com");
		return list;
	}*/
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object>map,@ModelAttribute("userCmd")UserCommand cmd,BindingResult errors){
		UserDTO dto=null;
		String resultMsg=null;
		//Use Validator
		if(validator.supports(UserCommand.class)){
			validator.validate(cmd, errors);
			if(errors.hasErrors())
				return "login";
		}
		
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
