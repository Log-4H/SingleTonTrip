package com.log4h.singletontrip.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.member.controller.MemberController;
import com.log4h.singletontrip.report.service.ReportService;

@Controller
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private ReportService reportService;
	
	//신고요청폼
	@RequestMapping(value="reportAdd", method=RequestMethod.GET)
	public ModelAndView reprot(){
		ModelAndView mv = new ModelAndView("report/memberReport");
		return mv;	
	}
	
	//신고요청
		@RequestMapping(value="reportAdd", method=RequestMethod.POST)
		public ModelAndView reprotadd(){
			ModelAndView mv = new ModelAndView("report/reportList");
			return mv;	
		}
	
	//신고리스트
		@RequestMapping(value="reportList", method=RequestMethod.GET)
		public ModelAndView reprotList(){
			ModelAndView mv = new ModelAndView("report/reportList");
			return mv;	
		}
}
