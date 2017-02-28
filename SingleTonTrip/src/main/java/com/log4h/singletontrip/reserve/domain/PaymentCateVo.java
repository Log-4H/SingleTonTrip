package com.log4h.singletontrip.reserve.domain;

public class PaymentCateVo {
	private int paymentCateCd;
	private String paymentCateNm;
	
	public int getPaymentCateCd() {
		return paymentCateCd;
	}
	public void setPaymentCateCd(int paymentCateCd) {
		this.paymentCateCd = paymentCateCd;
	}
	public String getPaymentCateNm() {
		return paymentCateNm;
	}
	public void setPaymentCateNm(String paymentCateNm) {
		this.paymentCateNm = paymentCateNm;
	}
	@Override
	public String toString() {
		return "PaymentCateVo [paymentCateCd=" + paymentCateCd + ", paymentCateNm=" + paymentCateNm + "]";
	}
	
}
