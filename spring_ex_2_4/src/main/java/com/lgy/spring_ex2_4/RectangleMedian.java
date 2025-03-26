package com.lgy.spring_ex2_4;

public class RectangleMedian
{
	public static void main(String[] args)
	{
		Rectangle rectangle = new Rectangle();
		Median median = new Median();
		rectangle.setX(150);
		rectangle.setY(150);
		median.setNum1(20);
		median.setNum2(100);
		median.setNum3(33);
		
		rectangle.process();
		median.middlenum();
	}
}
