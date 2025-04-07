package com.lgy.board_std_mysql.service;
import java.util.ArrayList;
import com.lgy.board_std_mysql.dto.BoardDTO;

public interface BoardService 
{
	public ArrayList<BoardDTO> list();
	public void write( String boardName,  String boardTitle,  String boardContent);
	public BoardDTO contentView(String strID);
	public void modify( String boardNo, String boardName, String boardTitle, String boardContent);
	public void delete( String strId);
}
