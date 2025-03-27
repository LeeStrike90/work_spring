package com.lgy.spring_ex3_10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainCapital
{
	public static void main(String[] args)
	{
		String configLoc = "classpath:capitalCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyCapital myCapital = ctx.getBean("myCapital", MyCapital.class);
		myCapital.alpha();

	}
}
