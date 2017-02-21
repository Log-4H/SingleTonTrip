package com.log4h.singletontrip.evaluation.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EvaluationDaoImpl implements EvaluationDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String EVALUATION_NS = "evaluationMapper.";
}
