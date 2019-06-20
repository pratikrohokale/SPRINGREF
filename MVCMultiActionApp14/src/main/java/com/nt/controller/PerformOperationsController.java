package com.nt.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.nt.command.UserCommand;

public class PerformOperationsController extends MultiActionController {

/*	public ModelAndView   insert(HttpServletRequest req,HttpServletResponse res,HttpSession ses,UserCommand cmd){
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("user");
		mav.addObject("operation","insert operation succesfull");
		mav.addObject("cmdData",cmd);
		return mav;
	}
*/	
	/*public String   insert(HttpServletRequest req,HttpServletResponse res,HttpSession ses,UserCommand cmd){
		System.out.println("insert method...");
		return "perform";
	}*/
	
/*	public Map<String,Object>   insert(HttpServletRequest req,HttpServletResponse res,HttpSession ses,UserCommand cmd){
		System.out.println("insert method...");
		Map<String,Object> map=null;
		map=new HashMap();
		map.put("operation","insert opeation");
		map.put("cmdData",cmd);
		return map;
	}*/
	
	public void   insert(HttpServletRequest req,HttpServletResponse res,HttpSession ses,UserCommand cmd)throws Exception {
		System.out.println("insert method...");
		PrintWriter pw=res.getWriter();
		pw.println("insert operations super success..");
	}
	
    public ModelAndView   update(HttpServletRequest req,HttpServletResponse res,UserCommand cmd){
		
		return new ModelAndView("user","operation","update Opeation sucessful");
	}
    
public ModelAndView   remove(HttpServletRequest req,HttpServletResponse res,UserCommand cmd){
		
		return new ModelAndView("user","operation","remove Opeation sucessful");
	}

public ModelAndView   view(HttpServletRequest req,HttpServletResponse res,UserCommand cmd){
	
	return new ModelAndView("user","operation","view Opeation sucessful");
}

public ModelAndView   invalid(HttpServletRequest req,HttpServletResponse res,UserCommand cmd){
	
	return new ModelAndView("user","operation","invalid request param");
}


	
	
}
