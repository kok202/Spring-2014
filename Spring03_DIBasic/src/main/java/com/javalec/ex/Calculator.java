package com.javalec.ex;

public class Calculator 
{
	
	public void addition(int firstNum, int secondNum){
		System.out.println("add : " + (firstNum + secondNum) );
	}
	
	public void substitution(int firstNum, int secondNum){
		System.out.println("sub : " + (firstNum - secondNum) );
	}
	
	public void multiply(int firstNum, int secondNum){
		System.out.println("mult : " + (firstNum * secondNum) );
	}
	
	public void divide(int firstNum, int secondNum){
		System.out.println("div : " + (firstNum / secondNum) );
	}
}
