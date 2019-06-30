package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public Student()
	{
		
	}
	
	public Student(String name, String age, String gradeNum, String classNum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getGradeNum() {
		return gradeNum;
	}
	
	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}
	
	public String getClassNum() {
		return classNum;
	}
	
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Student Bean의 생성!");
		
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Student Bean의 소멸!");
		
	}
	
	
	
}
