package com.lgy.spring_ex2_6;
public class Asterisk
{
	private int number;
	
	public void process()
	{
		for(int i=number; i> 0 ; i --)
		{
			StringBuffer strBuf = new StringBuffer();
			
			for(int j =0; j < i; j++)
			{
				strBuf.append('*');
			}
			System.out.println(strBuf);
		}
	}
	
	int getNumber()
	{
		return number;
	}
	void setNumber(int number)
	{
		this.number = number;
	}
}
