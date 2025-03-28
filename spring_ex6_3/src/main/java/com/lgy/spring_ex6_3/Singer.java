package com.lgy.spring_ex6_3;

import java.util.ArrayList;

public class Singer
{
	private String name;
	private String member;
	private ArrayList<String> title;
	
	
	
	public Singer(String name)
	{
		super();
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
	public String getMember()
	{
		return member;
	}
	public void setMember(String member)
	{
		this.member = member;
	}
	public ArrayList<String> getTitle()
	{
		return title;
	}
	public void setTitle(ArrayList<String> title)
	{
		this.title = title;
	}
	
}
