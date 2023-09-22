package com.ssafy.service.meber;

import java.sql.SQLException;

import com.ssafy.model.dao.member.MemberDaoImpl;
import com.ssafy.model.dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	//싱글톤	
	private static MemberService memberService = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberService getMemberService() {
		return memberService;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) {
		MemberDaoImpl.getInstance().registerMember(memberDto);

	}

	@Override
	public MemberDto login(MemberDto memberDto) throws SQLException {
		return MemberDaoImpl.getInstance().login(memberDto);

	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getInstance().modifyMember(memberDto);

	}

	@Override
	public void deleteMember(String userId) {
		MemberDaoImpl.getInstance().deleteMember(userId);

	}
	@Override
	public MemberDto loginByEamil(MemberDto member) throws SQLException {
		return MemberDaoImpl.getInstance().loginByEamil(member);
	}
	@Override
	public int findUser(MemberDto member) throws SQLException{
		return MemberDaoImpl.getInstance().findUser(member);
	}
}
