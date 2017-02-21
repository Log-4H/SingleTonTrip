package com.log4h.singletontrip.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.evaluation.service.EvaluationService;

@Controller
public class EvaluationController {

	@Autowired
	private EvaluationService evaluationService;
}
