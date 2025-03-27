package com.lgy.spring_ex3_9;

public class EvenNumber
{
	public void process(int number)
	{
		int sum =0;
		
		for(int i =0; i <= number; i+=2)
		{
			sum = sum + i ;
		}
		System.out.println(sum);
	}
}
