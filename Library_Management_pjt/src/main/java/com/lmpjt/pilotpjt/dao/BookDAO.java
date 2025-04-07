package com.lmpjt.pilotpjt.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmpjt.pilotpjt.dto.BookDTO;

public interface BookDAO {
//	public int insertBook(@Param("book")BookDTO book, int admin); 
//	public int updateBook(BookDTO book, int admin);
//	public List<BookDTO> mainBookInfo();
//	public List<BookDTO> searchBookInfo();
	public void insertBook(HashMap<String, String> param); 
	public void updateBook(HashMap<String, String> param);
	public List<BookDTO> mainBookInfo();
	public List<BookDTO> searchBookInfo();
}
