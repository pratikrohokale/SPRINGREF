package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.ListOrdersService;

@Controller
public class ListOrdersController {
   @Autowired
	private ListOrdersService service;


	@RequestMapping("/list_orders.htm")
	public String process(Map<String,Object> map) throws Exception {
     List<String> orders=null;
     //use service
     orders=service.getOrders();
     map.put("orders",orders);
     return "show_orders";
	}

}
