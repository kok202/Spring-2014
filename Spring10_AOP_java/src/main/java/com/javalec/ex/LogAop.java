package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// AOP를 위한 프록시
@Aspect
public class LogAop {
	
	// com.javalec.ex.StudentInfo안의 public void show*(0개 이상의 파라미터)
	// 를 포인트 컷으로 만들어라
	@Pointcut("execution(public void com.javalec.ex.StudentInfo.show*(..))")
	private void myPointcutMethod()
	{
		System.out.println("myPointcutMethod is start");
	}
	
	

	//@Around("within(com.javalec.ex.*)")
	@Around("myPointcutMethod()")
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
