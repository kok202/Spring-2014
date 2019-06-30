package com.javalec.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1()
	{
		Student student = new Student("홍길동", "20살", "13학년", "221번");
		return student;
	}
	
	@Bean
	public Student student2()
	{
		Student student = new Student("홍길순", "21살", "14학년", "111번");
		return student;
	}
	
	@Bean
	public StudentInfo studentInfo()
	{
		StudentInfo studentInfo = new StudentInfo();
		return studentInfo;
	}
	
}
