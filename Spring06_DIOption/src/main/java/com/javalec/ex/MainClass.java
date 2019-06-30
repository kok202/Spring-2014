package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentInfo studentInfo;
		Student studentTemp;
		
		studentInfo = context.getBean("studentInfo", StudentInfo.class);
		studentTemp = context.getBean("student1", Student.class);
		studentInfo.setStudent(studentTemp);
		studentInfo.showStudentInfo();
		
		studentTemp = context.getBean("student2", Student.class);
		studentInfo.setStudent(studentTemp);
		studentInfo.showStudentInfo();
		context.close();
		
	}

}
