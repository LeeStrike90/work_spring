package com.lgy.spring_ex3_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainRectangle
{
	public static void main(String[] args)
	{
		String configLoc = "classpath:rectangleCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyRectangle myRectangle = ctx.getBean("myRectangle", MyRectangle.class);
		myRectangle.ar();

	}
}
