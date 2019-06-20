package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class PersistenceConfig {
	
	@Bean
	public DataSource createDataSource(){
		JndiDataSourceLookup jdsl=null;
		DataSource ds=null;
		
		jdsl=new JndiDataSourceLookup();
		ds=jdsl.getDataSource("java:/comp/env/DsJndi");
		return ds;
	}

}
