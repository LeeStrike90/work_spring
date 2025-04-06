package com.lgy.board_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_mysql.service.BoardContentService; // 게시글 상세보기 처리 서비스
import com.lgy.board_mysql.service.BoardDeleteService; // 게시글 삭제 처리 서비스
import com.lgy.board_mysql.service.BoardListService; // 게시글 목록 조회 서비스
import com.lgy.board_mysql.service.BoardModifyService; // 게시글 수정 처리 서비스
import com.lgy.board_mysql.service.BoardService; // 공통 서비스 인터페이스
import com.lgy.board_mysql.service.BoardWriteService; // 게시글 작성 처리 서비스

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController
{

	// 서비스 인터페이스 참조 변수 (다형성 활용)
	BoardService service;

	/**
	 * 게시글 목록 페이지 요청 URL: /list 동작: 게시글 목록 데이터를 조회해서 list.jsp에 전달
	 */
	@RequestMapping("/list")
	public String list(Model model)
	{
		log.info("@# list()");

		// 게시글 목록 조회 서비스 실행
		service = new BoardListService(); // BoardService를 구현한 클래스
		service.excute(model); // 결과 데이터를 model에 담아서 view로 전달

		// list.jsp로 포워딩
		return "list";
	}

	/**
	 * 게시글 작성 처리 요청 URL: /write 동작: 작성 폼에서 전달된 데이터를 받아 DB에 저장하고 목록 페이지로 이동
	 */
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)
	{
		log.info("@# write()");

		// HttpServletRequest를 model에 추가하여 서비스에서 사용할 수 있게 전달
		model.addAttribute("request", request);

		// 게시글 작성 서비스 실행 (DB에 새 글 저장)
		service = new BoardWriteService();
		service.excute(model);

		// 저장 후 게시글 목록으로 리다이렉트
		return "redirect:list";
	}

	/**
	 * 게시글 작성 폼 요청 URL: /write_view 동작: 사용자에게 게시글 작성 화면을 보여줌
	 */
	@RequestMapping("/write_view")
	public String write_view()
	{
		log.info("@# write_view()");

		// write_view.jsp로 포워딩
		return "write_view";
	}

	/**
	 * 게시글 상세보기 요청 URL: /content_view 동작: 특정 게시글 번호를 받아 상세 내용을 조회하고
	 * content_view.jsp에 전달
	 */
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model)
	{
		log.info("@# content_view()");

		// 요청 정보(model에 request 포함)를 서비스에 전달
		model.addAttribute("request", request);

		// 게시글 상세보기 서비스 실행
		service = new BoardContentService();
		service.excute(model);

		// content_view.jsp로 포워딩
		return "content_view";
	}

	/**
	 * 게시글 수정 처리 요청 URL: /modify 동작: 사용자가 수정한 내용을 받아 DB에 반영한 뒤 목록으로 이동
	 */
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model)
	{
		log.info("@# modify()");

		model.addAttribute("request", request);

		// 게시글 수정 서비스 실행
		service = new BoardModifyService();
		service.excute(model);

		// 수정 후 게시글 목록으로 리다이렉트
		return "redirect:list";
	}

	/**
	 * 게시글 삭제 처리 요청 URL: /delete 동작: 게시글 번호를 받아 해당 글을 삭제한 뒤 목록으로 이동
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model)
	{
		log.info("@# delete()");

		model.addAttribute("request", request);

		// 게시글 삭제 서비스 실행
		service = new BoardDeleteService();
		service.excute(model);

		// 삭제 후 게시글 목록으로 리다이렉트
		return "redirect:list";
	}
}
