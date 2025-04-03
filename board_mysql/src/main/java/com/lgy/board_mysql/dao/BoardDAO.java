package com.lgy.board_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.lgy.board_mysql.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

//DB SQL ó��
@Slf4j
public class BoardDAO
{
	DataSource dataSource;

	public BoardDAO()
	{
		// dbcp ������� db ����
		try
		{
			Context ctx = new InitialContext();
			// context.xml �� ���� (server.xml �� �޸� �ѹ� �������� ��� ������Ʈ���� ��밡��)
			// dataSource : ��ȸ, ����, ����, ���� ������ ��� ��� ����
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// �Խ��� ��� ��ȸ(type parameter : �Խñ� ��ü)
	public ArrayList<BoardDTO> list()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next())
			{
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");
				// �ϳ��� �Խñ� ��ü
				BoardDTO dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);

				// �Խñ� �߰�
				dtos.add(dto);
			}

		} catch (Exception e)
		{
			// TODO: handle exception
		} finally
		// �ڿ� �ݳ�
		{
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public void write(String boardName, String boardTitle, String boardContent)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into tbl_board(boardName, boardTitle, boardContent) values(?,?,?)";
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.executeUpdate();

		} catch (Exception e)
		{
			// TODO: handle exception
		} finally
		// �ڿ� �ݳ�
		{
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}

	// �Խñ� �ϳ��� �����ϱ� ���ؼ� BoardDTO ��� (strID : �۹�ȣ)
	public BoardDTO contentView(String strID)
	{
		upHit(strID);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board where boardNo=?";

		BoardDTO dto = null;

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");

				dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void upHit(String boardNo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_board set boardHit=boardHit+1" + " where boardNo=?";

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNo));
			pstmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}

	public void modify(String boardName, String boardTitle, String BoardContent, String boardNo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_board set boardName=?, boardTitle=?, boardContent=?"
				+ " where boardNo=?";

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, BoardContent);
			log.info("@# boardNo=>" +boardNo);
			pstmt.setInt(4, Integer.parseInt(boardNo));  //?? 이거 왜 안됨?
			pstmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	public void delete(String StrID)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_board"
				+ " where boardNo=?";

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(StrID));  //?? 이거 왜 안됨?
			pstmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
}
