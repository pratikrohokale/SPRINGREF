package com.nt.interceptor;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DoublePostingPreventorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession ses=null;
		int clientToken=0,serverToken=0;
		RequestDispatcher rd=null;
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			//create /locate Session
			ses=request.getSession(true);
			// generate Server Side Seession token and keep in session attribute
			ses.setAttribute("sToken",new Random().nextInt(300));
			return true;
		}
		else{
			//Locate Session
			ses=request.getSession(false);
			//read Server Token value
			serverToken=(Integer)ses.getAttribute("sToken");
			//read Server Token value
			clientToken=Integer.parseInt(request.getParameter("cToken"));
			//Compare both tokens
			if(serverToken==clientToken){
				//change Server Token value
				ses.setAttribute("sToken",new Random().nextInt(300));
		        return true;		
			}
			else{
				rd=request.getRequestDispatcher("/dbl_post.jsp");
				rd.forward(request, response);
				return false;
			}//else
		}//if
	}//method
}//class
