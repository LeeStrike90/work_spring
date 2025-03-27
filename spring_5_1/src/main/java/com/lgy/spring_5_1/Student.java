package com.lgy.spring_5_1;

public class Student
{
	private String name;
	private String age;
	private String gradeNum;
	private String ClassNum;
	
	public Student(String name, String age, String gradeNum, String classNum)
	{
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		ClassNum = classNum;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getGradeNum()
	{
		return gradeNum;
	}
	public void setGradeNum(String gradeNum)
	{
		this.gradeNum = gradeNum;
	}
	public String getClassNum()
	{
		return ClassNum;
	}
	public void setClassNum(String classNum)
	{
		ClassNum = classNum;
	}
	
}
