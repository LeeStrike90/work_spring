package com.lgy.spring_ex6_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEmployee
{
	public static void main(String[] args)
	{
		String configLoc1 = "classpath:employeeCTX.xml";
		String configLoc2 = "classpath:employeeCTX2.xml";		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1,configLoc2);
		
		Employee employee1 = ctx.getBean("employee1", Employee.class);
		System.out.println(employee1.getName());
		System.out.println(employee1.getPay());
		System.out.println(employee1.getCerti());
		System.out.println("===================");
		
		Employee employee2 = ctx.getBean("employee1", Employee.class);
		System.out.println(employee2.getName());
		System.out.println(employee2.getPay());
		System.out.println(employee2.getCerti());

		System.out.println("===================");
		Employee employee3 = ctx.getBean("employee3", Employee.class);
		System.out.println(employee3.getName());
		System.out.println(employee3.getPay());
		System.out.println(employee3.getCerti());

		System.out.println("===================");

		
	}
}
