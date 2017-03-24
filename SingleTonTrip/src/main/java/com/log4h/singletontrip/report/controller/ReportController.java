package com.log4h.singletontrip.report.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.member.controller.MemberController;
import com.log4h.singletontrip.report.domain.ReportTypeVo;
import com.log4h.singletontrip.report.domain.ReportVo;
import com.log4h.singletontrip.report.service.ReportService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel", "pageId"})
@Controller
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private ReportService reportService;
	
	//신고하기폼요청
	@RequestMapping(value="reportAdd", method=RequestMethod.GET)
	public ModelAndView reprot(@RequestParam(value="reportId", required=false) String reportId){
		ModelAndView mv = new ModelAndView("report/memberReport");
		if(reportId != null){
			mv.addObject("reportId", reportId);
		}
		List<ReportTypeVo> reportTypeList = reportService.reportTypeList();
		mv.addObject("reportTypeList",reportTypeList);
		return mv;	
	}
	
	//신고하기
	@RequestMapping(value="reportAdd", method=RequestMethod.POST)
	public ModelAndView reprotadd(ReportVo reportVo,
			@ModelAttribute("sessionId") String sessionId){
		System.out.println(reportVo.toString());
		ModelAndView mv = new ModelAndView("report/reportList");
		reportVo.setMemberId(sessionId);
		int result = reportService.reportAdd(reportVo);
		if (result > 0) {
			mv.setViewName("redirect:reportList");
			
		} else {
			mv.setViewName("error/error");
		}
		return mv;	
	}
	
	//신고리스트
	@RequestMapping(value="reportList", method=RequestMethod.GET)
	public ModelAndView reprotList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage){
		Map<String, Object> map = reportService.reportList(currentPage, sessionId, sessionLevel);
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentPage", currentPage);
		mv.addObject("reportList", map.get("reportList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		if (sessionLevel == 1) {
			mv.setViewName("report/adminReportList");
		}else{
			mv.setViewName("report/reportList");
		}
			
		return mv;
	}
		
	//신고리스트상세보기
	@RequestMapping(value = "reportDetail", method = RequestMethod.GET)
	public ModelAndView reportDetail(
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value = "reportNo") int reportNo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("reportVo", reportService.reportDetail(reportNo));
		if(sessionLevel == 1){
			mv.setViewName("report/adminReportDetail");
		}else{
			mv.setViewName("report/reportDetail");
		}
		return mv;
	}

	//신고내용수락&거절

}
