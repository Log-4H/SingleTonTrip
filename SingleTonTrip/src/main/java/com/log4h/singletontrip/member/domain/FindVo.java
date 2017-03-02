package com.log4h.singletontrip.member.domain;

public class FindVo {
	private String memberId;
	private String memberPw;
	private String memberEmail;
	private String memberNm;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	@Override
	public String toString() {
		return "FindVo [memberId=" + memberId + ", memberPw=" + memberPw + ", memberEmail=" + memberEmail
				+ ", memberNm=" + memberNm + "]";
	}
}
