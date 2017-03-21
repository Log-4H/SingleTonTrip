package com.log4h.singletontrip.admin.domain;

public class SearchPersonVo {
	private String memberId; //멤버아이디
	private String memberNm;//멤버이름
	private String personBirth;//개인회원생일
	private String personGender;//개인회원성별
	private String memberImg;//멤버이미지
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	public String getPersonBirth() {
		return personBirth;
	}
	public void setPersonBirth(String personBirth) {
		this.personBirth = personBirth;
	}
	public String getPersonGender() {
		return personGender;
	}
	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

}
