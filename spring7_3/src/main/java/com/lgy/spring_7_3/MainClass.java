package com.lgy.spring_7_3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass
{
	public static void main(String[] args)
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student",Student.class);
		
		//이름: 홍길순
		//나이 : 30
		System.out.println("이름 : "+ student1.getName());
		System.out.println("이름 : "+ student1.getAge());
		System.out.println("======================");
		
		Student student2 = ctx.getBean("student",Student.class);
		student2.setName("홍길자");
		student2.setAge(100);
		//이름:홍길자
		//나이 : 100
		System.out.println("이름 : "+ student1.getName());
		System.out.println("이름 : "+ student1.getAge());
		System.out.println("======================");
		
		
//		student1 == sutdent2  
		if(student1.equals(student2))
		{
			System.out.println("student1==student2");
		}
		else
		{
			System.out.println("student1!=student2");
		}
		
		
		
		ctx.close();
	}
}
