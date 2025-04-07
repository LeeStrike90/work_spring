package com.lgy.board_std_mysql.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.board_std_mysql.dto.BoardDTO;

public interface BoardDAO {
	public ArrayList<BoardDTO> list();
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}















