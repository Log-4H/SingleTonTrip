package com.log4h.singletontrip.evaluation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.repository.EvaluationDao;

@Service
public class EvaluationServiceImpl implements EvaluationService {
	@Autowired
	private EvaluationDao evaluationDao;

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
}
