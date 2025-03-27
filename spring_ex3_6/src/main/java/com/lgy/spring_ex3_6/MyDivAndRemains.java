package com.lgy.spring_ex3_6;

public class MyDivAndRemains
{
	DivAndRemains divAndRemains;
	private int number;
	public void pc()
	{
		divAndRemains.process(number);
	}
	
	public DivAndRemains getDivAndRemains()
	{
		return divAndRemains;
	}
	public void setDivAndRemains(DivAndRemains divAndRemains)
	{
		this.divAndRemains = divAndRemains;
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
