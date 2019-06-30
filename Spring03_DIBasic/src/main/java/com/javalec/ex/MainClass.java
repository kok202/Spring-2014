package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass{

	public static void main(String[] args) {
		
		//MyCalculator calc = new MyCalculator();
		//calc.setFirstNum(100);
		//calc.setSecondNum(20);
		//calc.add();
		//calc.sub();
		//calc.mult();
		//calc.div();

		String xmlLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(xmlLocation);
		MyCalculator calc = context.getBean("myCalc", MyCalculator.class);
		calc.setFirstNum(100);
		calc.setSecondNum(20);
		calc.add();
		calc.sub();
		calc.mult();
		calc.div();
		
	}

}
