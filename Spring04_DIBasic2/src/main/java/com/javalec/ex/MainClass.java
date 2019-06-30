package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(configLocation);
		MyInformation myInfo = context.getBean("myInfo", MyInformation.class);
		myInfo.getInfo();
		context.close();
		
	}
	
}
