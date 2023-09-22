package com.ssafy.model.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	//
	private static MemberDao memberDao = new MemberDaoImpl();
	private MemberDaoImpl() {}
	public static MemberDao getInstance() {
		return memberDao;
	}

	private DBUtil dbUtil = DBUtil.getInstance();

	@Override
	public void registerMember(MemberDto memberDto) {//회원 가입(등록)
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql="insert into member (user_id,user_name,user_password,user_email)\r\n" + 
				"values (?, ?, ?, ?);";
		//"values ('ssafy1', '김싸피', '1234', 'email1@ssafy.com');";
		try {
			//DB연결
			conn=dbUtil.getConnection();

			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.setString(4, memberDto.getUserId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}

	}

	@Override
	public MemberDto login(String userId, String userPass) {//로그인:아이디 비번 받아서 일치하는지 여부만
		
		String sql ="select *\r\n" + 
				"from member\r\n" + 
				"where user_id=?\r\n"+ 
				"and user_password=?;";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
			conn=dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String userName=rs.getString("user_name");
				String userEmail=rs.getString("user_email");
				String joinDate = rs.getString("join_date");
				MemberDto memberDto = new MemberDto();
				memberDto.setUserId(userId);
				memberDto.setUserName(userName);
				memberDto.setUserEmail(userEmail);
				memberDto.setJoinDate(joinDate);
				return memberDto;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}

		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {//수정
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "update member\r\n" + 
				"set user_name=?,user_password=?,user_email=?\r\n" + 
				"where user_id=?;";
		try {
			conn=dbUtil.getConnection();

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserName());
			pstmt.setString(2, memberDto.getUserPass());
			pstmt.setString(3, memberDto.getUserEmail());
			pstmt.setString(4, memberDto.getUserId());

			pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}
	}

	@Override
	public void deleteMember(String userId) {//탈퇴(삭제)
		String sql="delete from member\r\n" + 
				"where user_id=?;";
		Connection conn =null;
		PreparedStatement pstmt = null;

		try {
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}
	}

}
