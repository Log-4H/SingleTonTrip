package com.log4h.singletontrip.trip.domain;

public class TripVo {
	private int tripNo;
	private String personId;
	private String memberImg;
	private int tripThemeCd; 
	private String tripThemeNm; 
	private int regionCd;
	private String regionDo;
	private String regionSi;
	private int recruitStateCd;
	private String recruitStateNm;
	private String tripTitle;
	private String tripContent;
	private int tripPresentMember;
	private int tripMaxMember;
	private String tripTag;
	private String tripStartDate;
	private String tripEndDate;
	private int tripPerPrice;
	private int tripTotalPrice;
	private String tripRecruitStartDate;
	private String tripRecruitEndDate;
	private String tripRegDate;
	private String tripModifyDate;
	private String tripDeleteDate;
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
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	public int getTripThemeCd() {
		return tripThemeCd;
	}
	public void setTripThemeCd(int tripThemeCd) {
		this.tripThemeCd = tripThemeCd;
	}
	public String getTripThemeNm() {
		return tripThemeNm;
	}
	public void setTripThemeNm(String tripThemeNm) {
		this.tripThemeNm = tripThemeNm;
	}
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
	public int getRecruitStateCd() {
		return recruitStateCd;
	}
	public void setRecruitStateCd(int recruitStateCd) {
		this.recruitStateCd = recruitStateCd;
	}
	public String getRecruitStateNm() {
		return recruitStateNm;
	}
	public void setRecruitStateNm(String recruitStateNm) {
		this.recruitStateNm = recruitStateNm;
	}
	public String getTripTitle() {
		return tripTitle;
	}
	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}
	public String getTripContent() {
		return tripContent;
	}
	public void setTripContent(String tripContent) {
		this.tripContent = tripContent;
	}
	public int getTripPresentMember() {
		return tripPresentMember;
	}
	public void setTripPresentMember(int tripPresentMember) {
		this.tripPresentMember = tripPresentMember;
	}
	public int getTripMaxMember() {
		return tripMaxMember;
	}
	public void setTripMaxMember(int tripMaxMember) {
		this.tripMaxMember = tripMaxMember;
	}
	public String getTripTag() {
		return tripTag;
	}
	public void setTripTag(String tripTag) {
		this.tripTag = tripTag;
	}
	public String getTripStartDate() {
		return tripStartDate;
	}
	public void setTripStartDate(String tripStartDate) {
		this.tripStartDate = tripStartDate;
	}
	public String getTripEndDate() {
		return tripEndDate;
	}
	public void setTripEndDate(String tripEndDate) {
		this.tripEndDate = tripEndDate;
	}
	public int getTripPerPrice() {
		return tripPerPrice;
	}
	public void setTripPerPrice(int tripPerPrice) {
		this.tripPerPrice = tripPerPrice;
	}
	public int getTripTotalPrice() {
		return tripTotalPrice;
	}
	public void setTripTotalPrice(int tripTotalPrice) {
		this.tripTotalPrice = tripTotalPrice;
	}
	public String getTripRecruitStartDate() {
		return tripRecruitStartDate;
	}
	public void setTripRecruitStartDate(String tripRecruitStartDate) {
		this.tripRecruitStartDate = tripRecruitStartDate;
	}
	public String getTripRecruitEndDate() {
		return tripRecruitEndDate;
	}
	public void setTripRecruitEndDate(String tripRecruitEndDate) {
		this.tripRecruitEndDate = tripRecruitEndDate;
	}
	public String getTripRegDate() {
		return tripRegDate;
	}
	public void setTripRegDate(String tripRegDate) {
		this.tripRegDate = tripRegDate;
	}
	public String getTripModifyDate() {
		return tripModifyDate;
	}
	public void setTripModifyDate(String tripModifyDate) {
		this.tripModifyDate = tripModifyDate;
	}
	public String getTripDeleteDate() {
		return tripDeleteDate;
	}
	public void setTripDeleteDate(String tripDeleteDate) {
		this.tripDeleteDate = tripDeleteDate;
	}
	@Override
	public String toString() {
		return "TripVo [tripNo=" + tripNo + ", personId=" + personId + ", memberImg=" + memberImg + ", tripThemeCd="
				+ tripThemeCd + ", tripThemeNm=" + tripThemeNm + ", regionCd=" + regionCd + ", regionDo=" + regionDo
				+ ", regionSi=" + regionSi + ", recruitStateCd=" + recruitStateCd + ", recruitStateNm=" + recruitStateNm
				+ ", tripTitle=" + tripTitle + ", tripContent=" + tripContent + ", tripPresentMember="
				+ tripPresentMember + ", tripMaxMember=" + tripMaxMember + ", tripTag=" + tripTag + ", tripStartDate="
				+ tripStartDate + ", tripEndDate=" + tripEndDate + ", tripPerPrice=" + tripPerPrice
				+ ", tripTotalPrice=" + tripTotalPrice + ", tripRecruitStartDate=" + tripRecruitStartDate
				+ ", tripRecruitEndDate=" + tripRecruitEndDate + ", tripRegDate=" + tripRegDate + ", tripModifyDate="
				+ tripModifyDate + ", tripDeleteDate=" + tripDeleteDate + "]";
	}

	
}
