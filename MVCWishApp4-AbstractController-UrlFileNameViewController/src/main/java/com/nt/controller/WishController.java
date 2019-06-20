package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Calendar calendar=null;
		int hour=0;
		String wishMsg=null;
		ModelAndView mav=null;
		
		//get System Date
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish Msg
		if(hour<=12)
			wishMsg="Good Morning";
		else if(hour<=16)
			wishMsg="Good AfterNoon";
		else if(hour<=20)
			wishMsg="Good Evening";
		else
			wishMsg="Good Night";
		//create and return MAV Object
		mav=new ModelAndView();
		mav.setViewName("result");
		mav.addObject("wMsg",wishMsg);
		return mav;
		//return new ModelAndView("result","wMsg",wishMsg);
	}//method
}//class
