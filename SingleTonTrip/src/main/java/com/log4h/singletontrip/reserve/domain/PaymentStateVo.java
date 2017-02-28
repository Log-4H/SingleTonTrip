package com.log4h.singletontrip.reserve.domain;

public class PaymentStateVo {
	private int paymentStateCd;
	private String paymentStateNm;
	public int getPaymentStateCd() {
		return paymentStateCd;
	}
	public void setPaymentStateCd(int paymentStateCd) {
		this.paymentStateCd = paymentStateCd;
	}
	public String getPaymentStateNm() {
		return paymentStateNm;
	}
	public void setPaymentStateNm(String paymentStateNm) {
		this.paymentStateNm = paymentStateNm;
	}
	@Override
	public String toString() {
		return "PaymentStateVo [paymentStateCd=" + paymentStateCd + ", paymentStateNm=" + paymentStateNm + "]";
	}

	
}
