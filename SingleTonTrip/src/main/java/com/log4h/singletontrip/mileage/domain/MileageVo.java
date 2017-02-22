package com.log4h.singletontrip.mileage.domain;

import com.log4h.singletontrip.member.domain.PersonVo;

public class MileageVo {
	private int mileageNo;
	private PersonVo person;
	private MileageCateVo mileageCate;
	private int mileageUsePrice;
	private String mileageUseDate;
	
	public int getMileageNo() {
		return mileageNo;
	}
	public void setMileageNo(int mileageNo) {
		this.mileageNo = mileageNo;
	}
	public PersonVo getPerson() {
		return person;
	}
	public void setPerson(PersonVo person) {
		this.person = person;
	}
	public MileageCateVo getMileageCate() {
		return mileageCate;
	}
	public void setMileageCate(MileageCateVo mileageCate) {
		this.mileageCate = mileageCate;
	}
	public int getMileageUsePrice() {
		return mileageUsePrice;
	}
	public void setMileageUsePrice(int mileageUsePrice) {
		this.mileageUsePrice = mileageUsePrice;
	}
	public String getMileageUseDate() {
		return mileageUseDate;
	}
	public void setMileageUseDate(String mileageUseDate) {
		this.mileageUseDate = mileageUseDate;
	}
	@Override
	public String toString() {
		return "EmptyVo [mileageNo=" + mileageNo + ", person=" + person + ", mileageCate=" + mileageCate
				+ ", mileageUsePrice=" + mileageUsePrice + ", mileageUseDate=" + mileageUseDate + "]";
	}
	
	
	
}
