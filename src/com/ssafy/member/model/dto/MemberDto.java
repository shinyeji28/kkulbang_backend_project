package com.ssafy.member.model.dto;

public class MemberDto {
	//"values ('ssafy1', '김싸피', '1234', 'email1@ssafy.com');";
	private int userNo;
	private String userId;
	private String userName;
	private String userPass;
	private String userEmail;
	private String joinDate;
	
	public MemberDto() {}
	

	public MemberDto(String userId, String userName, String userPass, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
	}
	public MemberDto(int userNo,String userId, String userName, String userEmail, String joinDate) {
		super();
		this.userNo=userNo;
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.joinDate = joinDate;
	}
	public MemberDto(String userId, String userName, String userPass, String userEmail, String joinDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.joinDate = joinDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberDto [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userPass="
				+ userPass + ", userEmail=" + userEmail + ", joinDate=" + joinDate + "]";
	}

}
