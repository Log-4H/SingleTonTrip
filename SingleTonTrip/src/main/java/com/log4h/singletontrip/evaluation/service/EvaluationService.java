package com.log4h.singletontrip.evaluation.service;

import java.util.List;

import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;

public interface EvaluationService {

	public List<EvaluationCheckVo> evaluationCheck(String memberId, String pageId, int pageLevel);
	
}
