package com.lgy.spring_ex2_1;

public class Draw
{
	public static void main(String[] args)
	{
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		circle.setR(10);
		rectangle.setWidth(20);
		rectangle.setHeight(30);
		circle.area();
		rectangle.area();
	}
}
