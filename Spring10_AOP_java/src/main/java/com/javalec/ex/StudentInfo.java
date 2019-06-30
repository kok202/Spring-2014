package com.javalec.ex;

import javax.annotation.*;

public class StudentInfo {

	private Student student;

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void showStudentInfo()
	{
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println(student.getGradeNum());
		System.out.println(student.getClassNum() + "\n");
	}

	/* AOP에서 publicM에 대해서 실행한다 되있어서 해당 콜백 메소드가 있으면 에러가 남
	   생성자가 proxy를 반환 하게됨
	@PostConstruct
	public void myInitMethod()
	{
		System.out.println("StudentInfo Bean의 생성!");
	}
	
	@PreDestroy
	public void myDestroyMethod()
	{
		System.out.println("StudentInfo Bean의 생성!");
	}
	*/
}
