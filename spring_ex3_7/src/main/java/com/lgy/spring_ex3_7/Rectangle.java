package com.lgy.spring_ex3_7;

public class Rectangle
{
	public void process(int x, int y)
	{
		if(x>=100 && x<=200 && y>=100 && y<=200)
		{
			System.out.println("범위 내에 있읍니다.");
		}
		
		else
		{
			System.out.println("범위 밖에 있읍니다.");
		}
	}
}
