package com.lgy.item_std_oracle.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.item_std_oracle.dto.ItemDTO;

public interface ItemService {
	public void write(HashMap<String, String> param);
	public ArrayList<ItemDTO> list();
}
