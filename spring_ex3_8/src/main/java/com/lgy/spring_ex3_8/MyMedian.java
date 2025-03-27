package com.lgy.spring_ex3_8;

public class MyMedian
{
	Median median;
	private int Num1, Num2, Num3;
	public void pc()
	{
		median.process(Num1, Num2, Num3);
	}
	
	
	
	public Median getMedian()
	{
		return median;
	}
	public void setMedian(Median median)
	{
		this.median = median;
	}
	public int getNum1()
	{
		return Num1;
	}
	public void setNum1(int num1)
	{
		Num1 = num1;
	}
	public int getNum2()
	{
		return Num2;
	}
	public void setNum2(int num2)
	{
		Num2 = num2;
	}
	public int getNum3()
	{
		return Num3;
	}
	public void setNum3(int num3)
	{
		Num3 = num3;
	}
	
}
