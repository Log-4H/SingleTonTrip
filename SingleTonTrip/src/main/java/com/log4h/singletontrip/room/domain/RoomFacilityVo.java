package com.log4h.singletontrip.room.domain;

public class RoomFacilityVo {
	private int roomFacilityNo;
	private int roomNo;
	private int facilityCd;
	private String facilityNm;
	public int getRoomFacilityNo() {
		return roomFacilityNo;
	}
	public void setRoomFacilityNo(int roomFacilityNo) {
		this.roomFacilityNo = roomFacilityNo;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
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
	@Override
	public String toString() {
		return "RoomFacilityVo [roomFacilityNo=" + roomFacilityNo + ", roomNo=" + roomNo + ", facilityCd=" + facilityCd
				+ ", facilityNm=" + facilityNm + "]";
	}	
}
