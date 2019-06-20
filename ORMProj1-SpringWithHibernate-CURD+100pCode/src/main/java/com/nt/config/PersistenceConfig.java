package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.nt.domain.SpStudentHLO;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public DataSource createDataSource(){
		BasicDataSource ds=null;
		ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("manager");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean  createLocalSessionFactory(){
		 LocalSessionFactoryBean factory=null;
		 Properties props=null;
		 factory=new LocalSessionFactoryBean();
		 factory.setDataSource(createDataSource() );
		 factory.setAnnotatedClasses(SpStudentHLO.class);
		 factory.setAnnotatedPackages("com.nt.domain");
		 props=new Properties();
		 props.setProperty("hibernate.show_sql","true");
		 props.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		 factory.setHibernateProperties(props);
		 return factory;
	}
	
	@Bean
	@Primary
	public SessionFactory  createSessionFactory(){
		return  createLocalSessionFactory().getObject();
	}

	
	
	@Bean
	public  HibernateTemplate  createHibernateTemplate(){
		return new HibernateTemplate(createSessionFactory());
	}

}//class
