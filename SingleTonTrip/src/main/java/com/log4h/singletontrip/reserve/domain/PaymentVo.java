package com.log4h.singletontrip.reserve.domain;

import com.log4h.singletontrip.member.domain.LoginVo;

public class PaymentVo {
	private int paymentNo;
	private int adminId;
	private LoginVo login;
	private PaymentCateVo paymentCate;
	private int paymentTargetNo;
	private PaymentStateVo paymentState;
	private int paymentUseMileage;
	private int paymentPrice;
	private int paymentTotalPrice;
	private String paymentApplyDate;
	private String paymentFinishDate;
	private String paymentApproveDate;
	
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
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
		return "PaymentVo [paymentNo=" + paymentNo + ", adminId=" + adminId + ", login=" + login + ", paymentCate="
				+ paymentCate + ", paymentTargetNo=" + paymentTargetNo + ", paymentState=" + paymentState
				+ ", paymentUseMileage=" + paymentUseMileage + ", paymentPrice=" + paymentPrice + ", paymentTotalPrice="
				+ paymentTotalPrice + ", paymentApplyDate=" + paymentApplyDate + ", paymentFinishDate="
				+ paymentFinishDate + ", paymentApproveDate=" + paymentApproveDate + "]";
	}
	
	
}
