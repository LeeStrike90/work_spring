package com.lgy.spring_ex2_6;

public class Capital
{
	private String str;

	public void process() 
	{
		StringBuffer strBuf = new StringBuffer();
		char c = 'A';
		char c2 = str.charAt(0);
		
		for(char i = c2; i >= c; i--) 
		{
			for(char j = c; j <= i; j++) 
			{
				strBuf.append(j);
			}
		strBuf.append("\n");
		}
		System.out.println(strBuf);
	}

	public String getStr() 
	{
		return str;
	}

	public void setStr(String str) 
	{
		this.str = str;
	}
}
