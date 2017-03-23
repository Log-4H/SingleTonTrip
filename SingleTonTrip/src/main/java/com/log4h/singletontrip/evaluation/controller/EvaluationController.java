package com.log4h.singletontrip.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.evaluation.domain.EvaluationCheckVo;
import com.log4h.singletontrip.evaluation.service.EvaluationService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel", "pageId"})
@Controller
public class EvaluationController {

	@Autowired
	private EvaluationService evaluationService;
	
	//업체평가체크
	@RequestMapping(value="evaluationCheck")
	public ModelAndView evaluationCheck(@ModelAttribute("pageId") String pageId,
			@ModelAttribute("sessionId") String sessionId,
			@RequestParam(value="pageLevel") int pageLevel){
		ModelAndView mv = new ModelAndView("jsonView");
		List<EvaluationCheckVo> checkList = evaluationService.evaluationCheck(sessionId, pageId, pageLevel);
		mv.addObject("checkList", checkList);
		return mv;	
	}
}
