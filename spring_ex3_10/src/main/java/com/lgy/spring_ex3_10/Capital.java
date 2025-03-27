package com.lgy.spring_ex3_10;

public class Capital
{
	public void process(char alphabet) 
	{
		int end = alphabet - 'A' + 1;
		for (int i = end; i >= 1; i--)
		{
			for (int j = 0; j < i; j++) 
			{
				System.out.print((char) ('A' + j));
			}
			System.out.println();
		}
	}
}

