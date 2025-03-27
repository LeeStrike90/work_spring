package com.lgy.spring_ex3_10;

public class MyCapital
{
	Capital capital;
	private char alphabet;
	public void alpha()
	{
		capital.process(alphabet);
	}
	
	public Capital getCapital()
	{
		return capital;
	}
	public void setCapital(Capital capital)
	{
		this.capital = capital;
	}
	public char getAlphabet()
	{
		return alphabet;
	}
	public void setAlphabet(char alphabet)
	{
		this.alphabet = alphabet;
	}
	
}
