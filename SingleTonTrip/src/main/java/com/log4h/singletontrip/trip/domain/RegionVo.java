package com.log4h.singletontrip.trip.domain;

public class RegionVo {
	
	private int regionCd;
	private String regionDo;
	private String regionSi;
	
	public int getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(int regionCd) {
		this.regionCd = regionCd;
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
	@Override
	public String toString() {
		return "RegionVo [regionCd=" + regionCd + ", regionDo=" + regionDo + ", regionSi=" + regionSi + "]";
	}
	
	
}
