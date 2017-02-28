package com.log4h.singletontrip.reserve.controller;

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

import com.log4h.singletontrip.reserve.service.ReserveService;

@Controller
@SessionAttributes({"sessionId", "sessionLevel"})
public class ReserveController {
	Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired
	private ReserveService reserveService;
	
	@RequestMapping(value="compony/reserve/reserveList",method=RequestMethod.GET)
	public ModelAndView reserveList(
			@ModelAttribute("seesionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage
			
			
			){
		ModelAndView mv = new ModelAndView();
		
		
		
		
		mv.setViewName("compony/reserve/reserveList");
		
		return mv;
		
	}
	
	
}
