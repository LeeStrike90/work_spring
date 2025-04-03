package com.lgy.board_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_mysql.service.BoardContentService;
import com.lgy.board_mysql.service.BoardDeleteService;
import com.lgy.board_mysql.service.BoardListService;
import com.lgy.board_mysql.service.BoardModifyService;
import com.lgy.board_mysql.service.BoardService;
import com.lgy.board_mysql.service.BoardWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController
{
	BoardService service;

	// �Խ��� ��� ��ȸ
	@RequestMapping("/list")
	public String list(Model model)
	{
		log.info("@# list()");

		// service(command)�� ȣ��
		service = new BoardListService();
		service.excute(model);
		return "list";
	}

	// request : �信�� ���� �޾ƿ�
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)
	{
		log.info("@# write()");
		// request�� boardName, boardTitle, boardContent ������ ����
		model.addAttribute("request", request);

		service = new BoardWriteService();
		// model�� request�� ��� ����
		service.excute(model);

		return "redirect:list";
	}

	@RequestMapping("/write_view")
	public String write_view()
	{
		log.info("@# write_view()");
		return "write_view";
	}

	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model)
	{
		log.info("@# content_view()");
		model.addAttribute("request", request);
		service = new BoardContentService();
		service.excute(model);
		return "content_view";
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model)
	{
		log.info("@# modify()");

		model.addAttribute("request", request);

		service = new BoardModifyService();
		service.excute(model);

		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model)
	{
		log.info("@# delete()");
		model.addAttribute("request", request);
		service = new BoardDeleteService();
		service.excute(model);
		return "redirect:list";
	}


}
