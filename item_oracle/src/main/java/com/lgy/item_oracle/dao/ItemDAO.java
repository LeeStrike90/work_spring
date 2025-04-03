package com.lgy.item_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.lgy.item_oracle.dto.ItemDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemDAO
{
	DataSource dataSource;
	
	public ItemDAO()
	{
		try
		{
			Context ctx = new InitialContext();
			// context.xml �� ���� (server.xml �� �޸� �ѹ� �������� ��� ������Ʈ���� ��밡��)
			// dataSource : ��ȸ, ����, ����, ���� ������ ��� ��� ����
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public ArrayList<ItemDTO> list()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name, price, description from product";
		ArrayList<ItemDTO> dtos = new ArrayList<ItemDTO>();
	
		try
		{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 셀렉트문인 경우
//							insert일경우 excuteUpdate가 들어감
	
			while (rs.next())
			{
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				ItemDTO dto = new ItemDTO(name, price, description);
	
				dtos.add(dto);
			}
	
		} catch (Exception e)
		
		{
			// TODO: handle exception
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
		return dtos;
}
}
