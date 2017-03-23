package com.log4h.singletontrip.evaluation.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;

@Repository
public class EvaluationDaoImpl implements EvaluationDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String EVALUATION_NS = "evaluationMapper.";

	@Override
	public List<EvaluationCheckVo> companyEvaluationCheck(Map<String, Object> map) {
		return sqlSession.selectList(EVALUATION_NS+"companyEvaluationCheck", map);
	}
	@Override
	public List<EvaluationCheckVo> personEvaluationCheck(Map<String, Object> map) {
		return sqlSession.selectList(EVALUATION_NS+"personEvaluationCheck", map);
	}
}
