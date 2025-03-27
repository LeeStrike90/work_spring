package com.lgy.spring_ex3_1;

public class MyCircle
{
	public Circle circle;
	public int radius;
	
	public void ar()
	{
		circle.area(radius);
	}

	public Circle getCircle()
	{
		return circle;
	}

	public void setCircle(Circle circle)
	{
		this.circle = circle;
	}

	public int getRadius()
	{
		return radius;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

}
