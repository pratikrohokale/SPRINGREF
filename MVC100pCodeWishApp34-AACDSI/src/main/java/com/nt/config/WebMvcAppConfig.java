package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.nt.controller")
public class WebMvcAppConfig{
	
	
	@Bean
	public RequestMappingHandlerMapping createDAHM(){
		RequestMappingHandlerMapping rmhm=null;
		rmhm=new RequestMappingHandlerMapping();
		return rmhm;
	}
	
	@Bean
	public SimpleUrlHandlerMapping createSUHM(){
		SimpleUrlHandlerMapping suhm=null;
		Properties props=null;
		
		suhm=new SimpleUrlHandlerMapping();
		props=new Properties();
		props.setProperty("/home.htm","pvc");
		suhm.setMappings(props);
		return suhm;
	}
  
	@Bean
	public InternalResourceViewResolver createIRVR(){
		InternalResourceViewResolver ivr=null;
		ivr=new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/pages/");
		ivr.setSuffix(".jsp");
		return ivr;
	}
	
	@Bean(name="pvc")
	public  ParameterizableViewController createPVC(){
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("welcome");
		return pvc;
	}
 }