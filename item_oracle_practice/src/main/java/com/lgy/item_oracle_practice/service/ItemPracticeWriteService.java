package com.lgy.item_oracle_practice.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.item_oracle_practice.dao.itemPracticeDAO;

public class ItemPracticeWriteService implements ItemPracticeService
{
	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		itemPracticeDAO dao = new itemPracticeDAO();
		dao.write(name, price, description);
	}
}
