package com.log4h.singletontrip.room.domain;

public class CalendarVo {
	private int year;
    private int month;
    private int day;
    private int week;
    private RoomReserveVo reserveVo;
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }
	public RoomReserveVo getReserveVo() {
		return reserveVo;
	}
	public void setReserveVo(RoomReserveVo reserveVo) {
		this.reserveVo = reserveVo;
	}
    
}
