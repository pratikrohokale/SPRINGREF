package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeCheckHandlerInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		Calendar cal=null;
		int hour=0;
		RequestDispatcher rd=null;
		//get date and time
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);//24 hrs format
		if(hour<9 || hour>17){
			rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req,res);
			return false;
		}
		else{
			return true;
		}
	}//method
}//class
