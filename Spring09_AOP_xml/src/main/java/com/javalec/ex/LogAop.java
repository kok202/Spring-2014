package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;

// AOP를 위한 프록시
public class LogAop {
	
	
	
	public Object myLoggerAopAdvice(ProceedingJoinPoint joinpoint) throws Throwable{
		String str = joinpoint.getSignature().toShortString();
		System.out.println(str + "is start");
		long startTime = System.currentTimeMillis();
		
		try
		{
			// 핵심 기능을 대신 실행
			System.out.println(str + " proceed is start");
			Object obj = joinpoint.proceed();
			System.out.println(str + " proceed is done!");
			return obj;
		}
		finally 
		{
			long endTime = System.currentTimeMillis();
			System.out.println(str + "is done!");
			System.out.println(str + " 경과 시간 : " + (endTime - startTime));
		}
		
	}
	
	
	
}
