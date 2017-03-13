package com.log4h.singletontrip.member.domain;

public class CompanyVo {
	private String memberId;//멤버아이디
	private int memberLevel;//멤버레벨
	private String newPw;//비밀번호변경시 newPw에 담아서 변경
	private String memberPw;//멤버비밀번호
	private String memberNm;//멤버이름
	private String memberPhone;//멤버전화번호
	private String memberEmail;//멤버이메일
	private int companyCrd;//업체사업자번호
	private int companyTypeCd;//업체타입코드
	private String companyTypeNm;//업체타임이름
	private String companyNm;//업체명
	private String companyAddress;//검색한 업체주소와 상세주소를 합해서 담아준다.
	private String companyAddressSelect;//검색한업체주소
	private String companyAddressDetail;//업체상세주소
	private int memberReportCount;//경고횟수
	private String memberRegDate;//생성일자
	private int actStateCd;//활동상태코드
	private String actStateNm;//활동상태이름
	private String memberDropDate;//탈퇴날짜
	private String memberDropReason;//탈퇴이유
	private String memberImg;//이미지

	
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getCompanyAddressSelect() {
		return companyAddressSelect;
	}
	public void setCompanyAddressSelect(String companyAddressSelect) {
		this.companyAddressSelect = companyAddressSelect;
	}
	public String getCompanyAddressDetail() {
		return companyAddressDetail;
	}
	public void setCompanyAddressDetail(String companyAddressDetail) {
		this.companyAddressDetail = companyAddressDetail;
	}
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
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
		return "CompanyVo [memberId=" + memberId + ", memberLevel=" + memberLevel + ", newPw=" + newPw + ", memberPw="
				+ memberPw + ", memberNm=" + memberNm + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", companyCrd=" + companyCrd + ", companyTypeCd=" + companyTypeCd + ", companyTypeNm=" + companyTypeNm
				+ ", companyNm=" + companyNm + ", companyAddress=" + companyAddress + ", companyAddressSelect="
				+ companyAddressSelect + ", companyAddressDetail=" + companyAddressDetail + ", memberReportCount="
				+ memberReportCount + ", memberRegDate=" + memberRegDate + ", actStateCd=" + actStateCd
				+ ", actStateNm=" + actStateNm + ", memberDropDate=" + memberDropDate + ", memberDropReason="
				+ memberDropReason + ", memberImg=" + memberImg + "]";
	}


}
