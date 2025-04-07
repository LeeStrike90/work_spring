package com.lgy.board_std_mysql.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.lgy.board_std_mysql.dao.BoardDAO;
import com.lgy.board_std_mysql.dto.BoardDTO;

public class BoardServiceImpl implements BoardService
{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public ArrayList<BoardDTO> list()
	{
//		BoardDAO dao=new BoardDAO();
		BoardDAO dao= sqlSession.getMapper(BoardDAO.class);
//		ArrayList<BoardDTO> dtos = dao.list();
		ArrayList<BoardDTO> list = dao.list();
//		model.addAttribute("list", dtos);
		return list;
	}

	@Override
//	public void write(String boardName, String boardTitle, String boardContent)
	public void write(HashMap<String, String> param)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String boardName = request.getParameter("boardName");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		BoardDAO dao=new BoardDAO();
		dao.write(boardName, boardTitle, boardContent);

		
	}

	@Override
	public BoardDTO contentView(String strID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(String boardNo, String boardName, String boardTitle, String boardContent)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String strId)
	{
		// TODO Auto-generated method stub
		
	}
	
}
