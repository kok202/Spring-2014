package com.javalec.ex;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;


public class MainClass {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = context.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println( env.getProperty("admin.id") );
			System.out.println( env.getProperty("admin.pw") );
		} 
		catch (IOException e) {
			
		}
		
		
		
		GenericXmlApplicationContext genericContext = (GenericXmlApplicationContext)context;
		genericContext.load("applicationContext.xml");
		genericContext.refresh();
		
		AdminConnection adminConnection = genericContext.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("amdin PW : " + adminConnection.getAdminPw());
		
		genericContext.close();
		context.close();
		
	}
	
}
