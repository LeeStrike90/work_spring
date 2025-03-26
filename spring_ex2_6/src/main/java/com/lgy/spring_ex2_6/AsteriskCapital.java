package com.lgy.spring_ex2_6;

public class AsteriskCapital
{
	public static void main(String[] args)
	{
		Asterisk asterisk = new Asterisk();
		
		asterisk.setNumber(5);
		asterisk.process();
		Capital capital = new Capital();
		capital.setStr("F");
		capital.process();
	}
}

