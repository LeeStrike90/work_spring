package com.lgy.board_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.board_mysql.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 게시판 DAO 클래스 - DB 접근과 SQL 처리 담당
 */
@Slf4j
public class BoardDAO {
	DataSource dataSource;

	// 생성자: DBCP를 통해 커넥션 풀에서 DataSource를 얻어옴
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			// context.xml의 <Resource name="jdbc/mysql">와 일치해야 함
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 전체 목록 조회
	 * @return 게시글 리스트 (ArrayList<BoardDTOㄱ>)
	 */
	public ArrayList<BoardDTO> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");

				// 게시글 DTO 생성 후 리스트에 추가
				BoardDTO dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	/**
	 * 게시글 작성
	 */
	public void write(String boardName, String boardTitle, String boardContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_board(boardName, boardTitle, boardContent) values(?,?,?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 게시글 상세 조회 (조회수 증가 포함)
	 */
	public BoardDTO contentView(String strID) {
		upHit(strID);  // 조회수 증가
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board where boardNo=?";
		BoardDTO dto = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");

				dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * 게시글 조회수 증가
	 */
	public void upHit(String boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_board set boardHit=boardHit+1 where boardNo=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNo));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 게시글 수정
	 */
	public void modify(String boardNo, String boardName, String boardTitle, String BoardContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_board set boardName=?, boardTitle=?, boardContent=? where boardNo=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, BoardContent);
			log.info("@# boardNo=>" + boardNo);
			pstmt.setInt(4, Integer.parseInt(boardNo));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 게시글 삭제
	 */
	public void delete(String strID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_board where boardNo=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}