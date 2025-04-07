package com.lgy.board_std_mysql.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.board_std_mysql.dao.BoardDAO;
import com.lgy.board_std_mysql.dto.BoardDTO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<BoardDTO> list() {
//		BoardDAO dao=new BoardDAO();
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
//		ArrayList<BoardDTO> dtos = dao.list();
		ArrayList<BoardDTO> list = dao.list();
//		model.addAttribute("list", dtos);
		return list;
	}

	@Override
	public void write(HashMap<String, String> param) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		
//		String boardName = request.getParameter("boardName");
//		String boardTitle = request.getParameter("boardTitle");
//		String boardContent = request.getParameter("boardContent");
		
//		BoardDAO dao=new BoardDAO();
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
//		dao.write(boardName, boardTitle, boardContent);
		dao.write(param);
	}
	
	@Override
	public BoardDTO contentView(HashMap<String, String> param) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		String boardNo = request.getParameter("boardNo");
		
//		BoardDAO dao=new BoardDAO();
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
//		BoardDTO dto = dao.contentView(boardNo);
		BoardDTO dto = dao.contentView(param);
//		model.addAttribute("content_view", dto);
		
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		
//		String boardNo = request.getParameter("boardNo");
//		String boardName = request.getParameter("boardName");
//		String boardTitle = request.getParameter("boardTitle");
//		String boardContent = request.getParameter("boardContent");
		
//		BoardDAO dao=new BoardDAO();
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
//		dao.modify(boardNo, boardName, boardTitle, boardContent);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		
//		String boardNo = request.getParameter("boardNo");
		
//		BoardDAO dao=new BoardDAO();
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
//		dao.delete(boardNo);
		dao.delete(param);
	}

}




