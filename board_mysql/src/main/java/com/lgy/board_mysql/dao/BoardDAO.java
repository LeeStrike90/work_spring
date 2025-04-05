package com.lgy.board_mysql.dao;

// Java의 JDBC 관련 클래스들
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

// DBCP(DataBase Connection Pool)를 위한 Java 네이밍 관련 클래스
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.board_mysql.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j; // 로그 출력을 위한 Lombok 어노테이션

/**
 * 게시판 DAO 클래스 - DB 접근과 SQL 처리 담당
 * DAO(Data Access Object): 실제로 DB에 접근해서 데이터를 가져오거나, 저장, 수정, 삭제 등을 처리하는 클래스
 */
@Slf4j // Lombok 어노테이션: log.info(), log.debug() 등을 바로 사용할 수 있게 로그 객체 생성
public class BoardDAO 
{
	DataSource dataSource; // 커넥션 풀을 통해 DB 연결을 관리할 객체

	// 생성자: DataSource를 JNDI 방식으로 lookup하여 가져옴
	public BoardDAO() 
	{
		try 
		{
			// context.xml에 설정한 리소스 이름으로 DB 커넥션을 찾아온다
			Context ctx = new InitialContext(); 
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql"); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 전체 목록 조회
	 * @return 게시글 리스트 (ArrayList<BoardDTO>)
	 */
	public ArrayList<BoardDTO> list() {
		Connection conn = null; //데이터베이스의 연결을 담당하는 객체
		PreparedStatement pstmt = null; //SQL문을 컴파일해서 실행할 수 있게 해주는 객체
		ResultSet rs = null; //select 쿼리 결과를 담는 객체 , db로부터 결과 테이블 행 단위로 읽어올 수 있도록 도와줌.
		//또한 반복문을 통해 .next()로 한 행씩 접근
		
		// 게시판 전체 조회 SQL 문장
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";

		// 결과 데이터를 담을 리스트 객체
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();

		try {
				conn = dataSource.getConnection(); // 커넥션 풀에서 DB 연결 객체 가져오기
				pstmt = conn.prepareStatement(sql); // SQL 문장을 DB에 보낼 준비
			
				rs = pstmt.executeQuery(); // SELECT 실행
					
				// 결과셋을 한 줄씩 읽어 BoardDTO 객체로 변환 후 리스트에 추가
				while (rs.next()) 
				{
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
			e.printStackTrace(); // 에러 로그 출력
		} finally {
			// 자원 해제 (DB 연결 끊기)
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos; // 전체 게시글 목록 반환
	}

	/**
	 * 게시글 작성 기능
	 * @param boardName 글쓴이 이름
	 * @param boardTitle 글 제목
	 * @param boardContent 글 내용
	 */
	public void write(String boardName, String boardTitle, String boardContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_board(boardName, boardTitle, boardContent) values(?,?,?)";

		try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql); // INSERT SQL 준비
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				pstmt.executeUpdate(); // DB에 INSERT 실행, write 니까! 

			}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 게시글 상세 조회 + 조회수 증가
	 * @param strID 조회할 게시글 번호 (문자열로 전달됨)
	 * @return 게시글 DTO
	 */
	
	public BoardDTO contentView(String strID) {
		upHit(strID); // 조회수 먼저 증가시킴
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board where boardNo=?";
		BoardDTO dto = null;

		try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(strID)); // 게시글 번호 설정
				rs = pstmt.executeQuery(); // SELECT 실행

				if (rs.next()) 
				{
					// 결과를 DTO 객체로 매핑
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
	 * @param boardNo 조회할 게시글 번호
	 */
	public void upHit(String boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_board set boardHit=boardHit+1 where boardNo=?";

		try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(boardNo));
				pstmt.executeUpdate(); // 조회수 1 증가

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
	 * @param boardNo 게시글 번호
	 * @param boardName 작성자 이름
	 * @param boardTitle 제목
	 * @param BoardContent 내용
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
				log.info("@# boardNo=>" + boardNo); // 로그 출력
				pstmt.setInt(4, Integer.parseInt(boardNo));
				pstmt.executeUpdate(); // UPDATE 실행
			}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 게시글 삭제
	 * @param strID 삭제할 게시글 번호
	 */
	public void delete(String strID)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_board where boardNo=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			pstmt.executeUpdate(); // DELETE 실행
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
