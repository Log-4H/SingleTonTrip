package com.log4h.singletontrip.evaluation.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.evaluation.domain.CompanyEvaluationVo;
import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.domain.PersonEvaluationVo;

@Repository
public class EvaluationDaoImpl implements EvaluationDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String EVALUATION_NS = "evaluationMapper.";
	//업체평가리스트
	@Override
	public List<CompanyEvaluationVo> companyEvaluationList(Map<String, Object> map) {
		return sqlSession.selectList(EVALUATION_NS+"companyEvaluationList", map);
	}
	//개인평가리스트
	@Override
	public List<PersonEvaluationVo> personEvaluationList(Map<String, Object> map) {
		return sqlSession.selectList(EVALUATION_NS+"personEvaluationList", map);
	}
	//업체평가체크
	@Override
	public List<EvaluationCheckVo> companyEvaluationCheck(Map<String, Object> map) {
		return sqlSession.selectList(EVALUATION_NS+"companyEvaluationCheck", map);
	}
	//개인평가체크
	@Override
	public List<EvaluationCheckVo> personEvaluationCheck(Map<String, Object> map) {
		return sqlSession.selectList(EVALUATION_NS+"personEvaluationCheck", map);
	}
	//업체 평가 등록
	@Override
	public int companyEvaluationAdd(CompanyEvaluationVo companyEvaluationVo) {
		return sqlSession.insert(EVALUATION_NS+"companyEvaluationAdd", companyEvaluationVo);
	}
	//개인평가등록
	@Override
	public int personEvaluationAdd(PersonEvaluationVo personEvaluationVo) {
		return sqlSession.insert(EVALUATION_NS+"personEvaluationAdd", personEvaluationVo);
	}
	//업체 평가 횟수 조회
	@Override
	public int companyEvaluationCount(String pageId) {
		return sqlSession.selectOne(EVALUATION_NS+"companyEvaluationCount", pageId);
	}
	//개인 평가 횟수 조회
	@Override
	public int personEvaluationCount(String pageId) {
		return sqlSession.selectOne(EVALUATION_NS+"personEvaluationCount", pageId);
	}
	//회원 평가점수조회
	@Override
	public double selectEvaluationRating(String pageId) {
		return sqlSession.selectOne(EVALUATION_NS+"selectEvaluationRating", pageId);
	}
	//회원 평가점수 업데이트
	@Override
	public int updateEvaluationRating(Map<String, Object> map) {
		return sqlSession.update(EVALUATION_NS+"updateEvaluationRating", map);
	}
	
	
	

	
}
