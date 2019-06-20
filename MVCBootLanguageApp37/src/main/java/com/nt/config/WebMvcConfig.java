package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;


@Configuration
@ComponentScan(basePackages="com.nt.controller")
public class WebMvcConfig {

	@Bean
	public  HandlerMapping createSUHM(){
		SimpleUrlHandlerMapping suhm=null;
		Properties props=null;
		suhm=new SimpleUrlHandlerMapping();
		props=new Properties();
		props.put("/home.htm","pvc");
		suhm.setMappings(props);
		suhm.setOrder(Integer.MAX_VALUE-1);
		return suhm;
	}
	
	@Bean(name="pvc")
	public Controller  createPVC(){
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("home");
		return pvc;
	}
}
