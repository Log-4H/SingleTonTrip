package com.log4h.singletontrip.member.domain;

public class PersonVo {
	private String memberId; //멤버아이디
	private int memberLevel;//멤버레벨
	private String memberPw;//멤버비밀번호
	private String newPw; //비밀번호변경시 newPw에 담아서 변경
	private String memberNm;//멤버이름
	private String memberPhone;//멤버전화번호
	private String memberEmail;//멤버이메일
	private int memberReportCount;//멤버경고카운트
	private String memberRegDate;//멤버생성일자
	private int actStateCd;//활동상태코드
	private String actStateNm;//활동상태이름
	private String memberDropDate;//탈퇴날자
	private String memberDropReason;//탈퇴이유
	private String personBirth;//개인회원생일
	private String personGender;//개인회원성별
	private String tripStateCd;//여행상태코드
	private String tripStateNm;//여행상태이름
	private int personTotalMileage;//개인회원총마일리지
	private int friendState;//친구상태
	private String memberImg;//멤버이미지
	
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	public int getFriendState() {
		return friendState;
	}
	public void setFriendState(int friendState) {
		this.friendState = friendState;
	}
	public String getTripStateCd() {
		return tripStateCd;
	}
	public void setTripStateCd(String tripStateCd) {
		this.tripStateCd = tripStateCd;
	}
	public String getTripStateNm() {
		return tripStateNm;
	}
	public void setTripStateNm(String tripStateNm) {
		this.tripStateNm = tripStateNm;
	}
	public int getPersonTotalMileage() {
		return personTotalMileage;
	}
	public void setPersonTotalMileage(int personTotalMileage) {
		this.personTotalMileage = personTotalMileage;
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
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getMemberReportCount() {
		return memberReportCount;
	}
	public void setMemberReportCount(int memberReportCount) {
		this.memberReportCount = memberReportCount;
	}
	public String getMemberRegDate() {
		return memberRegDate;
	}
	public void setMemberRegDate(String memberRegDate) {
		this.memberRegDate = memberRegDate;
	}
	public int getActStateCd() {
		return actStateCd;
	}
	public void setActStateCd(int actStateCd) {
		this.actStateCd = actStateCd;
	}
	public String getActStateNm() {
		return actStateNm;
	}
	public void setActStateNm(String actStateNm) {
		this.actStateNm = actStateNm;
	}
	public String getMemberDropDate() {
		return memberDropDate;
	}
	public void setMemberDropDate(String memberDropDate) {
		this.memberDropDate = memberDropDate;
	}
	public String getMemberDropReason() {
		return memberDropReason;
	}
	public void setMemberDropReason(String memberDropReason) {
		this.memberDropReason = memberDropReason;
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
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	@Override
	public String toString() {
		return "PersonVo [memberId=" + memberId + ", memberLevel=" + memberLevel + ", memberPw=" + memberPw
				+ ", memberNm=" + memberNm + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberReportCount=" + memberReportCount + ", memberRegDate=" + memberRegDate + ", actStateCd="
				+ actStateCd + ", actStateNm=" + actStateNm + ", memberDropDate=" + memberDropDate
				+ ", memberDropReason=" + memberDropReason + ", personBirth=" + personBirth + ", personGender="
				+ personGender + ", tripStateCd=" + tripStateCd + ", tripStateNm=" + tripStateNm
				+ ", personTotalMileage=" + personTotalMileage + "]";
	}

}
