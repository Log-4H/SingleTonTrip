package com.log4h.singletontrip.reserve.controller;

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

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentCateVo;
import com.log4h.singletontrip.reserve.service.ReserveService;

@Controller
@SessionAttributes({"sessionId", "sessionLevel"})
public class ReserveController {
	Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired
	private ReserveService reserveService;

	// 방 예약내역 리스트
	@RequestMapping(value="/reserve/reserveList",method=RequestMethod.GET)
	public ModelAndView reserveList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectOption", defaultValue="0") int selectOption,
			@RequestParam(value="selectValue", required=false) String selectValue			
			){
		ModelAndView mv = new ModelAndView();
		
		LoginVo login = new LoginVo();
		login.setMemberId(sessionId);
		login.setMemberLevel(sessionLevel);
		logger.debug("login에 담긴 값 : {} ", login);
		
		Map<String, Object> getMap = reserveService.getReserveList(currentPage,login, selectOption, selectValue);
		logger.debug(" >>>>>>> getReserveList에서 리턴 받는 map : \n {} <<<<<<< ",getMap);
		
		mv.addObject("map", getMap);
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		
		mv.setViewName("/company/reserve/reserveList");
		
		return mv;
		
	}
	
	// 결제내역 리스트
	@RequestMapping(value="/payment/payList",method=RequestMethod.GET)
	public ModelAndView payList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectOption", defaultValue="0") int selectOption,
			@RequestParam(value="selectValue", required=false) String selectValue			
			){
		ModelAndView mv = new ModelAndView();
		
		LoginVo login = new LoginVo();
		login.setMemberId(sessionId);
		login.setMemberLevel(sessionLevel);
		logger.debug("login에 담긴 값 : {} ", login);
		
		List<PaymentCateVo> paymentCate = reserveService.getPaymentCate();
		
		mv.addObject("cateList",paymentCate);
		
		Map<String, Object> getMap = reserveService.getPayList(currentPage, login, selectOption, selectValue);
		
/*		
		logger.debug(" >>>>>>> getReserveList에서 리턴 받는 map : \n {} <<<<<<< ",getMap);
		 
		mv.addObject("map", getMap);
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		*/
		mv.setViewName("/payment/payList");
		
		return mv;
		
	}
	
/*	
	@RequestMapping(value="/payment/payAdd",method=RequestMethod.GET)
	public ModelAndView payAdd(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectOption", defaultValue="0") int selectOption,
			@RequestParam(value="selectValue", required=false) String selectValue			
			){
		ModelAndView mv = new ModelAndView();
		
		LoginVo login = new LoginVo();
		login.setMemberId(sessionId);
		login.setMemberLevel(sessionLevel);
		logger.debug("login에 담긴 값 : {} ", login);
		Map<String, Object> getMap = reserveService.getReserveList(currentPage,login, selectOption, selectValue);
		logger.debug(" >>>>>>> getReserveList에서 리턴 받는 map : \n {} <<<<<<< ",getMap);
		
		mv.addObject("map", getMap);
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		
		mv.setViewName("/payment/payAdd");
		
		return mv;
		
	}
	*/
	
}
