package com.ssafy.service.meber;

import com.ssafy.model.dao.member.MemberDaoImpl;
import com.ssafy.model.dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	//싱글톤
	private MemberServiceImpl() {}
	private static MemberService memberService = new MemberServiceImpl();
	public static MemberService getMemberService() {
		return memberService;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) {
		MemberDaoImpl.getInstance().registerMember(memberDto);

	}

	@Override
	public MemberDto login(String userId, String userPass) {
		return MemberDaoImpl.getInstance().login(userId, userPass);

	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getInstance().modifyMember(memberDto);

	}

	@Override
	public void deleteMember(String userId) {
		MemberDaoImpl.getInstance().deleteMember(userId);

	}

}
