package com.lgy.board_std_mysql.controller;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
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
//		model.addAttribute("request", request);
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.write(request.getParameter("boardName"), request.getParameter("boardTitle"), request.getParameter("boardContent"));
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
		
//		model.addAttribute("request", request);
		
//		service=new BoardContentService();
//		service.excute(model);
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
//		model.addAttribute("content_view", dao.contentView(request.getParameter("boardNo")));
		BoardDTO dto = service.contentView(param);
		model.addAttribute("content_view", dto);

		return "content_view";
	}
	
	@RequestMapping("/modify")
//	public String modify(HttpServletRequest request, Model model) {
	public String modify(@RequestParam HashMap<String, String> param) {
		log.info("@# modify()");
//		model.addAttribute("request", request);
//		service=new BoardModifyService();
//		service.excute(model);
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스단에서 처리했던 것을 컨트롤러 단에서 처리
//		dao.modify(request.getParameter("boardNo"), 
//				request.getParameter("boardName"),
//				request.getParameter("boardTitle"),
//				request.getParameter("boardContent"));
		service.modify(param);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
//	public String delete(HttpServletRequest request, Model model) {
	public String delete(@RequestParam HashMap<String, String> param) {
		log.info("@# delete()");
		
//		model.addAttribute("request", request);
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.delete(request.getParameter("boardNo"));
		service.delete(param);
		
		return "redirect:list";
	}
}






