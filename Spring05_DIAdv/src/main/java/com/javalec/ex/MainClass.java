package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String configStudentLocation = "classpath:studentContext.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(configStudentLocation);
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

		
		
		String configPencilLocation = "classpath:pencilContext.xml";
		context = new GenericXmlApplicationContext(configPencilLocation);
		Pencil myPencil = context.getBean("myPencil", Pencil.class);
		myPencil.use();
		context.close();
	}

}
