package com.lgy.spring_8_1;

import org.aspectj.lang.ProceedingJoinPoint;

//공통기능클래스 (Aspect)
public class LogAop
{
	//logerAop: advice(공통기능 자체 - 메소드)
	//joinPoint : 핵심기능(공통기능이 적용되는 대상-메소드)
	public Object LoggerAop(ProceedingJoinPoint joinPoint)
	{
		//getSignature().toShortString() : 핵심기능 클래스의 메소드 정보를 가지고옴.
		String signatureSTR = joinPoint.getSignature().toShortString();
		//핵심기능이 start되었다.(공통기능 실행(advise)
		System.out.println(signatureSTR+ "is start.");
		long st = System.currentTimeMillis();
		Object obj = null;
		
		
		//핵심기능 실행
		try
		{
			obj = joinPoint.proceed(); //예외처리 추가
		} catch (Throwable e)
		{
			e.printStackTrace();
		} 
		
		finally
		{
			long et = System.currentTimeMillis();
			System.out.println(signatureSTR+ "is finished.");
			System.out.println(signatureSTR+ "의 경과시간 :" +(et-st));
			
		}
		return obj; //핵심기능 반환
		
	}
}
