package com.log4h.singletontrip.evaluation.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;

public interface EvaluationDao {
	
	public List<EvaluationCheckVo> companyEvaluationCheck(Map<String,Object> map);
	
	public List<EvaluationCheckVo> personEvaluationCheck(Map<String,Object> map);
}
