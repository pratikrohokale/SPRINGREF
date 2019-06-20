package com.nt.service;

import java.util.Calendar;

import org.springframework.web.servlet.ModelAndView;

public class WishServiceImpl implements WishService {
   
	@Override
	public String generateWishMsg() {
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
		return wishMsg;
	}

}
