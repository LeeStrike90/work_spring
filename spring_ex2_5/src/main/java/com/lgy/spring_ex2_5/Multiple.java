package com.lgy.spring_ex2_5;

public class Multiple
{
	private int number;
	
	public void process()
	{
		if(number % 3 == 0)
		{
			System.out.println("3의배수이다.");
		}
		if(number % 5 == 0)
		{
			System.out.println("5의배수이다.");
		}
		if(number % 8 == 0)
		{
			System.out.println("8의배수이다.");
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
