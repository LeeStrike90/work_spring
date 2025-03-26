package com.lgy.spring_3_1;

public class MyCalculator
{
	private Calculator calculator;
	private int firstNum;
	private int secondNum;
	
	public void add()
	{
		calculator.addition(firstNum, secondNum);
	}
	public void sub()
	{
		calculator.subtraction(firstNum, secondNum);
	}
	public void mul()
	{
		calculator.multiplication(firstNum, secondNum);
	}
	public void div()
	{
		calculator.division(firstNum, secondNum);
	}
	
	Calculator getCalculator()
	{
		return calculator;
	}
	void setCalculator(Calculator calculator)
	{
		this.calculator = calculator;
	}
	int getFirstNum()
	{
		return firstNum;
	}
	void setFirstNum(int firstNum)
	{
		this.firstNum = firstNum;
	}
	int getSecondNum()
	{
		return secondNum;
	}
	void setSecondNum(int secondNum)
	{
		this.secondNum = secondNum;
	}
}
