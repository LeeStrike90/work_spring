package com.lgy.spring_ex9_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Car car = ctx.getBean("car", Car.class);
		car.getCarInfo();
		
		Graphic graphic = ctx.getBean("graphic", Graphic.class);
		graphic.getGraphicInfo();
		
		ctx.close();
	}
}






