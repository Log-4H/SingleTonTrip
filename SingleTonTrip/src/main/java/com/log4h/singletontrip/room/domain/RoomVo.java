package com.log4h.singletontrip.room.domain;

import java.util.List;

import com.log4h.singletontrip.member.domain.CompanyVo;

public class RoomVo {
	private int roomNo;
	private CompanyVo company;
	private String roomNm;
	private int roomBaseCount;
	private int roomMaxCount;
	private String roomDetail;
	private String roomImg;
	private int roomNormalPrice;
	private int roomHolidayPrice;
	private int roomExtraPrice;
	private String roomRegDate;
	private List<RoomFacilityVo> roomFacilityList;
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public CompanyVo getCompany() {
		return company;
	}
	public void setCompany(CompanyVo company) {
		this.company = company;
	}
	public String getRoomNm() {
		return roomNm;
	}
	public void setRoomNm(String roomNm) {
		this.roomNm = roomNm;
	}
	public int getRoomBaseCount() {
		return roomBaseCount;
	}
	public void setRoomBaseCount(int roomBaseCount) {
		this.roomBaseCount = roomBaseCount;
	}
	public int getRoomMaxCount() {
		return roomMaxCount;
	}
	public void setRoomMaxCount(int roomMaxCount) {
		this.roomMaxCount = roomMaxCount;
	}
	public String getRoomDetail() {
		return roomDetail;
	}
	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}
	public String getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}
	public int getRoomNormalPrice() {
		return roomNormalPrice;
	}
	public void setRoomNormalPrice(int roomNormalPrice) {
		this.roomNormalPrice = roomNormalPrice;
	}
	public int getRoomHolidayPrice() {
		return roomHolidayPrice;
	}
	public void setRoomHolidayPrice(int roomHolidayPrice) {
		this.roomHolidayPrice = roomHolidayPrice;
	}
	public int getRoomExtraPrice() {
		return roomExtraPrice;
	}
	public void setRoomExtraPrice(int roomExtraPrice) {
		this.roomExtraPrice = roomExtraPrice;
	}
	public String getRoomRegDate() {
		return roomRegDate;
	}
	public void setRoomRegDate(String roomRegDate) {
		this.roomRegDate = roomRegDate;
	}
	
	public List<RoomFacilityVo> getRoomFacilityList() {
		return roomFacilityList;
	}
	public void setRoomFacilityList(List<RoomFacilityVo> roomFacilityList) {
		this.roomFacilityList = roomFacilityList;
	}
	@Override
	public String toString() {
		return "RoomVo [roomNo=" + roomNo + ", company=" + company + ", roomNm=" + roomNm + ", roomBaseCount="
				+ roomBaseCount + ", roomMaxCount=" + roomMaxCount + ", roomDetail=" + roomDetail + ", roomImg="
				+ roomImg + ", roomNormalPrice=" + roomNormalPrice + ", roomHolidayPrice=" + roomHolidayPrice
				+ ", roomExtraPrice=" + roomExtraPrice + ", roomRegDate=" + roomRegDate + "]";
	}
	
	
	
	
}
