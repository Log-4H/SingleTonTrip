package com.log4h.singletontrip.reserve.domain;

import com.log4h.singletontrip.member.domain.LoginVo;

public class PaymentVo {
	private int paymentNo;					// 결제no
	private String adminId;					// 관리자아이디
	private String memberId;				// 결제자아이디
	private int paymentCateCd;				// 결제분류코드
	private int paymentTargetNo;			// 결제대상no
	private int paymentStateCd;				// 결제상태코드
	private int paymentUseMileage;			// 마일리지사용
	private int paymentPrice;				// 실제 결제금액
	private int paymentTotalPrice;			// 상품가
	private String paymentApplyDate;		// 결제신청일
	private String paymentFinishDate;		// 결제일
	private String paymentApproveDate;		// 관리자승인/거부일
	private String paymentStateNm;			// 결제상태코드 한글
	public String getPaymentStateNm() {
		return paymentStateNm;
	}
	public void setPaymentStateNm(String paymentStateNm) {
		this.paymentStateNm = paymentStateNm;
	}

	private PaymentStateVo paymentState;
	private PaymentCateVo paymentCate;
	private LoginVo login;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getPaymentCateCd() {
		return paymentCateCd;
	}
	public void setPaymentCateCd(int paymentCateCd) {
		this.paymentCateCd = paymentCateCd;
	}
	public int getPaymentStateCd() {
		return paymentStateCd;
	}
	public void setPaymentStateCd(int paymentStateCd) {
		this.paymentStateCd = paymentStateCd;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public LoginVo getLogin() {
		return login;
	}
	public void setLogin(LoginVo login) {
		this.login = login;
	}
	public PaymentCateVo getPaymentCate() {
		return paymentCate;
	}
	public void setPaymentCate(PaymentCateVo paymentCate) {
		this.paymentCate = paymentCate;
	}
	public int getPaymentTargetNo() {
		return paymentTargetNo;
	}
	public void setPaymentTargetNo(int paymentTargetNo) {
		this.paymentTargetNo = paymentTargetNo;
	}
	public PaymentStateVo getPaymentState() {
		return paymentState;
	}
	public void setPaymentState(PaymentStateVo paymentState) {
		this.paymentState = paymentState;
	}
	public int getPaymentUseMileage() {
		return paymentUseMileage;
	}
	public void setPaymentUseMileage(int paymentUseMileage) {
		this.paymentUseMileage = paymentUseMileage;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public int getPaymentTotalPrice() {
		return paymentTotalPrice;
	}
	public void setPaymentTotalPrice(int paymentTotalPrice) {
		this.paymentTotalPrice = paymentTotalPrice;
	}
	public String getPaymentApplyDate() {
		return paymentApplyDate;
	}
	public void setPaymentApplyDate(String paymentApplyDate) {
		this.paymentApplyDate = paymentApplyDate;
	}
	public String getPaymentFinishDate() {
		return paymentFinishDate;
	}
	public void setPaymentFinishDate(String paymentFinishDate) {
		this.paymentFinishDate = paymentFinishDate;
	}
	public String getPaymentApproveDate() {
		return paymentApproveDate;
	}
	public void setPaymentApproveDate(String paymentApproveDate) {
		this.paymentApproveDate = paymentApproveDate;
	}
	
	@Override
	public String toString() {
		return "PaymentVo [paymentNo=" + paymentNo + ", adminId=" + adminId + ", memberId=" + memberId
				+ ", paymentCateCd=" + paymentCateCd + ", paymentTargetNo=" + paymentTargetNo + ", paymentStateCd="
				+ paymentStateCd + ", paymentUseMileage=" + paymentUseMileage + ", paymentPrice=" + paymentPrice
				+ ", paymentTotalPrice=" + paymentTotalPrice + ", paymentApplyDate=" + paymentApplyDate
				+ ", paymentFinishDate=" + paymentFinishDate + ", paymentApproveDate=" + paymentApproveDate
				+ ", paymentStateNm=" + paymentStateNm + ", paymentState=" + paymentState + ", paymentCate="
				+ paymentCate + ", login=" + login + "]";
	}
	
	
}
