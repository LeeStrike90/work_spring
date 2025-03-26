package com.lgy.spring_ex2_1;

public class Rectangle
{
	private int width;
	private int height;
	
	public void area()
	{
		System.out.println(width*height);
	}
	
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	
}
