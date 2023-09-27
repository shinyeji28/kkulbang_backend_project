package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	//싱글톤
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
	public MemberDto loginByEamil(MemberDto member) throws SQLException {//로그인:아이디 비번 받아서 일치하는지 여부만
		String sql ="select *\r\n" + 
				"from member\r\n" + 
				"where user_email=?\r\n"+ 
				"and user_password=?;";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
			conn=dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, member.getUserEmail());
			pstmt.setString(2, member.getUserPass());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String userName=rs.getString("user_name");
				String userId=rs.getString("user_id");
				String joinDate = rs.getString("join_date");
				MemberDto memberDto = new MemberDto();
				memberDto.setUserId(userId);
				memberDto.setUserName(userName);
				memberDto.setUserEmail(member.getUserEmail());
				memberDto.setJoinDate(joinDate);
				return memberDto;
			}
			return null;

		}finally {
			dbUtil.close(rs,pstmt,conn);
		}

		
	}

	@Override
	public MemberDto login(MemberDto member) throws SQLException {//로그인:아이디 비번 받아서 일치하는지 여부만		
		String sql ="select *\r\n" + 
				"from member\r\n" + 
				"where user_id=? and user_password=?";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
			conn=dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPass());			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String userName=rs.getString("user_name");
				String userEmail=rs.getString("user_email");
				String joinDate = rs.getString("join_date");
//				boolean admin = rs.getBoolean("admin");
				MemberDto memberDto = new MemberDto();
				memberDto.setUserId(member.getUserId());
				memberDto.setUserName(userName);
				memberDto.setUserEmail(userEmail);
				memberDto.setJoinDate(joinDate);
//				memberDto.setAdmin(admin);
				return memberDto;
			}
			return null;

		}finally {
			dbUtil.close(rs,pstmt,conn);
		}

		
	}
	@Override
	public String findUser(MemberDto member) throws SQLException {//로그인:아이디 비번 받아서 일치하는지 여부만		
		String sql ="select * from member\r\n" + 
				"where user_id=? and user_name=? and user_email=?";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
			conn=dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserName());		
			pstmt.setString(3, member.getUserEmail());
			rs=pstmt.executeQuery();
			if(rs.next()) {		
				return rs.getString("user_password");
			}
			return null;

		}finally {
			dbUtil.close(rs,pstmt,conn);
		}

		
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
	@Override
	public List<MemberDto> list() throws SQLException {
		String sql = "select *\r\n" + 
				"from member";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//4. 조회 데이터 파싱
			List<MemberDto> list = new ArrayList<MemberDto>();
			while(rs.next()) {
				int no = rs.getInt("member_no");
				String id = rs.getString("user_id");
				String name = rs.getString("user_name");
				String email = rs.getString("user_email");
				String joinDate = rs.getString("join_date");
				boolean admin = rs.getBoolean("admin");
				
				MemberDto mem = new MemberDto(no,id,name,email,joinDate,admin);
				list.add(mem);
			}
			return list;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

}
