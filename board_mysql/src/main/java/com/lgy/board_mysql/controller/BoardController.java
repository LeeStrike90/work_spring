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

	// 서비스 인터페이스 참조 변수
	BoardService service;

	// 게시글 목록 조회
	@RequestMapping("/list")
	public String list(Model model)
	{
		log.info("@# list()");

		// 게시글 목록을 조회하는 서비스 호출
		service = new BoardListService();
		service.excute(model); // 결과를 model에 담음

		// list.jsp로 이동
		return "list";
	}

	// 게시글 작성 처리 (폼에서 데이터 전송 시)
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)
	{
		log.info("@# write()");

		// request 객체를 model에 담아서 전달 (Service에서 꺼내서 사용)
		model.addAttribute("request", request);

		// 게시글 작성 서비스 실행
		service = new BoardWriteService();
		service.excute(model);

		// 작성 후 목록 페이지로 리다이렉트
		return "redirect:list";
	}

	// 게시글 작성 폼으로 이동
	@RequestMapping("/write_view")
	public String write_view()
	{
		log.info("@# write_view()");
		// write_view.jsp로 이동
		return "write_view";
	}

	// 게시글 상세보기
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model)
	{
		log.info("@# content_view()");

		// 게시글 번호 등 요청 정보를 model에 담아 서비스로 전달
		model.addAttribute("request", request);

		// 상세보기 서비스 호출
		service = new BoardContentService();
		service.excute(model);

		// content_view.jsp로 이동
		return "content_view";
	}

	// 게시글 수정 처리
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model)
	{
		log.info("@# modify()");

		model.addAttribute("request", request);

		// 게시글 수정 서비스 호출
		service = new BoardModifyService();
		service.excute(model);

		// 수정 후 목록으로 리다이렉트
		return "redirect:list";
	}

	// 게시글 삭제 처리
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model)
	{
		log.info("@# delete()");

		model.addAttribute("request", request);

		// 게시글 삭제 서비스 호출
		service = new BoardDeleteService();
		service.excute(model);

		// 삭제 후 목록으로 리다이렉트
		return "redirect:list";
	}
}
