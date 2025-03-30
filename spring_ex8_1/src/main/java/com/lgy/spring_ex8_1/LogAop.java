package com.lgy.spring_ex8_1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop
{
	public Object LoggerAop(ProceedingJoinPoint joinPoint)
	{
		String signatureSTR = joinPoint.getSignature().toShortString();
		System.out.println("@@@## start=>"+signatureSTR);
		Object obj = null;
		try
		{
			obj = joinPoint.proceed();
		} catch (Throwable e)
		{
			e.printStackTrace();
		} 
		
		finally
		{
			System.out.println("@@@## end=>"+signatureSTR);
			
		}
		return obj;
		
	}
}
