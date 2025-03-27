package com.lgy.spring_ex3_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCircle
{
	public static void main(String[] args)
	{
		String configLoc = "classpath:circleCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyCircle myCircle = ctx.getBean("myCircle", MyCircle.class);
		myCircle.ar();
	}
}
