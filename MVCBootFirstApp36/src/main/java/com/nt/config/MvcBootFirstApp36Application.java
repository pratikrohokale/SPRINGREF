package com.nt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(value=WebMvcConfig.class)
public class MvcBootFirstApp36Application {

	public static void main(String[] args) {
		SpringApplication.run(MvcBootFirstApp36Application.class, args);
	}
}
