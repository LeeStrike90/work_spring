package com.lgy.spring_ex5_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainCircle
{
	public static void main(String[] args)
	{
		 String configLoc = "classpath:circleCTX.xml";
	        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
	        
	        CircleInfo circleInfo = ctx.getBean("circleInfo", CircleInfo.class);
	        circleInfo.getCircleInfo(); // 생성자 주입으로 이미 셋팅된 정보 출력

	        ctx.close();

	}
}
