package com.log4h.singletontrip.evaluation.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.evaluation.domain.CompanyEvaluationVo;
import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.domain.PersonEvaluationVo;

public interface EvaluationDao {
	
	public List<EvaluationCheckVo> companyEvaluationCheck(Map<String,Object> map);
	
	public List<EvaluationCheckVo> personEvaluationCheck(Map<String,Object> map);
	
	public int companyEvaluationAdd(CompanyEvaluationVo companyEvaluationVo);
	
	public int personEvaluationAdd(PersonEvaluationVo personEvaluationVo);

	public List<CompanyEvaluationVo> companyEvaluationList(Map<String,Object> map);
	
	public List<PersonEvaluationVo> personEvaluationList(Map<String,Object> map);
}
