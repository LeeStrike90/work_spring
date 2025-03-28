package com.lgy.spring_ex6_5;

import java.util.ArrayList;

public class Nasdaq
{
	private String stock;
	private int caprank;
	private ArrayList<String> product;
	
	
	
	public Nasdaq(String stock)
	{
		this.stock = stock;
	}
	public String getStock()
	{
		return stock;
	}
	public void setStock(String stock)
	{
		this.stock = stock;
	}
	public int getCaprank()
	{
		return caprank;
	}
	public void setCaprank(int caprank)
	{
		this.caprank = caprank;
	}
	public ArrayList<String> getProduct()
	{
		return product;
	}
	public void setProduct(ArrayList<String> product)
	{
		this.product = product;
	}
	
}
