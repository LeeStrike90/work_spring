package com.lgy.board_mysql.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.board_mysql.dao.BoardDAO;
import com.lgy.board_mysql.dto.BoardDTO;

/**
 * 게시글 상세보기 서비스 클래스 - 게시글 번호(boardNo)를 받아 해당 글의 상세 내용을 조회하고 Model 객체에 DTO를 담아 뷰에
 * 전달함
 */
public class BoardContentService implements BoardService
{

	@Override
	public void excute(Model model)
	{
		// Model에 담긴 객체들을 Map으로 변환
		Map<String, Object> map = model.asMap();

		// 컨트롤러에서 전달된 HttpServletRequest 객체 꺼내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 요청 파라미터에서 게시글 번호(boardNo) 가져오기
		String boardNo = request.getParameter("boardNo");

		// DAO를 통해 해당 게시글 번호의 게시글 데이터를 조회
		BoardDAO dao = new BoardDAO();

		// 게시글 하나의 상세 정보를 담은 DTO 반환
		BoardDTO dto = dao.contentView(boardNo);

		// 모델에 게시글 DTO를 "content_view"라는 이름으로 추가 (JSP에서 사용 가능)
		model.addAttribute("content_view", dto);
	}
}
