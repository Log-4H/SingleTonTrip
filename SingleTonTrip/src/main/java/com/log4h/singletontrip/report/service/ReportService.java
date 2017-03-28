package com.log4h.singletontrip.report.service;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.report.domain.ReportTypeVo;
import com.log4h.singletontrip.report.domain.ReportVo;

public interface ReportService {
	//신고하기
	public int reportAdd(ReportVo reportVo);
	//신고유형리스트
	public List<ReportTypeVo> reportTypeList();
	//신고리스트
	public Map<String, Object> reportList(int currentPage, String sessionId,int sessionLevel);
	//신고리스트상세보기
	public ReportVo reportDetail(int reportNo);
	//신고리스트 승인&거절
	public int ReportApprove(ReportVo reportVo, ReportVo reportId);

}
