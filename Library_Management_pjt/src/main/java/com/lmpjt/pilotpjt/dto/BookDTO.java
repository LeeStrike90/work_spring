package com.lmpjt.pilotpjt.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	private int bookNumber;
	private String bookTitle;
	private String bookComent;
	private String bookWrite; // 이거 이름 맞는지 주의
	private String bookPub;
	private Date bookDate;
	private String bookMajorCategory;
	private String bookSubCategory;	
	private int bookCount;
	private int bookBorrowcount; 

}
