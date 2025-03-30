package com.lgy.spring_7_2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean
{
	private String name;
	private int age;
	
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("@# afterPropertiesSet()");
	}
	@Override
	public void destroy() throws Exception
	{
		System.out.println("@# destroy()");
	}
	
	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	
}
