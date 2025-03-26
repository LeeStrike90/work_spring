package com.lgy.spring_ex2_3;

public class Three
{
	private int number;
	
	public void three()
	{
		if(number % 3 == 0)
		{
			System.out.println("3의배수");
		}
		else
		{
			System.out.println("아입니다.");
		}
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
