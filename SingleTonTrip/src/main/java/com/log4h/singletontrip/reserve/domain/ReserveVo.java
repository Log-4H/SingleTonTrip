package com.log4h.singletontrip.reserve.domain;

import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.room.domain.RoomVo;

public class ReserveVo {

	private int reserveNo;
	private RoomVo room;
	private PersonVo person;
	private String reserveStayDay;
	private String reserveCheckinDate;
	private String reserveCheckoutDate;
	private PaymentStateVo paymentState;
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public RoomVo getRoom() {
		return room;
	}
	public void setRoom(RoomVo room) {
		this.room = room;
	}
	public PersonVo getPerson() {
		return person;
	}
	public void setPerson(PersonVo person) {
		this.person = person;
	}
	public String getReserveStayDay() {
		return reserveStayDay;
	}
	public void setReserveStayDay(String reserveStayDay) {
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
	public PaymentStateVo getPaymentState() {
		return paymentState;
	}
	public void setPaymentState(PaymentStateVo paymentState) {
		this.paymentState = paymentState;
	}
	
	@Override
	public String toString() {
		return "ReserveVo [reserveNo=" + reserveNo + ", room=" + room + ", person=" + person + ", reserveStayDay="
				+ reserveStayDay + ", reserveCheckinDate=" + reserveCheckinDate + ", reserveCheckoutDate="
				+ reserveCheckoutDate + ", paymentState=" + paymentState + "]";
	}
	
}
