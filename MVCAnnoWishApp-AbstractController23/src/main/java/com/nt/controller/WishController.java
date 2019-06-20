package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService service;

	/*@RequestMapping("/wish.htm")
	public  ModelAndView process(){
		String wMsg=null;
		//use Service
		wMsg=service.generateWishMsg();
		return new ModelAndView("result","wMsg",wMsg);
	}*/
	
/*	@RequestMapping("/wish.htm")
	public String process(Model model){
		String wMsg=null;
		wMsg=service.generateWishMsg();
		model.addAttribute("wMsg",wMsg);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(ModelMap map){
		String wMsg=null;
		wMsg=service.generateWishMsg();
		map.addAttribute("wMsg",wMsg);
		return "result";
	}
*/	
	/*@RequestMapping("/wish.htm")
	public String process(Map<String,Object> map){
		String wMsg=null;
		wMsg=service.generateWishMsg();
		map.put("wMsg",wMsg);
		return "result";
	}*/
	/*
	@RequestMapping("/wish.htm")
	public void process(Map<String,Object> map){
		String wMsg=null;
		wMsg=service.generateWishMsg();
		map.put("wMsg",wMsg);
	}
	*/
	/*@RequestMapping("/wish.htm")
	public Model process(){
		 Model model=null;
		 
		String wMsg=null;
		wMsg=service.generateWishMsg();
		model=new ExtendedModelMap();
		model.addAttribute("wMsg",wMsg);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public ModelMap process(){
		 ModelMap map=null;
		 
		String wMsg=null;
		wMsg=service.generateWishMsg();
		map=new ExtendedModelMap();
		map.addAttribute("wMsg",wMsg);
		return map;
	}*/
	

	@RequestMapping("/wish.htm")
	public Map<String,Object> process(){
		 Map<String,Object> map=null;
		String wMsg=null;
		
		wMsg=service.generateWishMsg();
		map=new HashMap();
		map.put("wMsg",wMsg);
		return map;
	}
	
	
}
