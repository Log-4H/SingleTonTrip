package com.log4h.singletontrip.room.domain;

import com.log4h.singletontrip.member.domain.CompanyVo;

public class RoomVo {
	private int roomNo;
	private CompanyVo company;
	private String roomNm;
	private int room_base_count;
	private int room_max_count;
	private String room_detail;
	private String room_img;
	private int room_normal_price;
	private int room_holiday_price;
	private int room_extra_price;
	private String room_reg_date;
	
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
	public int getRoom_base_count() {
		return room_base_count;
	}
	public void setRoom_base_count(int room_base_count) {
		this.room_base_count = room_base_count;
	}
	public int getRoom_max_count() {
		return room_max_count;
	}
	public void setRoom_max_count(int room_max_count) {
		this.room_max_count = room_max_count;
	}
	public String getRoom_detail() {
		return room_detail;
	}
	public void setRoom_detail(String room_detail) {
		this.room_detail = room_detail;
	}
	public String getRoom_img() {
		return room_img;
	}
	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}
	public int getRoom_normal_price() {
		return room_normal_price;
	}
	public void setRoom_normal_price(int room_normal_price) {
		this.room_normal_price = room_normal_price;
	}
	public int getRoom_holiday_price() {
		return room_holiday_price;
	}
	public void setRoom_holiday_price(int room_holiday_price) {
		this.room_holiday_price = room_holiday_price;
	}
	public int getRoom_extra_price() {
		return room_extra_price;
	}
	public void setRoom_extra_price(int room_extra_price) {
		this.room_extra_price = room_extra_price;
	}
	public String getRoom_reg_date() {
		return room_reg_date;
	}
	public void setRoom_reg_date(String room_reg_date) {
		this.room_reg_date = room_reg_date;
	}
	@Override
	public String toString() {
		return "RoomVo [roomNo=" + roomNo + ", company=" + company + ", roomNm=" + roomNm + ", room_base_count="
				+ room_base_count + ", room_max_count=" + room_max_count + ", room_detail=" + room_detail
				+ ", room_img=" + room_img + ", room_normal_price=" + room_normal_price + ", room_holiday_price="
				+ room_holiday_price + ", room_extra_price=" + room_extra_price + ", room_reg_date=" + room_reg_date
				+ "]";
	}
	
}
