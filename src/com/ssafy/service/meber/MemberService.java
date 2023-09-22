package com.ssafy.service.meber;

import com.ssafy.model.dto.MemberDto;

public interface MemberService {

	void registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	void modifyMember(MemberDto memberDto);

	void deleteMember(String userId);

}
