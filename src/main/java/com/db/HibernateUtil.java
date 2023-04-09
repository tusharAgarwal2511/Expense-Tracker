package com.db;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.*;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		
		
		if(sessionFactory == null) {
			
			Configuration cfgConfiguration = new Configuration();
			
			Properties properties = new Properties();
			
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/expense_tracker");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "1234");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.FORMAT_SQL, "true");
			
			cfgConfiguration.setProperties(properties);
			
			cfgConfiguration.addAnnotatedClass(User.class);
			cfgConfiguration.addAnnotatedClass(Expense.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfgConfiguration.getProperties()).build();
			
			sessionFactory = cfgConfiguration.buildSessionFactory(serviceRegistry);
			
			
			
		}
		
		return sessionFactory;
		
	}

}
