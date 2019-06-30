package com.javalec.ex;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		
		
		if(str.equals("dev")) {
			config = "dev";
		}
		else if(str.equals("run")) {
			config = "run";
		}
		
		
		
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles(config);	// xml 문서 중 해당 config 문자열과 같은 profile을 가진 xml 파일을 활성화 시켜라
		context.load("dev_applicationContext.xml", "run_appplicationContext.xml");
		ServerInfo info = context.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		scanner.close();
		context.close();
		
	}
	
}
