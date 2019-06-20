package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeViewController {

	@RequestMapping("/home.htm")
	public String process(){
		return "welcome";
	}
}
