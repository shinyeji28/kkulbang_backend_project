package com.ssafy.model.dao.board;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ssafy.model.dto.BoardDto;
import com.ssafy.util.DBUtil;


public class BoardDaoImpl implements BoardDao{

	private static BoardDaoImpl boardDaoImpl = new BoardDaoImpl();
	private DBUtil dbUtil = DBUtil.getInstance();

	private BoardDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDaoImpl getBoardDaoImpl() {
		return boardDaoImpl;
	}

	@Override
	public void registerArticle(BoardDto boardDto) {
		//1. sql입력
		String sql = "insert into board (user_id,subject,content)\r\n" + 
				"values (?, ?, ?);";
		//2. DB연결
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}

	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<>();
		//1. sql 만들기
		String sql = "select * from board;";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//2. db연결하기
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				list.add(boardDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}

		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *\r\n" + 
				"from board\r\n" + 
				"where subject like ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+subject+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto =new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				list.add(boardDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {
		BoardDto boardDto = new BoardDto();
		
		String sql = "select *\r\n" + 
				"from board\r\n" + 
				"where article_no = ?;";
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			rs.next();
			boardDto.setArticleNo(rs.getInt("article_no"));
			boardDto.setUserId(rs.getString("user_id"));
			boardDto.setSubject(rs.getString("subject"));
			boardDto.setContent(rs.getString("content"));
			boardDto.setHit(rs.getInt("hit"));
			boardDto.setRegisterTime(rs.getString("register_time"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		String sql = "update board\r\n" + 
				"set subject = ?, content = ?\r\n" + 
				"where article_no = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}
	}

	@Override
	public void deleteArticle(int no) {
		String sql = "delete from board\r\n" + 
				"where article_no = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}
	}

}
