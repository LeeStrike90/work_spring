package com.lgy.item_oracle_practice.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_oracle_practice.dao.itemPracticeDAO;
import com.lgy.item_oracle_practice.dto.ItemPracticeDTO;

public class ItemPracticeContentService implements ItemPracticeService
{
	@Override
	public void execute(Model model)
	{
		//dao단 호출
		itemPracticeDAO dao = new itemPracticeDAO();
		//게시글들을 dtos 객체로 받음
		ArrayList<ItemPracticeDTO> dtos = dao.list();
		model.addAttribute("content_view",dtos);
	}
}
