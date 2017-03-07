package com.log4h.singletontrip.trip.domain;

public class PlanVo {
	
	private int planNo;
	private int tripNo;
	private String planSite;
	private String planContent;
	private String planStartTime;
	private String planEndTime;
	private String planPrice;
	
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public int getTripNo() {
		return tripNo;
	}
	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}
	public String getPlanSite() {
		return planSite;
	}
	public void setPlanSite(String planSite) {
		this.planSite = planSite;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getPlanStartTime() {
		return planStartTime;
	}
	public void setPlanStartTime(String planStartTime) {
		this.planStartTime = planStartTime;
	}
	public String getPlanEndTime() {
		return planEndTime;
	}
	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}
	public String getPlanPrice() {
		return planPrice;
	}
	public void setPlanPrice(String planPrice) {
		this.planPrice = planPrice;
	}
	@Override
	public String toString() {
		return "PlanVo [planNo=" + planNo + ", tripNo=" + tripNo + ", planSite=" + planSite + ", planContent="
				+ planContent + ", planStartTime=" + planStartTime + ", planEndTime=" + planEndTime + ", planPrice="
				+ planPrice + "]";
	}

}
