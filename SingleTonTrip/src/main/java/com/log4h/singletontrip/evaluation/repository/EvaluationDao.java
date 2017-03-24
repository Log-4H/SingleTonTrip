package com.log4h.singletontrip.evaluation.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.evaluation.domain.CompanyEvaluationVo;
import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.domain.PersonEvaluationVo;

public interface EvaluationDao {
	//업체평가리스트
	public List<CompanyEvaluationVo> companyEvaluationList(Map<String,Object> map);
	//개인평가리스트	
	public List<PersonEvaluationVo> personEvaluationList(Map<String,Object> map);
	//업체평가체크
	public List<EvaluationCheckVo> companyEvaluationCheck(Map<String,Object> map);
	//개인평가체크
	public List<EvaluationCheckVo> personEvaluationCheck(Map<String,Object> map);
	//업체 평가 등록
	public int companyEvaluationAdd(CompanyEvaluationVo companyEvaluationVo);
	//개인평가등록
	public int personEvaluationAdd(PersonEvaluationVo personEvaluationVo);
	//업체 평가 횟수 조회
	public int companyEvaluationCount(String pageId);
	//개인 평가 횟수 조회
	public int personEvaluationCount(String pageId);
	//회원 평가점수조회
	public double selectEvaluationRating(String pageId);
	//회원 평가점수 업데이트
	public int updateEvaluationRating(Map<String,Object> map);
	


	
}
