package com.log4h.singletontrip.ad.domain;

// 광고 단가
public class AdPriceVo {
	private int adPriceCd;			// 광고분류 코드
	private String adPriceDetail;	// 광고설명
	private int adPricePerday;		// 광고가격(1일)
	private int adPriceAmount;		// 광고수량(일수)
	private int adPriceTotal;		// 총 가격
	
	public int getAdPriceCd() {
		return adPriceCd;
	}
	public void setAdPriceCd(int adPriceCd) {
		this.adPriceCd = adPriceCd;
	}
	public String getAdPriceDetail() {
		return adPriceDetail;
	}
	public void setAdPriceDetail(String adPriceDetail) {
		this.adPriceDetail = adPriceDetail;
	}
	public int getAdPricePerday() {
		return adPricePerday;
	}
	public void setAdPricePerday(int adPricePerday) {
		this.adPricePerday = adPricePerday;
	}
	public int getAdPriceAmount() {
		return adPriceAmount;
	}
	public void setAdPriceAmount(int adPriceAmount) {
		this.adPriceAmount = adPriceAmount;
	}
	public int getAdPriceTotal() {
		return adPriceTotal;
	}
	public void setAdPriceTotal(int adPriceTotal) {
		this.adPriceTotal = adPriceTotal;
	}
	
	@Override
	public String toString() {
		return "AdUnitCostVo [adPriceCd=" + adPriceCd + ", adPriceDetail=" + adPriceDetail + ", adPricePerday="
				+ adPricePerday + ", adPriceAmount=" + adPriceAmount + ", adPriceTotal=" + adPriceTotal + "]";
	}
}
