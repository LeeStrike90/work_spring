package com.lgy.spring_ex3_4;

public class MyWon2Dollar
{
	Won2Dollar won2Dollar;
	private int won;
	public void exch()
	{
		won2Dollar.exchange(won);
	}
	
	public Won2Dollar getWon2Dollar()
	{
		return won2Dollar;
	}
	public void setWon2Dollar(Won2Dollar won2Dollar)
	{
		this.won2Dollar = won2Dollar;
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
