package com.lgy.member_oracle_practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository // �� Ŭ������ DAO �������� �������� �˸��� ������̼�
public class MemDAO {
	DataSource dataSource; // Ŀ�ؼ�Ǯ ��ü ����

	public MemDAO() 
	{
		try 
		{
			Context ctx = new InitialContext();
			// context.xml�� ����� DB Ŀ�ؼ�Ǯ �ڿ��� lookup���� ã�Ƽ� dataSource�� ����
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) 
		
		{
			e.printStackTrace(); // ���� �߻� �� �ֿܼ� ���
		}
	}
	
	/**
	 * �α��� ���θ� �Ǵ��ϴ� �޼���
	 * @param id ����ڰ� �Է��� ���̵�
	 * @param pw ����ڰ� �Է��� ��й�ȣ
	 * @return �α��� ��� (1=����, 0=��й�ȣ Ʋ��, -1=���̵� ����)
	 */
	public int loginYn(String id, String pw)
	{
		int re = -1; // ����� ����� (�⺻��: -1 �� ���̵� ����)
		String db_mem_pwd; // DB���� ��ȸ�� ��й�ȣ�� ������ ����

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// ����ڰ� �Է��� ���̵�� ��й�ȣ�� ��ȸ�ϴ� SQL
		String sql = "select mem_pwd from MVC_MEMBER where mem_uid=?";

		try
		{
			// Ŀ�ؼ�Ǯ�κ��� DB ���� ��ü ��������
			conn = dataSource.getConnection();

			// SQL ���� �غ�
			pstmt = conn.prepareStatement(sql);

			// ?�� ����ڰ� �Է��� ID�� �ֱ�
			pstmt.setString(1, id);

			// SQL ���� �� ��� ���� (rs�� select ����� ��� ��ü)
			rs = pstmt.executeQuery();

			// ���̵� �����ϴ� ���
			if (rs.next())
			{
				// DB���� ������ ��й�ȣ�� ������ ����
				db_mem_pwd = rs.getString("mem_pwd");

				// DB�� ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ�� ��ġ�ϸ�
				if (db_mem_pwd.equals(pw))
				{
					re = 1; // �α��� ����
				} 
				else
				{
					re = 0; // ���̵�� ������ ��й�ȣ Ʋ��
				}
			} 
			else
			{
				re = -1; // ���̵� DB�� �������� ����
			}

		} 
		catch (Exception e)
		{
			// ���� �߻� �� ���� ���
			e.printStackTrace();
		} 
		finally
		{
			// ����� �ڿ� ���� (�޸� ���� ����)
			try
			{
				if (rs != null) rs.close();           // ResultSet �ݱ�
				if (pstmt != null) pstmt.close();     // PreparedStatement �ݱ�
				if (conn != null) conn.close();       // Connection �ݳ�
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}

		return re; // ����� ��ȯ
	}

}
