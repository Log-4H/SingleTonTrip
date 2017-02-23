package com.log4h.singletontrip.mileage.domain;

public class MileageCateVo {
	private int mileageCateCd;
	private int mileageState;
	private String mileageCateNm;
	private int mileageCatePrice;
	
	public int getMileageCateCd() {
		return mileageCateCd;
	}
	public void setMileageCateCd(int mileageCateCd) {
		this.mileageCateCd = mileageCateCd;
	}
	public int getMileageState() {
		return mileageState;
	}
	public void setMileageState(int mileageState) {
		this.mileageState = mileageState;
	}
	public String getMileageCateNm() {
		return mileageCateNm;
	}
	public void setMileageCateNm(String mileageCateNm) {
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
		return "MileageCateVo \n[mileageCateCd=" + mileageCateCd + ", mileageState=" + mileageState + ", mileageCateNm="
				+ mileageCateNm + ", mileageCatePrice=" + mileageCatePrice + "]";
	}
	
	
	
	
}


