package com.lgy.board_mysql.dao;

// Java�쓽 JDBC 愿��젴 �겢�옒�뒪�뱾
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

// DBCP(DataBase Connection Pool)瑜� �쐞�븳 Java �꽕�씠諛� 愿��젴 �겢�옒�뒪
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.board_mysql.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j; // 濡쒓렇 異쒕젰�쓣 �쐞�븳 Lombok �뼱�끂�뀒�씠�뀡

/**
 * 寃뚯떆�뙋 DAO �겢�옒�뒪 - DB �젒洹쇨낵 SQL 泥섎━ �떞�떦 DAO(Data Access Object): �떎�젣濡� DB�뿉
 * �젒洹쇳빐�꽌 �뜲�씠�꽣瑜� 媛��졇�삤嫄곕굹, ���옣, �닔�젙, �궘�젣 �벑�쓣 泥섎━�븯�뒗 �겢�옒�뒪
 */
@Slf4j // Lombok �뼱�끂�뀒�씠�뀡: log.info(), log.debug() �벑�쓣 諛붾줈 �궗�슜�븷 �닔 �엳寃� 濡쒓렇 媛앹껜
		// �깮�꽦
public class BoardDAO {
	DataSource dataSource; // 而ㅻ꽖�뀡 ���쓣 �넻�빐 DB �뿰寃곗쓣 愿�由ы븷 媛앹껜

	// �깮�꽦�옄: DataSource瑜� JNDI 諛⑹떇�쑝濡� lookup�븯�뿬 媛��졇�샂
	public BoardDAO() {
		try {
			// context.xml�뿉 �꽕�젙�븳 由ъ냼�뒪 �씠由꾩쑝濡� DB 而ㅻ꽖�뀡�쓣 李얠븘�삩�떎
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 寃뚯떆湲� �쟾泥� 紐⑸줉 議고쉶
	 * 
	 * @return 寃뚯떆湲� 由ъ뒪�듃 (ArrayList<BoardDTO>)
	 */
	public ArrayList<BoardDTO> list() {
		Connection conn = null; // �뜲�씠�꽣踰좎씠�뒪�쓽 �뿰寃곗쓣 �떞�떦�븯�뒗 媛앹껜
		PreparedStatement pstmt = null; // SQL臾몄쓣 而댄뙆�씪�빐�꽌 �떎�뻾�븷 �닔 �엳寃� �빐二쇰뒗 媛앹껜
		ResultSet rs = null; // select 荑쇰━ 寃곌낵瑜� �떞�뒗 媛앹껜 , db濡쒕��꽣 寃곌낵 �뀒�씠釉� �뻾 �떒�쐞濡� �씫�뼱�삱 �닔 �엳�룄濡�
								// �룄��以�.
		// �삉�븳 諛섎났臾몄쓣 �넻�빐 .next()濡� �븳 �뻾�뵫 �젒洹�

		// 寃뚯떆�뙋 �쟾泥� 議고쉶 SQL 臾몄옣
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";

		// 寃곌낵 �뜲�씠�꽣瑜� �떞�쓣 由ъ뒪�듃 媛앹껜
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();

		try {
			conn = dataSource.getConnection(); // 而ㅻ꽖�뀡 ���뿉�꽌 DB �뿰寃� 媛앹껜 媛��졇�삤湲�
			pstmt = conn.prepareStatement(sql); // SQL 臾몄옣�쓣 DB�뿉 蹂대궪 以�鍮�

			rs = pstmt.executeQuery(); // SELECT �떎�뻾

			// 寃곌낵�뀑�쓣 �븳 以꾩뵫 �씫�뼱 BoardDTO 媛앹껜濡� 蹂��솚 �썑 由ъ뒪�듃�뿉 異붽�
			while (rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");

				// 寃뚯떆湲� DTO �깮�꽦 �썑 由ъ뒪�듃�뿉 異붽�
				BoardDTO dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace(); // �뿉�윭 濡쒓렇 異쒕젰
		} finally {
			// �옄�썝 �빐�젣 (DB �뿰寃� �걡湲�)
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos; // �쟾泥� 寃뚯떆湲� 紐⑸줉 諛섑솚
	}

	/**
	 * 寃뚯떆湲� �옉�꽦 湲곕뒫
	 * 
	 * @param boardName    湲��벖�씠 �씠由�
	 * @param boardTitle   湲� �젣紐�
	 * @param boardContent 湲� �궡�슜
	 */
	public void write(String boardName, String boardTitle, String boardContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_board(boardName, boardTitle, boardContent) values(?,?,?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql); // INSERT SQL 以�鍮�
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.executeUpdate(); // DB�뿉 INSERT �떎�뻾, write �땲源�!

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 寃뚯떆湲� �긽�꽭 議고쉶 + 議고쉶�닔 利앷�
	 * 
	 * @param strID 議고쉶�븷 寃뚯떆湲� 踰덊샇 (臾몄옄�뿴濡� �쟾�떖�맖)
	 * @return 寃뚯떆湲� DTO
	 */

	public BoardDTO contentView(String strID) {
		upHit(strID); // 議고쉶�닔 癒쇱� 利앷��떆�궡
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board where boardNo=?";
		BoardDTO dto = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID)); // 寃뚯떆湲� 踰덊샇 �꽕�젙
			rs = pstmt.executeQuery(); // SELECT �떎�뻾

			if (rs.next()) {
				// 寃곌낵瑜� DTO 媛앹껜濡� 留ㅽ븨
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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * 寃뚯떆湲� 議고쉶�닔 利앷�
	 * 
	 * @param boardNo 議고쉶�븷 寃뚯떆湲� 踰덊샇
	 */
	public void upHit(String boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_board set boardHit=boardHit+1 where boardNo=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNo));
			pstmt.executeUpdate(); // 議고쉶�닔 1 利앷�

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 寃뚯떆湲� �닔�젙
	 * 
	 * @param boardNo      寃뚯떆湲� 踰덊샇
	 * @param boardName    �옉�꽦�옄 �씠由�
	 * @param boardTitle   �젣紐�
	 * @param BoardContent �궡�슜
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
			log.info("@# boardNo=>" + boardNo); // 濡쒓렇 異쒕젰
			pstmt.setInt(4, Integer.parseInt(boardNo));
			pstmt.executeUpdate(); // UPDATE �떎�뻾
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 寃뚯떆湲� �궘�젣
	 * 
	 * @param strID �궘�젣�븷 寃뚯떆湲� 踰덊샇
	 */
	public void delete(String strID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_board where boardNo=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			pstmt.executeUpdate(); // DELETE �떎�뻾
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
