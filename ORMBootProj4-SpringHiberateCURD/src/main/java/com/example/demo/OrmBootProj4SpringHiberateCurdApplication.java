package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.service.StudentService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class OrmBootProj4SpringHiberateCurdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		ctx=SpringApplication.run(OrmBootProj4SpringHiberateCurdApplication.class, args);
		//get Bean
		service=ctx.getBean("stService",StudentService.class);
		try{
		  //invoke method
			System.out.println("103 Student details"+service.getStudentByNo(103));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
