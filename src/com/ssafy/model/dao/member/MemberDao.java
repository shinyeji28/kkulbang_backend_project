package com.ssafy.model.dao.member;

import com.ssafy.model.dto.MemberDto;

public interface MemberDao {

	void registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	void modifyMember(MemberDto memberDto);

	void deleteMember(String userId);

}
