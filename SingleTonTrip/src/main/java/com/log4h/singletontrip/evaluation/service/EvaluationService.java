package com.log4h.singletontrip.evaluation.service;

import java.util.List;

import com.log4h.singletontrip.evaluation.domain.CompanyEvaluationVo;
import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.domain.PersonEvaluationVo;

public interface EvaluationService {
	//회원 평가 체크
	public List<EvaluationCheckVo> evaluationCheck(String memberId, String pageId, int pageLevel);
	//회원 평가 등록
	public int evaluationAdd(String memberId, String pageId, int pageLevel, int selectEvaluationList, String evaluationAddContent, int evaluationAddRating);
	//업체 평가리스트
	public List<CompanyEvaluationVo> companyEvaluationList(String pageId, int lastEvaluationRow);
	//회원 평가리스트
	public List<PersonEvaluationVo> personEvaluationList(String pageId, int lastEvaluationRow);
}
