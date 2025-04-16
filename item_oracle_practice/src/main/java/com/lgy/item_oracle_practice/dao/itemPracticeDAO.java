package com.lgy.item_oracle_practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.item_oracle_practice.dto.ItemPracticeDTO;

//dbcp 방식
public class itemPracticeDAO
{
	DataSource dataSource;

	public itemPracticeDAO()
	{
		try
		{
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void write(String NAME, String PRICE, String DESCRIPTION)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ITEM(NAME, PRICE" + ", DESCRIPTION) values(?,?,?)";

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NAME);
			pstmt.setString(2, PRICE);
			pstmt.setString(3, DESCRIPTION);
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
			}

			catch (Exception e2)

			{
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<ItemPracticeDTO> list()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select NAME, PRICE, DESCRIPTION from ITEM";
		ArrayList<ItemPracticeDTO> dtos = new ArrayList<>();

		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next())
			{
				String NAME = rs.getString("NAME");
				int PRICE = rs.getInt("PRICE");
				String DESCRIPTION = rs.getString("DESCRIPTION");

				// 하나의 게시글 객체
				ItemPracticeDTO dto = new ItemPracticeDTO(NAME, PRICE, DESCRIPTION);
//			게시글을 추가(dtos : 여러 게시글이 될수 있음)
				dtos.add(dto);
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
			}

			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return dtos;
	}

}
