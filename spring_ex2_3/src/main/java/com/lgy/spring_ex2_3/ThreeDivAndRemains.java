package com.lgy.spring_ex2_3;

public class ThreeDivAndRemains
{
	public static void main(String[] args)
	{
		Three three = new Three();
		DivAndRemains divAndRemains = new DivAndRemains();
		
		three.setNumber(129);
		divAndRemains.setNumber(77);
		
		three.three();
		divAndRemains.ten();
		
	}
}
