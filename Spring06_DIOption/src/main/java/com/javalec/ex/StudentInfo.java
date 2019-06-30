package com.javalec.ex;

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
}
