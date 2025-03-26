package com.lgy.spring_ex2_3;

public class DivAndRemains
{
	private int number;
	
	public void ten()
	{
		
		if(number % 10 == number/10)
			
		{
			System.out.println("10의자리숫자와 1의자리숫자가 같음");
		}
		
		else
		{
			System.out.println("10의자리숫자와 1의자리숫자가 다름");
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
