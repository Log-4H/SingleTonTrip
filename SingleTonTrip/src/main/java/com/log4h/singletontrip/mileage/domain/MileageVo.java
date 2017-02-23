package com.log4h.singletontrip.mileage.domain;

import com.log4h.singletontrip.member.domain.PersonVo;

public class MileageVo {
	private int mileageNo;
	private PersonVo person;
	/* * * * * * * * * * * * * * * * *
	 * private String memberId;
	 * private int memberLevel;
	 * private String memberPw;
	 * private String memberNm;
	 * private String memberPhone;
	 * private String memberEmail;
	 * private int memberReportCount;
	 * private String memberRegDate;
	 * private int actStateCd;
	 * private String actStateNm;
	 * private String memberDropDate;
	 * private String memberDropReason;
	 * private String personBirth;
	 * private String personGender;
	 * private String tripStateCd;
	 * private String tripStateNm;
	 * private String personTotalMileage; 
	 *  * * * *  * * * *  * * * *  * * * */
	private MileageCateVo mileageCate;
	/* *
	 * private int mileageCateCd;
	 * private int mileageCateNm;
	 * private int mileageCatePrice;
	 * */
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
		return "MileageVo \n[mileageNo=" + mileageNo + ", person=" + person + ", mileageCate=" + mileageCate
				+ ", mileageUsePrice=" + mileageUsePrice + ", mileageUseDate=" + mileageUseDate + "]";
	}
	
	
	
}
