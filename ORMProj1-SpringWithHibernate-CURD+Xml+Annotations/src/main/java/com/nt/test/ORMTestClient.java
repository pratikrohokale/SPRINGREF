package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.SpStudentDTO;
import com.nt.service.StudentService;

public class ORMTestClient {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		SpStudentDTO dto=null;
	   //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class obj
		service=ctx.getBean("stService",StudentService.class);
	     try{
		//invoke method
		System.out.println("103 student details are::"+service.getStudentByNo(103));
		//prepare DTO
		dto=new SpStudentDTO();
		dto.setSno(829); dto.setSname("raja"); dto.setSadd("hyd");
		//System.out.println(service.register(dto));
		//System.out.println(service.changeAddrs(829,"newDelhi"));
		//System.out.println(service.fireStudent(829));
		// System.out.println("hyd addrs student details::"+service.getStudentsByAddrs("hyd"));
		 //System.out.println("raja,ramesh detials"+service.getStudentsByNames("raja","ramesh"));
		 //System.out.println("100-200 student details::"+service.getStudentsByRange(100,200));
		 //System.out.println("100-102 student details ::"+service.fetchStudentsByRange(100, 102));
		 //System.out.println(service.deleteStudentsByAddrs("hyd"));
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
