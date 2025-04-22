package com.lgy.member_oracle_practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository // 이 클래스가 DAO 역할임을 스프링에 알리는 어노테이션
public class MemDAO {
	DataSource dataSource; // 커넥션풀 객체 선언

	public MemDAO() 
	{
		try 
		{
			Context ctx = new InitialContext();
			// context.xml에 등록한 DB 커넥션풀 자원을 lookup으로 찾아서 dataSource에 저장
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) 
		
		{
			e.printStackTrace(); // 에러 발생 시 콘솔에 출력
		}
	}
	
	/**
	 * 로그인 여부를 판단하는 메서드
	 * @param id 사용자가 입력한 아이디
	 * @param pw 사용자가 입력한 비밀번호
	 * @return 로그인 결과 (1=성공, 0=비밀번호 틀림, -1=아이디 없음)
	 */
	public int loginYn(String id, String pw)
	{
		int re = -1; // 결과값 저장용 (기본값: -1 → 아이디 없음)
		String db_mem_pwd; // DB에서 조회한 비밀번호를 저장할 변수

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자가 입력한 아이디로 비밀번호를 조회하는 SQL
		String sql = "select mem_pwd from MVC_MEMBER where mem_uid=?";

		try
		{
			// 커넥션풀로부터 DB 연결 객체 가져오기
			conn = dataSource.getConnection();

			// SQL 쿼리 준비
			pstmt = conn.prepareStatement(sql);

			// ?에 사용자가 입력한 ID를 넣기
			pstmt.setString(1, id);

			// SQL 실행 후 결과 저장 (rs는 select 결과를 담는 객체)
			rs = pstmt.executeQuery();

			// 아이디가 존재하는 경우
			if (rs.next())
			{
				// DB에서 가져온 비밀번호를 변수에 저장
				db_mem_pwd = rs.getString("mem_pwd");

				// DB의 비밀번호와 사용자가 입력한 비밀번호가 일치하면
				if (db_mem_pwd.equals(pw))
				{
					re = 1; // 로그인 성공
				} 
				else
				{
					re = 0; // 아이디는 맞지만 비밀번호 틀림
				}
			} 
			else
			{
				re = -1; // 아이디가 DB에 존재하지 않음
			}

		} 
		catch (Exception e)
		{
			// 예외 발생 시 에러 출력
			e.printStackTrace();
		} 
		finally
		{
			// 사용한 자원 정리 (메모리 누수 방지)
			try
			{
				if (rs != null) rs.close();           // ResultSet 닫기
				if (pstmt != null) pstmt.close();     // PreparedStatement 닫기
				if (conn != null) conn.close();       // Connection 반납
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}

		return re; // 결과값 반환
	}

}
