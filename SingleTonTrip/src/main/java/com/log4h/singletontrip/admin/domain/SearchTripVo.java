package com.log4h.singletontrip.admin.domain;

public class SearchTripVo {
	private int tripNo;
	private String personId;
	private String tripThemeNm; 
	private String regionDo;
	private String regionSi;
	private String tripTitle;
	private String tripStartDate;
	private String tripEndDate;
	public int getTripNo() {
		return tripNo;
	}
	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getTripThemeNm() {
		return tripThemeNm;
	}
	public void setTripThemeNm(String tripThemeNm) {
		this.tripThemeNm = tripThemeNm;
	}
	public String getRegionDo() {
		return regionDo;
	}
	public void setRegionDo(String regionDo) {
		this.regionDo = regionDo;
	}
	public String getRegionSi() {
		return regionSi;
	}
	public void setRegionSi(String regionSi) {
		this.regionSi = regionSi;
	}
	public String getTripTitle() {
		return tripTitle;
	}
	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}
	public String getTripStartDate() {
		return tripStartDate;
	}
	public void setTripStartDate(String tripStartDate) {
		this.tripStartDate = tripStartDate;
	}
	public String getTripEndDate() {
		return tripEndDate;
	}
	public void setTripEndDate(String tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

}
