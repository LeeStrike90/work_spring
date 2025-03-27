package com.lgy.spring_ex3_2;

public class MyRectangle
{
	private Rectangle rectangle;
	private int width, height;
	
	public void ar()
	{
		rectangle.area(width, height);
	}
	
	public Rectangle getRectangle()
	{
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle)
	{
		this.rectangle = rectangle;
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
