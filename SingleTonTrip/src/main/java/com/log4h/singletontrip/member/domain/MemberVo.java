package com.log4h.singletontrip.member.domain;

public class MemberVo {
	private String memberId;
	private String memberPw;
	private String memberImg;
	private String memberEmail;
	private String memberNm;
	private String approveStateNm;
	private String friendId;
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	private int approveStateCd;
	

	public String getApproveStateNm() {
		return approveStateNm;
	}
	public void setApproveStateNm(String approveStateNm) {
		this.approveStateNm = approveStateNm;
	}
	public int getApproveStateCd() {
		return approveStateCd;
	}
	public void setApproveStateCd(int approveStateCd) {
		this.approveStateCd = approveStateCd;
	}
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
	
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPw=" + memberPw + ", memberEmail=" + memberEmail
				+ ", memberNm=" + memberNm + ", approveStateNm=" + approveStateNm + ", friendId=" + friendId
				+ ", approveStateCd=" + approveStateCd + "]";
	}

}
