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
	//신고리스트 승인&거절
	@Override
	public int reportApprove(ReportVo reportVo) {
		return sqlSession.update(REPORT_NS+"reportApprove",reportVo);
	}
	//신고승인시 경고횟수누적
	@Override
	public int reportCountAdd(ReportVo reportId) {
		return sqlSession.update(REPORT_NS+"reportCountAdd",reportId);
	}
	//누적신고횟수확인
	@Override
	public int reportCountSelect(ReportVo reportId) {
		return sqlSession.selectOne(REPORT_NS+"reportCountSelect",reportId);
	}
	//신고횟수누적시 회원상태변경
	@Override
	public int actStateModify(ReportVo reportId) {
		return sqlSession.update(REPORT_NS+"actStateModify",reportId);
	}


}
