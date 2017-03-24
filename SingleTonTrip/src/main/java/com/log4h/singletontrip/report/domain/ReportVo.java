package com.log4h.singletontrip.report.domain;

public class ReportVo {
	private int reportNo; //경고no
	private String reportId;//신고대상아이디
	private String memberId;//신고자아이다
	private int reportTypeCd;//신고유형코드
	private String reportTypeNm;//신고유형코드
	private String reportTitle;//신고제목
	private String reportContent;//신고내용
	private String reportDate;//신고날짜
	private int approveStateCd;//승인상태코드
	private String approveStateNm;//승인상태이름
	private String reportApproveDate;//승인/거절일
	private String reportApproveReason;//승인/거절사유
	private String adminId;//관리자아이디
	
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getReportTypeCd() {
		return reportTypeCd;
	}
	public void setReportTypeCd(int reportTypeCd) {
		this.reportTypeCd = reportTypeCd;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
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
	public String getReportApproveDate() {
		return reportApproveDate;
	}
	public void setReportApproveDate(String reportApproveDate) {
		this.reportApproveDate = reportApproveDate;
	}
	public String getReportApproveReason() {
		return reportApproveReason;
	}
	public void setReportApproveReason(String reportApproveReason) {
		this.reportApproveReason = reportApproveReason;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	public String getReportTypeNm() {
		return reportTypeNm;
	}
	public void setReportTypeNm(String reportTypeNm) {
		this.reportTypeNm = reportTypeNm;
	}
	@Override
	public String toString() {
		return "ReportVo [reportNo=" + reportNo + ", reportId=" + reportId + ", memberId=" + memberId
				+ ", reportTypeCd=" + reportTypeCd + ", reportTypeNm=" + reportTypeNm + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportDate=" + reportDate + ", approveStateCd="
				+ approveStateCd + ", approveStateNm=" + approveStateNm + ", reportApproveDate=" + reportApproveDate
				+ ", reportApproveReason=" + reportApproveReason + ", adminId=" + adminId + "]";
	}
	
	
}
