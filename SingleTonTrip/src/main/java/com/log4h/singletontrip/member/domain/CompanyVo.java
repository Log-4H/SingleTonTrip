package com.log4h.singletontrip.member.domain;

public class CompanyVo {
	private String memberId;
	private int memberLevel;
	private String newPw;
	private String memberPw;
	private String memberNm;
	private String memberPhone;
	private String memberEmail;
	private int companyCrd;
	private int companyTypeCd;
	private String companyTypeNm;
	private String companyAddress;
	private int memberReportCount;
	private String memberRegDate;
	private int actStateCd;
	private String actStateNm;
	private String memberDropDate;
	private String memberDropReason;
	private String companyImg;

	public String getCompanyImg() {
		return companyImg;
	}
	public void setCompanyImg(String companyImg) {
		this.companyImg = companyImg;
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
	public int getCompanyCrd() {
		return companyCrd;
	}
	public void setCompanyCrd(int companyCrd) {
		this.companyCrd = companyCrd;
	}
	public int getCompanyTypeCd() {
		return companyTypeCd;
	}
	public void setCompanyTypeCd(int companyTypeCd) {
		this.companyTypeCd = companyTypeCd;
	}
	public String getCompanyTypeNm() {
		return companyTypeNm;
	}
	public void setCompanyTypeNm(String companyTypeNm) {
		this.companyTypeNm = companyTypeNm;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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
	
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	@Override
	public String toString() {
		return "CompanyVo [memberId=" + memberId + ", memberLevel=" + memberLevel + ", memberPw=" + memberPw
				+ ", memberNm=" + memberNm + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", companyCrd=" + companyCrd + ", companyTypeCd=" + companyTypeCd + ", companyTypeNm=" + companyTypeNm
				+ ", companyAddress=" + companyAddress + ", memberReportCount=" + memberReportCount + ", memberRegDate="
				+ memberRegDate + ", actStateCd=" + actStateCd + ", actStateNm=" + actStateNm + ", memberDropDate="
				+ memberDropDate + ", memberDropReason=" + memberDropReason + "]";
	}


}
