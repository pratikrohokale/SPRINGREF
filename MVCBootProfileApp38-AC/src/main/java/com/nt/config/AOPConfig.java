package com.nt.config;

import java.nio.file.AccessMode;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AOPConfig {
	/*@Autowired
	private DataSource ds;*/
	
	/*@Bean(name="dsTxMgmr")
	public PlatformTransactionManager  createDTxM(){
	  DataSourceTransactionManager txMgmr=null;
	  txMgmr=new DataSourceTransactionManager(ds);
	  return txMgmr;
	}*/
	
	@Bean(name="dsTxMgmr",autowire=Autowire.BY_TYPE)
	public PlatformTransactionManager  createDTxM(){
		  DataSourceTransactionManager txMgmr=null;
		  txMgmr=new DataSourceTransactionManager();
		  return txMgmr;
		}
	
	

}
