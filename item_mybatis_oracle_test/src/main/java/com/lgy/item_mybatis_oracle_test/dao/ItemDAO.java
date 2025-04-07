package com.lgy.item_mybatis_oracle_test.dao;

import java.util.ArrayList;



public interface ItemDAO {
	public void write(String NAME, String PRICE, String DESCRIPTION);
	public ArrayList<ItemDAO> list();
		

}
