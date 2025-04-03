package com.lgy.item_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ItemController
{
	@RequestMapping("/item_write")
	public String write(HttpServletRequest request, Model model)
	{
		//log.info("@# write()");
		// request�� boardName, boardTitle, boardContent ������ ����
		model.addAttribute("request", request);

		//service = new BoardWriteService();
		// model�� request�� ��� ����
		//service.excute(model);
		return "item_write";
//		return "redirect:list";
	}

}
