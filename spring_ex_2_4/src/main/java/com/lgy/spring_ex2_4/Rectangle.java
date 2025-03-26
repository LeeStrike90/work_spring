package com.lgy.spring_ex2_4;

public class Rectangle
{
	private int x, y;
	
	public void process()
	{
		if(x>= 100 && x <=200 && y>=100 && y<= 200)
		{
			System.out.println("범위 안에 있다.");
		}
		else
		{
			System.out.println("범위밖에있다.");
		}
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
}
