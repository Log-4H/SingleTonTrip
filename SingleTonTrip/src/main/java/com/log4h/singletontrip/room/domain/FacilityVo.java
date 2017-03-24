package com.log4h.singletontrip.room.domain;

public class FacilityVo {
	private int facilityCd;
	private String facilityNm;
	private String facilityIcon;
	
	public int getFacilityCd() {
		return facilityCd;
	}
	public void setFacilityCd(int facilityCd) {
		this.facilityCd = facilityCd;
	}
	public String getFacilityNm() {
		return facilityNm;
	}
	public void setFacilityNm(String facilityNm) {
		this.facilityNm = facilityNm;
	}
	
	public String getFacilityIcon() {
		return facilityIcon;
	}
	public void setFacilityIcon(String facilityIcon) {
		this.facilityIcon = facilityIcon;
	}
	@Override
	public String toString() {
		return "FacilityVo [facilityCd=" + facilityCd + ", facilityNm=" + facilityNm + "]";
	}
	
}
