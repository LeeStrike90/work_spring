package com.lgy.spring_ex3_9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainEvenNumber
{
	public static void main(String[] args)
	{
		String configLoc = "classpath:MyEvenNumber.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyEvenNumber myEvenNumber = ctx.getBean("myEvenNumber", MyEvenNumber.class);
		myEvenNumber.pc();
	}
}
