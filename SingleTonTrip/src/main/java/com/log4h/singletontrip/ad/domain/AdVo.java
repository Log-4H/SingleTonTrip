package com.log4h.singletontrip.ad.domain;

public class AdVo {
	private int adNo;					// 광고no
	private String companyId;			// 업체 아이디
	private int adPriceCd;				// 광고 단가 code
	private int adGroupCd;				// 같은 광고 그룹
	private int approveStateCd;			// 승인 상태 code
	private String approveStateNm;		// 승인 상태 code 한글
	private String adContent;			// 광고 내용
	private String adImg;				// 광고 이미지
	private int adTotalAmount;			// 총수량(일수)
	private int adTotalPrice;			// 총결제금액
	private String adApplyDate;			// 광고 신청일
	private String adRegDate;			// 광고 게시일
	private String adEndDate;			// 광고 종료일
	private String adminId;				// 관리자 아이디
	private String paymentFinishDate;	// 결제일
	
	public int getAdNo() {
		return adNo;
	}
	public void setAdNo(int adNo) {
		this.adNo = adNo;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getAdGroupCd() {
		return adGroupCd;
	}
	public void setAdGroupCd(int adGroupCd) {
		this.adGroupCd = adGroupCd;
	}
	public int getAdPriceCd() {
		return adPriceCd;
	}
	public void setAdPriceCd(int adPriceCd) {
		this.adPriceCd = adPriceCd;
	}
	public int getApproveStateCd() {
		return approveStateCd;
	}
	public void setApproveStateCd(int approveStateCd) {
		this.approveStateCd = approveStateCd;
	}
	public String getApproveStateNm() {
		return approveStateNm;
	}
	public void setApproveStateNm(String approveStateNm) {
		this.approveStateNm = approveStateNm;
	}
	public String getAdContent() {
		return adContent;
	}
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}
	public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
	public int getAdTotalAmount() {
		return adTotalAmount;
	}
	public void setAdTotalAmount(int adTotalAmount) {
		this.adTotalAmount = adTotalAmount;
	}
	public int getAdTotalPrice() {
		return adTotalPrice;
	}
	public void setAdTotalPrice(int adTotalPrice) {
		this.adTotalPrice = adTotalPrice;
	}
	public String getAdApplyDate() {
		return adApplyDate;
	}
	public void setAdApplyDate(String adApplyDate) {
		this.adApplyDate = adApplyDate;
	}
	public String getAdRegDate() {
		return adRegDate;
	}
	public void setAdRegDate(String adRegDate) {
		this.adRegDate = adRegDate;
	}
	public String getAdEndDate() {
		return adEndDate;
	}
	public void setAdEndDate(String adEndDate) {
		this.adEndDate = adEndDate;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPaymentFinishDate() {
		return paymentFinishDate;
	}
	public void setPaymentFinishDate(String paymentFinishDate) {
		this.paymentFinishDate = paymentFinishDate;
	}
	
	@Override
	public String toString() {
		return "Ad [adNo=" + adNo + ", companyId=" + companyId + ", adPriceCd=" + adPriceCd + ", approveStateCd="
				+ approveStateCd + ", adContent=" + adContent + ", adImg=" + adImg + ", adTotalAmount=" + adTotalAmount
				+ ", adTotalPrice=" + adTotalPrice + ", adApplyDate=" + adApplyDate + ", adRegDate=" + adRegDate
				+ ", adEndDate=" + adEndDate + ", adminId=" + adminId + "]";
	}
	
}
