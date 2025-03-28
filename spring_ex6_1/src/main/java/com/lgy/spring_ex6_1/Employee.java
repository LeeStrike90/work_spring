package com.lgy.spring_ex6_1;

import java.util.ArrayList;

public class Employee
{
	private String name;
	private int pay;
	private ArrayList<String> certi;
	
	
	public Employee(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getPay()
	{
		return pay;
	}
	public void setPay(int pay)
	{
		this.pay = pay;
	}
	public ArrayList<String> getCerti()
	{
		return certi;
	}
	public void setCerti(ArrayList<String> certi)
	{
		this.certi = certi;
	}
	
	
}
