package com.lgy.spring_ex6_4;

import java.util.ArrayList;

public class Animation
{
	private String title;
	private int year;
	private ArrayList<String> actor;
	
	
	
	public Animation(String title)
	{
		this.title = title;
	}
	
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public ArrayList<String> getActor()
	{
		return actor;
	}
	public void setActor(ArrayList<String> actor)
	{
		this.actor = actor;
	}
	
	
}
