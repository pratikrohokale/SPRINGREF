package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.hlo.StudentHLO;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	@Autowired
	private DataSource ds;
	
	@Bean(name="localSesFact")
	public LocalSessionFactoryBean createSessionLocalFactory(){
		LocalSessionFactoryBean sesfact=null;
		Properties props=null;
		sesfact=new LocalSessionFactoryBean();
		sesfact.setDataSource(ds);
		sesfact.setAnnotatedClasses(StudentHLO.class);
		sesfact.setAnnotatedPackages("com.nt.hlo");
		
		props=new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.show_sql","true");
		sesfact.setHibernateProperties(props);
		return sesfact;
	}
	
	@Bean(name="sesfact")
	public SessionFactory createSessionFactory(){
		return createSessionLocalFactory().getObject();
	}
	
	@Bean(name="ht")
	public HibernateTemplate createHt(){
		return new HibernateTemplate(createSessionFactory());
	}

}
