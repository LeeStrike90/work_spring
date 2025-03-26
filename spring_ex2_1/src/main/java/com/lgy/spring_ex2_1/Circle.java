package com.lgy.spring_ex2_1;

public class Circle
{
	private int r;
	public void area()
	{
		System.out.println(r*r*3.14);
		
	}
	
	public int getR()
	{
		return r;
	}

	public void setR(int r)
	{
		this.r = r;
	}
}
