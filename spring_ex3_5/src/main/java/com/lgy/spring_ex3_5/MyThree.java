package com.lgy.spring_ex3_5;

public class MyThree
{
	Three three;
	int number;
	public void process()
	{
		three.process(number);
	}
	
	
	public Three getThree()
	{
		return three;
	}
	public void setThree(Three three)
	{
		this.three = three;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	
}
