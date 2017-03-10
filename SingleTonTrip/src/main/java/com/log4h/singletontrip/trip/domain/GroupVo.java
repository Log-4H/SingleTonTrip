package com.log4h.singletontrip.trip.domain;

public class GroupVo {
	private int groupNo;
	private int tripNo;
	private String personId;
	private int approveStateCd;
	private String approveStateNm;
	private String groupApplyDate;
	private String groupApproveDate;
	private String groupDropDate;
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getTripNo() {
		return tripNo;
	}
	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public int getApproveStateCd() {
		return approveStateCd;
	}
	public void setApproveStateCd(int approveStateCd) {
		this.approveStateCd = approveStateCd;
	}
	public String getApproveStateNm() {
		return approveStateNm;
	}
	public void setApproveStateNm(String approveStateNm) {
		this.approveStateNm = approveStateNm;
	}
	public String getGroupApplyDate() {
		return groupApplyDate;
	}
	public void setGroupApplyDate(String groupApplyDate) {
		this.groupApplyDate = groupApplyDate;
	}
	public String getGroupApproveDate() {
		return groupApproveDate;
	}
	public void setGroupApproveDate(String groupApproveDate) {
		this.groupApproveDate = groupApproveDate;
	}
	public String getGroupDropDate() {
		return groupDropDate;
	}
	public void setGroupDropDate(String groupDropDate) {
		this.groupDropDate = groupDropDate;
	}
	@Override
	public String toString() {
		return "GroupVo [groupNo=" + groupNo + ", tripNo=" + tripNo + ", personId=" + personId + ", approveStateCd="
				+ approveStateCd + ", approveStateNm=" + approveStateNm + ", groupApplyDate=" + groupApplyDate
				+ ", groupApproveDate=" + groupApproveDate + ", groupDropDate=" + groupDropDate + "]";
	}
	
	
}
