package com.javalec.util;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	public JdbcTemplate template;
	private static Constant instance = null;
	
	private Constant(){
		
	}
	
	// Singleton
	public static Constant getInstance(){
		
		if(instance == null)
			instance = new Constant();
		
		return instance;
	}
	
}
