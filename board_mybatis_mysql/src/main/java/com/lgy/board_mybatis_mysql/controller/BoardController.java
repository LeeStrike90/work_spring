package com.lgy.board_mybatis_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_mybatis_mysql.dao.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	/*
	 * BoardService service; public JdbcTemplate template;
	 * 
	 * // servlet-context.xml �뿉 �엳�뒗 template 媛앹껜瑜� ���옣(this.template)
	 * 
	 * @Autowired public void setTemplate(JdbcTemplate template) { this.template =
	 * template; // Constant.template 瑜� dao �뿉�꽌 �궗�슜 Constant.template =
	 * this.template; }
	 */

//	servlet-context�뿉 �엳�뒗 sqlSession 媛앹껜 �뿰寃�
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list()");

//		service=new BoardListService();
//		service.excute(model);

//		getMapper = dao 濡� �뿰寃�
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		�꽌鍮꾩뒪�떒�뿉�꽌 泥섎━�뻽�뜕 寃껋쓣 而⑦듃濡ㅻ윭 �떒�뿉�꽌 泥섎━
		model.addAttribute("list", dao.list());

		return "list";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write()");

		model.addAttribute("request", request);

//		service=new BoardWriteService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		�꽌鍮꾩뒪�떒�뿉�꽌 泥섎━�뻽�뜕 寃껋쓣 而⑦듃濡ㅻ윭 �떒�뿉�꽌 泥섎━
		dao.write(request.getParameter("boardName"), request.getParameter("boardTitle"),
				request.getParameter("boardContent"));

		return "redirect:list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");

		return "write_view";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view()");

		model.addAttribute("request", request);

//		service=new BoardContentService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		�꽌鍮꾩뒪�떒�뿉�꽌 泥섎━�뻽�뜕 寃껋쓣 而⑦듃濡ㅻ윭 �떒�뿉�꽌 泥섎━
		model.addAttribute("content_view", dao.contentView(request.getParameter("boardNo")));

		return "content_view";
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify()");

		model.addAttribute("request", request);

//		service=new BoardModifyService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		�꽌鍮꾩뒪�떒�뿉�꽌 泥섎━�뻽�뜕 寃껋쓣 而⑦듃濡ㅻ윭 �떒�뿉�꽌 泥섎━
		dao.modify(request.getParameter("boardNo"), request.getParameter("boardName"),
				request.getParameter("boardTitle"), request.getParameter("boardContent"));

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete()");

		model.addAttribute("request", request);

//		service=new BoardDeleteService();
//		service.excute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		�꽌鍮꾩뒪�떒�뿉�꽌 泥섎━�뻽�뜕 寃껋쓣 而⑦듃濡ㅻ윭 �떒�뿉�꽌 泥섎━
		dao.delete(request.getParameter("boardNo"));

		return "redirect:list";
	}
}
