package com.javalec.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:studentContext.xml");
		context.refresh();
		
		StudentInfo studentInfo;
		Student studentTemp1;
		Student studentTemp2;
		Student studentTemp3;
		
		studentTemp1 = context.getBean("student1", Student.class);
		studentInfo = context.getBean("studentInfo", StudentInfo.class);
		studentInfo.setStudent(studentTemp1);
		studentInfo.showStudentInfo();
		
		studentTemp2 = context.getBean("student2", Student.class);
		studentInfo.setStudent(studentTemp2);
		studentInfo.showStudentInfo();
		
		studentTemp3 = context.getBean("student1", Student.class);
		studentTemp3.setName("바뀐다");
		studentInfo.setStudent(studentTemp3);
		studentInfo.showStudentInfo();
		studentInfo.setStudent(studentTemp1);
		studentInfo.showStudentInfo();
		context.close();
		
		
		
		context = new GenericXmlApplicationContext();
		context.load("classpath:studentContext.xml");
		context.refresh();
		studentTemp1 = context.getBean("student1", Student.class);
		studentInfo = context.getBean("studentInfo", StudentInfo.class);
		studentInfo.setStudent(studentTemp1);
		studentInfo.showStudentInfo();
		context.close();
		
	}

}
