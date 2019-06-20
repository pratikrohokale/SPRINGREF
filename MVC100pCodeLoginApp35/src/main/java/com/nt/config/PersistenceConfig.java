package com.nt.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.domain.UserHLO;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public DataSource createDataSource(){
		JndiDataSourceLookup jdsl=null;
		DataSource ds=null;
		jdsl=new JndiDataSourceLookup();
		ds=jdsl.getDataSource("java:/comp/env/DsJndi");
		return ds;
	}
	/*@Bean
	public JndiObjectFactoryBean createJOFB(){
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}
	
	@Bean
	public DataSource createDataSource(){
	   return (DataSource)createJOFB().getObject();	
	}
	*/
	/*@Bean
	public LocalSessionFactoryBean createLSFB(){
	  LocalSessionFactoryBean lsfb=null;
	  Properties props=null;
	  
	  lsfb=new LocalSessionFactoryBean();
	  lsfb.setDataSource(createDataSource());
	  lsfb.setAnnotatedClasses(com.nt.domain.UserHLO.class);
	  props=new Properties();
	  props.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	  props.setProperty("hibernate.show_sql","true");
	  lsfb.setHibernateProperties(props);
	  return lsfb;
	}
	
	
	
	@Bean
	public SessionFactory createSessionFactory(){
		return createLSFB().getObject();
	}*/
	
	@Bean
	public SessionFactory createSessionFactory(){
		LocalSessionFactoryBuilder builder=null;
		Properties props=null;
		SessionFactory factory=null;
		
		builder=new LocalSessionFactoryBuilder(createDataSource());
		builder.addAnnotatedClasses(UserHLO.class);
		 props=new Properties();
		  props.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
		  props.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
		  props.setProperty("hibernate.connection.username","system");
		  props.setProperty("hibernate.connection.password","manager");
		  props.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		  props.setProperty("hibernate.show_sql","true");
		builder.setProperties(props);
		factory=builder.buildSessionFactory();
		return factory;
	}
	
	@Bean
	public HibernateTemplate createHT(){
		return new HibernateTemplate(createSessionFactory());
	}
}//class
