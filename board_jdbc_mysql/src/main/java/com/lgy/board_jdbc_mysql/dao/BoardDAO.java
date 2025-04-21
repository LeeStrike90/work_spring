package com.lgy.board_jdbc_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lgy.board_jdbc_mysql.dto.BoardDTO;
import com.lgy.board_jdbc_mysql.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardDAO {
	// DataSource dataSource;

	JdbcTemplate template = null;

	public BoardDAO() {
		/*
		 * try { Context ctx = new InitialContext(); dataSource =
		 * (DataSource)ctx.lookup("java:comp/env/jdbc/mysql"); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		template = Constant.template;
	}

	public ArrayList<BoardDTO> list() {
		// ��� 1: ���� ������ ���·� ��ȯ
		return (ArrayList<BoardDTO>) template.query(
				"select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board",
				new BeanPropertyRowMapper(BoardDTO.class));

		/*
		 * // ��� 2: SQL�� ������ ��Ƽ� ���� String sql =
		 * "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board"
		 * ; return (ArrayList<BoardDTO>) template.query(sql, new
		 * BeanPropertyRowMapper(BoardDTO.class));
		 */

		/*
		 * // ��� 3: ���� JDBC ��� Connection conn = null; PreparedStatement pstmt = null;
		 * ResultSet rs = null; String sql =
		 * "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board"
		 * ; ArrayList<BoardDTO> dtos = new ArrayList<>();
		 * 
		 * try { conn = dataSource.getConnection(); pstmt = conn.prepareStatement(sql);
		 * rs = pstmt.executeQuery();
		 * 
		 * while (rs.next()) { int boardNo = rs.getInt("boardNo"); String boardName =
		 * rs.getString("boardName"); String boardTitle = rs.getString("boardTitle");
		 * String boardContent = rs.getString("boardContent"); Timestamp boardDate =
		 * rs.getTimestamp("boardDate"); int boardHit = rs.getInt("boardHit");
		 * 
		 * BoardDTO dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent,
		 * boardDate, boardHit); dtos.add(dto); } } catch (Exception e) {
		 * e.printStackTrace(); } finally { try { if (rs != null) rs.close(); if (pstmt
		 * != null) pstmt.close(); if (conn != null) conn.close(); } catch (Exception
		 * e2) { e2.printStackTrace(); } }
		 * 
		 * return dtos;
		 */
	}

	public void write(final String boardName, final String boardTitle, final String boardContent) {
		// update : jdbc template�� insert ���� (PreparedStatementCreator ���)
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into tbl_board(boardName, boardTitle, boardContent) values(?,?,?)";
				// con : JDBC Connection ��ü
				PreparedStatement pstmt = con.prepareStatement(sql);
				// �Ķ���� ������ final�� �����
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				return pstmt;
			}
		});
	}

	public BoardDTO contentView(String strID) {
		upHit(strID); // ��ȸ�� ����

		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board where boardNo="
				+ strID;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}

	public void upHit(final String boardNo) {
		String sql = "update tbl_board set boardHit=boardHit+1 where boardNo=?";
		// update : ��ȸ�� ���� SQL ���� (PreparedStatementSetter ���)
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(boardNo));
			}
		});
	}

	public void modify(final String boardNo, final String boardName, final String boardTitle,
			final String boardContent) {
		String sql = "update tbl_board set boardName=?, boardTitle=?, boardContent=? where boardNo=?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, boardName);
				ps.setString(2, boardTitle);
				ps.setString(3, boardContent);
				ps.setInt(4, Integer.parseInt(boardNo));
			}
		});
	}

	public void delete(final String strId) 
	{
		String sql = "delete from tbl_board where boardNo=?";
		template.update(sql, new PreparedStatementSetter() 
		{
			@Override
			public void setValues(PreparedStatement ps) throws SQLException 
			{
				ps.setInt(1, Integer.parseInt(strId));
			}
		});
	}
}
