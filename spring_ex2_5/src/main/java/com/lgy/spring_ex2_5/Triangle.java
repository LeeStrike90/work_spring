package com.lgy.spring_ex2_5;

public class Triangle
{
	private int num1,num2, num3;
	
	public void process()
	{
		if((num1 + num2) < num3 ||(num1 + num3) < num2 || (num2 + num3) < num1)
		{
			System.out.println("삼각형불가능");
		}
		else
		{
			System.out.println("삼각형가능");
		}

	}
	

	public int getNum1()
	{
		return num1;
	}

	public void setNum1(int num1)
	{
		this.num1 = num1;
	}

	public int getNum2()
	{
		return num2;
	}

	public void setNum2(int num2)
	{
		this.num2 = num2;
	}

	public int getNum3()
	{
		return num3;
	}

	public void setNum3(int num3)
	{
		this.num3 = num3;
	}
	
}
