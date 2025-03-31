package com.lgy.spring_ex9_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LogAop 
{
	@Pointcut("within(com.lgy.spring_ex9_1.*)")
	private void pointCutMethod() {}
	@Around("pointCutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println("@@@ ### start"+signatureStr);
		long st = System.currentTimeMillis();
		Object obj=null;
		try 
		{
			//핵심기능 실행
			joinPoint.proceed();//예외처리 추가
		} 
		
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			System.out.println("@@@ ### end"+signatureStr);
		}
		return obj;//핵심기능 반환
	}
}
