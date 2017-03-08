package com.log4h.singletontrip.member.domain;

public class CompanyTypeVo {
	private int companyTypeCd;
	private String companyTypeNm;
	public int getCompanyTypeCd() {
		return companyTypeCd;
	}
	public void setCompanyTypeCd(int companyTypeCd) {
		this.companyTypeCd = companyTypeCd;
	}
	public String getCompanyTypeNm() {
		return companyTypeNm;
	}
	public void setCompanyTypeNm(String companyTypeNm) {
		this.companyTypeNm = companyTypeNm;
	}
	@Override
	public String toString() {
		return "CompanyTypeVo [companyTypeCd=" + companyTypeCd + ", companyTypeNm=" + companyTypeNm + "]";
	}
	
	
}
