package com.log4h.singletontrip.member.domain;

public class LoginVo {
	private String memberId;
	private int memberLevel;
	private String memberNm;
	private int loginMileageCate;
	
	public int getLoginMileageCate() {
		return loginMileageCate;
	}
	public void setLoginMileageCate(int loginMileageCate) {
		this.loginMileageCate = loginMileageCate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	@Override
	public String toString() {
		return "LoginVo [memberId=" + memberId + ", memberLevel=" + memberLevel + ", memberNm=" + memberNm
				+ ", loginMileageCate=" + loginMileageCate + "]";
	}
	
	
}
