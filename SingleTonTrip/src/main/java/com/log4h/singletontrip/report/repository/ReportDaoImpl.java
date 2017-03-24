package com.log4h.singletontrip.report.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.report.domain.ReportTypeVo;
import com.log4h.singletontrip.report.domain.ReportVo;

@Repository
public class ReportDaoImpl implements ReportDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String REPORT_NS = "reportMapper.";
	
	//신고하기
	@Override
	public int reportAdd(ReportVo reportVo) {
		return sqlSession.insert(REPORT_NS+"reportAdd", reportVo);
	}
	
	//신고유형리스트
	@Override
	public List<ReportTypeVo> reportTypeList() {
		return sqlSession.selectList(REPORT_NS+"reportTypeList");
	}
	
	//신고리스트총카운트
	@Override
	public int reportTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(REPORT_NS+"reportTotalCount", map);
	}
	
	//신고리스트
	@Override
	public List<ReportVo> reportList(Map<String, Object> map) {
		return sqlSession.selectList(REPORT_NS+"reportList", map);
	}

	//신고리스트상세보기
	@Override
	public ReportVo reportDetail(int reportNo) {
		return sqlSession.selectOne(REPORT_NS+"reportDetail",reportNo);
	}


}
