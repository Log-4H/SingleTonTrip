package com.log4h.singletontrip.room.domain;

public class RoomReserveVo {
	
	private int roomNo;
	private String roomNm;
	private int reserveStayDay;
	private String reserveCheckinDate;
	private String reserveCheckoutDate;
	private int paymentStateCd;
	private String paymentStateNm;
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomNm() {
		return roomNm;
	}
	public void setRoomNm(String roomNm) {
		this.roomNm = roomNm;
	}
	public int getReserveStayDay() {
		return reserveStayDay;
	}
	public void setReserveStayDay(int reserveStayDay) {
		this.reserveStayDay = reserveStayDay;
	}
	public String getReserveCheckinDate() {
		return reserveCheckinDate;
	}
	public void setReserveCheckinDate(String reserveCheckinDate) {
		this.reserveCheckinDate = reserveCheckinDate;
	}
	public String getReserveCheckoutDate() {
		return reserveCheckoutDate;
	}
	public void setReserveCheckoutDate(String reserveCheckoutDate) {
		this.reserveCheckoutDate = reserveCheckoutDate;
	}
	public int getPaymentStateCd() {
		return paymentStateCd;
	}
	public void setPaymentStateCd(int paymentStateCd) {
		this.paymentStateCd = paymentStateCd;
	}
	public String getPaymentStateNm() {
		return paymentStateNm;
	}
	public void setPaymentStateNm(String paymentStateNm) {
		this.paymentStateNm = paymentStateNm;
	}
	
	
	
	
	
}
