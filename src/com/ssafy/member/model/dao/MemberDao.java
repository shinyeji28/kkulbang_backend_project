package com.ssafy.member.model.dao;

import java.sql.SQLException;

import com.ssafy.member.model.dto.MemberDto;


public interface MemberDao {

	void registerMember(MemberDto memberDto);

	MemberDto login(MemberDto memberDto) throws SQLException;

	void modifyMember(MemberDto memberDto);

	void deleteMember(String userId);

	MemberDto loginByEamil(MemberDto member) throws SQLException;

	String findUser(MemberDto member) throws SQLException;

}
