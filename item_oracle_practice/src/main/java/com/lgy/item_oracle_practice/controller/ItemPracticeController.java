package com.lgy.item_oracle_practice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_oracle_practice.service.ItemPracticeContentService;
import com.lgy.item_oracle_practice.service.ItemPracticeService;
import com.lgy.item_oracle_practice.service.ItemPracticeWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemPracticeController
{
	ItemPracticeService service;
	
	@RequestMapping("/content_view")
	public String content_view(Model model)
	{
		service = new ItemPracticeContentService();
		service.execute(model);
		
		return "content_view";
	
	}
	
	@RequestMapping("write_result")
	public String write(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		service = new ItemPracticeWriteService();
		service.execute(model);
		return "write_result";
	}
	
	@RequestMapping("/write_view")
	public String write_view()
	{
		return "item_write";
	}
	
}
