package com.log4h.singletontrip.trip.domain;

public class TripThemeVo {
	
	private int tripThemeCd;
	private String tripThemeNm;
	
	public int getTripThemeCd() {
		return tripThemeCd;
	}
	public void setTripThemeCd(int tripThemeCd) {
		this.tripThemeCd = tripThemeCd;
	}
	public String getTripThemeNm() {
		return tripThemeNm;
	}
	public void setTripThemeNm(String tripThemeNm) {
		this.tripThemeNm = tripThemeNm;
	}
	@Override
	public String toString() {
		return "TripThemeVo [tripThemeCd=" + tripThemeCd + ", tripThemeNm=" + tripThemeNm + "]";
	}
	
	
	
}
