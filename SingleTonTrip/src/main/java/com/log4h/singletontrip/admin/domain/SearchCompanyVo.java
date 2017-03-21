package com.log4h.singletontrip.admin.domain;

public class SearchCompanyVo {
	private String memberId;//멤버아이디
	private String memberPhone;//멤버전화번호
	private String companyTypeNm;//업체타임이름
	private String companyNm;//업체명
	private String companyAddress;//검색한 업체주소와 상세주소를 합해서 담아준다.
	private String memberImg;//이미지
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getCompanyTypeNm() {
		return companyTypeNm;
	}
	public void setCompanyTypeNm(String companyTypeNm) {
		this.companyTypeNm = companyTypeNm;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

}
