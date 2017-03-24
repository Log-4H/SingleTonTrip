package com.log4h.singletontrip.evaluation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.evaluation.domain.CompanyEvaluationVo;
import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.domain.PersonEvaluationVo;
import com.log4h.singletontrip.evaluation.repository.EvaluationDao;

@Service
public class EvaluationServiceImpl implements EvaluationService {
	@Autowired
	private EvaluationDao evaluationDao;
	//회원 평가 체크
	@Override
	public List<EvaluationCheckVo> evaluationCheck(String memberId, String pageId, int pageLevel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("pageId", pageId);
		List<EvaluationCheckVo> checkList = new ArrayList<EvaluationCheckVo>();
		if(pageLevel == 2){
			checkList = evaluationDao.companyEvaluationCheck(map);
		}else if(pageLevel ==3){
			checkList = evaluationDao.personEvaluationCheck(map);
		}
		return checkList;
	}
	//회원 평가 등록
	@Transactional
	@Override
	public int evaluationAdd(String memberId, String pageId, int pageLevel, int selectEvaluationList,
			String evaluationAddContent, int evaluationAddRating) {
		int addResult = 0;
		int result = 0;
		int totalCount = 0;
		double evaluationRating = 0;
		double updateRating = 0;
		if(pageLevel == 2){
			CompanyEvaluationVo companyEvaluationVo = new CompanyEvaluationVo();
			companyEvaluationVo.setMemberId(memberId);
			companyEvaluationVo.setCompanyId(pageId);
			companyEvaluationVo.setReserveNo(selectEvaluationList);
			companyEvaluationVo.setCompanyEvaluationContent(evaluationAddContent.replaceAll("\r\n", "<br>"));
			companyEvaluationVo.setCompanyEvaluationRating(evaluationAddRating);
			addResult = evaluationDao.companyEvaluationAdd(companyEvaluationVo);
			if(addResult>0){
				totalCount = evaluationDao.companyEvaluationCount(pageId);
				evaluationRating = evaluationDao.selectEvaluationRating(pageId);
				updateRating = (evaluationRating * (totalCount-1) + evaluationAddRating)/totalCount;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pageId", pageId);
				map.put("updateRating", updateRating);
				result = evaluationDao.updateEvaluationRating(map);
			}
		}else if(pageLevel ==3){
			PersonEvaluationVo personEvaluationVo= new PersonEvaluationVo();
			personEvaluationVo.setMemberId(memberId);
			personEvaluationVo.setPersonId(pageId);
			personEvaluationVo.setTripNo(selectEvaluationList);
			personEvaluationVo.setPersonEvaluationContent(evaluationAddContent.replaceAll("\r\n", "<br>"));
			personEvaluationVo.setPersonEvaluationRating(evaluationAddRating);
			addResult = evaluationDao.personEvaluationAdd(personEvaluationVo);
			if(addResult>0){
				totalCount = evaluationDao.companyEvaluationCount(pageId);
				evaluationRating = evaluationDao.selectEvaluationRating(pageId);
				updateRating = (evaluationRating * (totalCount-1) + evaluationAddRating)/totalCount;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pageId", pageId);
				map.put("updateRating", updateRating);
			}
		}
		return result;
	}
	//업체 평가리스트
	@Override
	public List<CompanyEvaluationVo> companyEvaluationList(String pageId, int lastEvaluationRow) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageId", pageId);
		map.put("lastEvaluationRow", lastEvaluationRow);
		List<CompanyEvaluationVo> evaluationList = evaluationDao.companyEvaluationList(map);
		return evaluationList;
	}
	//회원 평가리스트
	@Override
	public List<PersonEvaluationVo> personEvaluationList(String pageId, int lastEvaluationRow) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageId", pageId);
		map.put("lastEvaluationRow", lastEvaluationRow);
		List<PersonEvaluationVo> evaluationList = evaluationDao.personEvaluationList(map);
		return evaluationList;
	}
}
