package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.dto.SpStudentDTO;
import com.nt.service.StudentService;

public class ORMTestClient {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		SpStudentDTO dto=null;
	   //create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Service class obj
		service=ctx.getBean("stService",StudentService.class);
	     try{
		//invoke method
		System.out.println("103 student details are::"+service.getStudentByNo(103));
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
