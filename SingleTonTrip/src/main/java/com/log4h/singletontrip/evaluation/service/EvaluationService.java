package com.log4h.singletontrip.evaluation.service;

import java.util.List;

import com.log4h.singletontrip.evaluation.domain.CompanyEvaluationVo;
import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.domain.PersonEvaluationVo;

public interface EvaluationService {

	public List<EvaluationCheckVo> evaluationCheck(String memberId, String pageId, int pageLevel);
	
	public int evaluationAdd(String memberId, String pageId, int pageLevel, int selectEvaluationList, String evaluationAddContent, int evaluationAddRating);
	
	public List<CompanyEvaluationVo> companyEvaluationList(String pageId, int lastEvaluationRow);
	
	public List<PersonEvaluationVo> personEvaluationList(String pageId, int lastEvaluationRow);
}
