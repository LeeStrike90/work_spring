package com.lgy.spring_ex2_2;

public class Won2dollar
{
	private int won;
	
	public void exchange()
	{
		System.out.println("$"+won/1200.0);
	}

	public int getWon()
	{
		return won;
	}

	public void setWon(int won)
	{
		this.won = won;
	}
	
}
