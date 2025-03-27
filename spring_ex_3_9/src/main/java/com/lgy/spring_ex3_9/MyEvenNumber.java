package com.lgy.spring_ex3_9;

public class MyEvenNumber
{
	EvenNumber evenNumber;
	private int number;
	
	public void pc()
	{
		evenNumber.process(number);
	}
	
	public EvenNumber getEvenNumber()
	{
		return evenNumber;
	}
	public void setEvenNumber(EvenNumber evenNumber)
	{
		this.evenNumber = evenNumber;
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
