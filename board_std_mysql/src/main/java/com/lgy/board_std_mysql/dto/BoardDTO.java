package com.lgy.board_std_mysql.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//롬복의 어노테이션
//@Getter : 모든 필드에 대한 getter 메서드 생성
//
//@Setter : 모든 필드에 대한 setter 메서드 생성
//
//@ToString : toString() 메서드 생성
//
//@EqualsAndHashCode : equals()와 hashCode() 메서드 생성
//
//@RequiredArgsConstructor : final 필드나 @NonNull이 붙은 필드만을 인자로 갖는 생성자 생성
@NoArgsConstructor
@AllArgsConstructor
//모든 필드를 인자로 받는 생성자를 자동으로 만들어줌
public class BoardDTO {
	private int boardNo;
	private String boardName;
	private String boardTitle;
	private String boardContent;
	private Timestamp boardDate;
	private int boardHit;
}
