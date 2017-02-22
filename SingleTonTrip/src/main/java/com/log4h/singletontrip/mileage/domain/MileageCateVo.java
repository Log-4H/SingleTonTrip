package com.log4h.singletontrip.mileage.domain;

public class MileageCateVo {
	private int mileageCateCd;
	private int mileageCateNm;
	private int mileageCatePrice;
	
	public int getMileageCateCd() {
		return mileageCateCd;
	}
	public void setMileageCateCd(int mileageCateCd) {
		this.mileageCateCd = mileageCateCd;
	}
	public int getMileageCateNm() {
		return mileageCateNm;
	}
	public void setMileageCateNm(int mileageCateNm) {
		this.mileageCateNm = mileageCateNm;
	}
	public int getMileageCatePrice() {
		return mileageCatePrice;
	}
	public void setMileageCatePrice(int mileageCatePrice) {
		this.mileageCatePrice = mileageCatePrice;
	}
	
	@Override
	public String toString() {
		return "MileageCateVo [mileageCateCd=" + mileageCateCd + ", mileageCateNm=" + mileageCateNm
				+ ", mileageCatePrice=" + mileageCatePrice + "]";
	}
	
	
	
}
