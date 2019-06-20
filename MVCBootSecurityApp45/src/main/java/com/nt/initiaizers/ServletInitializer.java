package com.nt.initiaizers;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcConfig;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebMvcConfig.class,RootAppConfig.class);
	}

}
