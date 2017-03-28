package com.log4h.singletontrip.report.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.report.domain.ReportTypeVo;
import com.log4h.singletontrip.report.domain.ReportVo;

public interface ReportDao {
	
	//신고하기
	public int reportAdd(ReportVo reportVo);
	//신고유형리스트
	public List<ReportTypeVo> reportTypeList();
	//신고리스트총카운트
	public int reportTotalCount(Map<String, Object> map); 
	//신고리스트
	public List<ReportVo> reportList(Map<String, Object> map);
	//신고리스트상세보기
	public ReportVo reportDetail(int reportNo);
	//신고리스트 승인&거절
	public int reportApprove(ReportVo reportVo);
	//신고승인시 경고횟수누적
	public int reportCountAdd(ReportVo reportId);
	//누적신고횟수확인
	public int reportCountSelect(ReportVo reportId);
	//신고횟수누적시 회원상태변경
	public int actStateModify(ReportVo reportId);
}
