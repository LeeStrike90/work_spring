package com.lgy.spring_ex6_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainProfessor
{
	public static void main(String[] args)
	{
		String configLoc1 = "classpath:professorCTX.xml";
		String configLoc2 = "classpath:professorCTX2.xml";		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1,configLoc2);
		
		Professor professor1 = ctx.getBean("professor1", Professor.class);
		System.out.println(professor1.getName());
		System.out.println(professor1.getAge());
		System.out.println(professor1.getSubject());
		System.out.println("===================");
		
		ProfessorInfo professorInfo = ctx.getBean("professorInfo1", ProfessorInfo.class);
		Professor professor2 = professorInfo.getProfessor();
		System.out.println(professor2.getName());
		System.out.println(professor2.getAge());
		System.out.println(professor2.getSubject());
		System.out.println("===================");
		
		Professor professor3 = ctx.getBean("professor3", Professor.class);
		System.out.println(professor3.getName());
		System.out.println(professor3.getAge());
		System.out.println(professor3.getSubject());
		System.out.println("===================");
		
	}
}
