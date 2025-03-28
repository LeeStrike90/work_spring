package com.lgy.spring_7_2;

import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, Dispo
{
	private String name;
	private int age;
	
	
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
