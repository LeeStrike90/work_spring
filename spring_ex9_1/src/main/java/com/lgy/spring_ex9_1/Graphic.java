package com.lgy.spring_ex9_1;

public class Graphic
{
	private String company;
	private int capRank;
	
	public void getGraphicInfo()
	{
		System.out.println(getCompany());
		System.out.println(getCapRank());
	}
	
	public String getCompany()
	{
		return company;
	}
	public void setCompany(String company)
	{
		this.company = company;
	}
	public int getCapRank()
	{
		return capRank;
	}
	public void setCapRank(int capRank)
	{
		this.capRank = capRank;
	}
	
}
