package com.lgy.spring_ex2_5;

public class MultipleTriangle
{
	public static void main(String[] args)
	{
		Multiple multiple =new Multiple();
		Triangle triangle = new Triangle();
		multiple.setNumber(240);
		triangle.setNum1(4);
		triangle.setNum2(3);
		triangle.setNum3(5);
		multiple.process();
		triangle.process();
	}
}
