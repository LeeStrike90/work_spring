package com.lgy.spring_7_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass
{
	public static void main(String[] args)
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//스프링설정 (xml 스프링 설정파일 로딩
		ctx.load("classpath:applicationCTX.xml");
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]
//				INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@442675e1: startup date [Fri Mar 28 14:48:36 KST 2025]; root of context hierarchy
//				INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2b4bac49: defining beans [student]; root of factory hierarchy
//				이름 : 홍길순
//				나이 : 30
//				INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@442675e1: startup date [Fri Mar 28 14:48:36 KST 2025]; root of context hierarchy
//				INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2b4bac49: defining beans [student]; root of factory hierarchy
		
		ctx.refresh();
//		새로고침(설정 반영) : 생략해도 객체 정보 출력에는 문제없음
	
		Student student = ctx.getBean("student",Student.class);
		
		System.out.println("이름 : "+student.getName());
		System.out.println("나이 : "+student.getAge());
		
		ctx.close();
		
	}
}
