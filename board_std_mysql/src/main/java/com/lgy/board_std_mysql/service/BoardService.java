package com.lgy.board_std_mysql.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.board_std_mysql.dto.BoardDTO;

public interface BoardService {
	public ArrayList<BoardDTO> list();
//	public void write(String boardName, String boardTitle, String boardContent);
	public void write(HashMap<String, String> param);
//	public BoardDTO contentView(String strID);
	public BoardDTO contentView(HashMap<String, String> param);
//	public void modify(String boardNo, String boardName, String boardTitle, String boardContent);
	public void modify(HashMap<String, String> param);
//	public void delete(String strID);
	public void delete(HashMap<String, String> param);
}
