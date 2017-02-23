package com.log4h.singletontrip.mileage.controller;

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

import com.log4h.singletontrip.mileage.service.MileageService;

@Controller
@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
public class MileageController {
	private static final Logger logger = LoggerFactory.getLogger(MileageController.class);
	
	@Autowired
	private MileageService mileageService;
	
	// 마일리지 리스트
	@RequestMapping(value="mileageList", method=RequestMethod.GET)
	public ModelAndView mileageList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage
			){
		logger.debug(" >>>>>>> mileageList <<<<<<< ");
		
		Map<String, Object> map = mileageService.mileageList(currentPage, memberId);
		logger.info(" >>>>>>> mileageList에서 리턴 받는 map : {} <<<<<<< ",map);
		
		//ModelAndView 객체 생성
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentPage", currentPage);
		mv.addObject("returnMileageList", map.get("returnMileageList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		
		mv.setViewName("mileage/mileageList");

		return mv;	
	}
	
		
		
		
	
	
}
