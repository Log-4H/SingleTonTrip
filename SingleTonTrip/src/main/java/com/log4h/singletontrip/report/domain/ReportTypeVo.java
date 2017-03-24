package com.log4h.singletontrip.report.domain;

public class ReportTypeVo {
	private int reportTypeCd;
	private String reportTypeNm;
	public int getReportTypeCd() {
		return reportTypeCd;
	}
	public void setReportTypeCd(int reportTypeCd) {
		this.reportTypeCd = reportTypeCd;
	}
	public String getReportTypeNm() {
		return reportTypeNm;
	}
	public void setReportTypeNm(String reportTypeNm) {
		this.reportTypeNm = reportTypeNm;
	}
	@Override
	public String toString() {
		return "ReportTypeVo [reportTypeCd=" + reportTypeCd + ", reportTypeNm=" + reportTypeNm + "]";
	}
	
}
