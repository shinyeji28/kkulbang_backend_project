package com.ssafy.service.meber;

import java.sql.SQLException;

import com.ssafy.model.dto.MemberDto;

public interface MemberService {

	void registerMember(MemberDto memberDto);

	MemberDto login(MemberDto memberDto) throws SQLException;

	void modifyMember(MemberDto memberDto);

	void deleteMember(String userId);
	
	MemberDto loginByEamil(MemberDto member) throws SQLException;
	
	int findUser(MemberDto member) throws SQLException;

}
