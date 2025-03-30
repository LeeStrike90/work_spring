package com.lgy.spring_ex8_1;

public class Singer
{
	private String name;
	private String song;
	private int member;
	
	public void getSingerInfo()
	{
		System.out.println(getName());
		System.out.println(getMember());
		System.out.println(getSong());
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSong()
	{
		return song;
	}
	public void setSong(String song)
	{
		this.song = song;
	}
	public int getMember()
	{
		return member;
	}
	public void setMember(int member)
	{
		this.member = member;
	}
	
	
}
