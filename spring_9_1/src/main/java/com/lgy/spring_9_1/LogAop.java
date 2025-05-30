package com.lgy.spring_9_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
//공통기능 클래스(Aspect)
public class LogAop {
	@Pointcut("within(com.lgy.spring_9_1.*)")
//	loggerAop: advice(공통기능 자체-메소드)
	private void pointCutMethod() {}
	
	@Around("pointCutMethod()")
//	joinPoint: 핵심기능(공통기능이 적용되는 대상-메소드)
	public Object loggerAop(ProceedingJoinPoint joinPoint) {
//		getSignature().toShortString() : 핵심기능 클래스의 메소드 정보를 가지고 옴
		String signatureStr = joinPoint.getSignature().toShortString();
//		핵심기능이 start 되었다.(공통기능 실행(advice))
		System.out.println(signatureStr+"is start.");
		long st = System.currentTimeMillis();
		Object obj=null;
		
		try {
			//핵심기능 실행
			joinPoint.proceed();//예외처리 추가
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			System.out.println(signatureStr+"is finished.");
		}
		
		return obj;//핵심기능 반환
	}
}








