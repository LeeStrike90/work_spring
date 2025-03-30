package com.lgy.spring_ex8_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass
{
	public static void main(String[] args)
	{
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Professor professor = ctx.getBean("professor",Professor.class);
		professor.getprofessorInfo();

		Singer singer = ctx.getBean("singer",Singer.class);
		singer.getSingerInfo();
		
		ctx.close();
	}
}
