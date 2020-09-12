package com.test.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.test.bean.Student1;


public class HibernateUtil {

	private static SessionFactory sf;
	private static SessionFactory sfanno;
	private static SessionFactory sfjava;
	
	private static SessionFactory buildSessionFactory()
	{
		try {
	Configuration c1 = new Configuration();
	c1.configure("hibernate.cfg.xml");
	
	ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c1.getProperties()).build();
		
	SessionFactory sf = c1.buildSessionFactory(sr);
	return sf;
	}
		catch(Throwable e)
		{
			System.out.println(e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private static SessionFactory buildSessionAnnoFactory()
	{
		try {
			Configuration c2 = new Configuration();
			c2.configure("hibernate-annotation.cfg.xml");
			
			ServiceRegistry sr1 = new StandardServiceRegistryBuilder().applySettings(c2.getProperties()).build();
			SessionFactory sf1 = c2.buildSessionFactory(sr1);
			return sf1;
		}
		catch(Throwable e)
		{
			System.out.println(e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private static SessionFactory buildSessionJavaFactory()
	{
		try {
			Configuration c = new Configuration();
			Properties props = new Properties();
			props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			props.put("hibernate.connection.url", "jdbc:mysql://localhost/test");
			props.put("hibernate.connection.username", "root");
			props.put("hibernate.connection.password", "root");
			props.put("hibernate.current_session_context_class", "thread");
			c.setProperties(props);
			
			c.addAnnotatedClass(Student1.class);
			
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			
			SessionFactory sf =c.buildSessionFactory(sr);
			return sf;
		}
		catch(Throwable e)
		{
			System.out.println(e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		if(sf == null)
		{
			 sf = buildSessionFactory();
		}
		
			return sf;
	}
	
	public static SessionFactory getAnnoSessionFactory()
	{
		if(sfanno==null)
		{
			sfanno = buildSessionAnnoFactory();
		}
		return sfanno;
	}
	
	public static SessionFactory getSessionJavaFactory()
	{
		if(sfjava==null)
		{
			sfjava = buildSessionJavaFactory();
		}
		return sfjava;
	}
}
