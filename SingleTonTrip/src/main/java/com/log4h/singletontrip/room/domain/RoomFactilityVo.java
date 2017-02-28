package com.log4h.singletontrip.room.domain;

public class RoomFactilityVo {
	private int roomFacilityNo;
	private FacilityVo facility;
	private RoomVo room;
	
	public int getRoomFacilityNo() {
		return roomFacilityNo;
	}
	public void setRoomFacilityNo(int roomFacilityNo) {
		this.roomFacilityNo = roomFacilityNo;
	}
	public FacilityVo getFacility() {
		return facility;
	}
	public void setFacility(FacilityVo facility) {
		this.facility = facility;
	}
	public RoomVo getRoom() {
		return room;
	}
	public void setRoom(RoomVo room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "RoomFactilityVo [roomFacilityNo=" + roomFacilityNo + ", facility=" + facility + ", room=" + room + "]";
	}
	
	
	
}
