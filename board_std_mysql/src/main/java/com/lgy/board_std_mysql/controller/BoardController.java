package com.lgy.board_std_mysql.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.board_std_mysql.dto.BoardDTO;
import com.lgy.board_std_mysql.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
//	@Autowired
//	private SqlSession sqlSession;
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list()");
		
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		model.addAttribute("list", dao.list());
		ArrayList<BoardDTO> list = service.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/write")
//	public String write(HttpServletRequest request, Model model) {
	public String write(@RequestParam HashMap<String, String> param) {
		log.info("@# write()");
		
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.write(request.getParameter("boardName")
//				, request.getParameter("boardTitle")
//				, request.getParameter("boardContent"));
		service.write(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
//	public String content_view(HttpServletRequest request, Model model) {
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# content_view()");
		
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		model.addAttribute("content_view", dao.contentView(request.getParameter("boardNo")));
		BoardDTO dto = service.contentView(param);
		model.addAttribute("content_view", dto);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
//	public String modify(HttpServletRequest request, Model model) {
	public String modify(@RequestParam HashMap<String, String> param) {
		log.info("@# modify()");
		
//		log.info("@# boardNo=>"+request.getParameter("boardNo"));
//		log.info("@# boardName=>"+request.getParameter("boardName"));
//		log.info("@# boardTitle=>"+request.getParameter("boardTitle"));
//		log.info("@# boardContent=>"+request.getParameter("boardContent"));
//		
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.modify(request.getParameter("boardNo")
//				 , request.getParameter("boardName")
//				 , request.getParameter("boardTitle")
//				 , request.getParameter("boardContent"));
		service.modify(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
//	public String delete(HttpServletRequest request, Model model) {
	public String delete(@RequestParam HashMap<String, String> param) {
		log.info("@# delete()");
		
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.delete(request.getParameter("boardNo"));
		service.delete(param);
		
		return "redirect:list";
	}
}







