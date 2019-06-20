package com.nt.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AOPConfig {
	@Autowired
	private SessionFactory sesfact;
	
	@Bean(name="hbTxMgmr")
	public PlatformTransactionManager createHBTxMgmr(){
		return new HibernateTransactionManager(sesfact);
	}

}
