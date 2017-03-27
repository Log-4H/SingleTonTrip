package com.log4h.singletontrip.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.report.domain.ReportTypeVo;
import com.log4h.singletontrip.report.domain.ReportVo;
import com.log4h.singletontrip.report.repository.ReportDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private ReportDao reportDao;
	
	//신고하기
	@Override
	public int reportAdd(ReportVo reportVo) {
		return reportDao.reportAdd(reportVo);
	}
	
	//신고유형리스트
	@Override
	public List<ReportTypeVo> reportTypeList() {
		return reportDao.reportTypeList();
	}
	
	//신고리스트
	@Override
	public Map<String, Object> reportList(int currentPage,String sessionId,int sessionLevel) {
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("sessionId", sessionId);
		totalCountMap.put("sessionLevel", sessionLevel);
        int reportTotalCount = reportDao.reportTotalCount(totalCountMap);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, reportTotalCount);
        map.put("sessionId", sessionId);
        map.put("sessionLevel", sessionLevel);
        List<ReportVo> reportList = reportDao.reportList(map);
        map.put("reportList", reportList);
		return map;
	}

	//신고리스트상세보기
	@Override
	public ReportVo reportDetail(int reportNo) {
		return reportDao.reportDetail(reportNo);
	}
}
