package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishService;

public class WishController extends AbstractController {
	private WishService service;
	private String wishMsg=null;

	public void setService(WishService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav=null;
		//use SErvice class
		wishMsg=service.generateWishMsg();
		//create and return MAV Object
		mav=new ModelAndView();
		mav.setViewName("result");
		mav.addObject("wMsg",wishMsg);
		return mav;
	}//method
}//class
