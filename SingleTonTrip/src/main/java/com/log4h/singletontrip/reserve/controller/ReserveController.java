package com.log4h.singletontrip.reserve.controller;

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
import com.log4h.singletontrip.reserve.domain.PaymentVo;
import com.log4h.singletontrip.reserve.domain.ReserveVo;
import com.log4h.singletontrip.reserve.service.ReserveService;

@Controller
@SessionAttributes({"sessionId", "sessionLevel"})
public class ReserveController {
	Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired
	private ReserveService reserveService;

	// 방 예약내역 리스트
	@RequestMapping(value="reserveList",method=RequestMethod.GET)
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
		
		mv.setViewName("reserve/reserveList");
		
		return mv;
		
	}
	
	// 결제내역 리스트
	@RequestMapping(value="payList",method=RequestMethod.GET)
	public ModelAndView payList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectValue", required=false) String selectValue			
			){
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> getMap = reserveService.getPayList(currentPage, sessionId, sessionLevel,selectValue);
		mv.addObject("paymentCateList", getMap.get("paymentCateList"));
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectValue", selectValue);
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		mv.addObject("adPayList", getMap.get("adPayList"));
		mv.setViewName("/payment/payList");
		
		return mv;
		
	}
	
	// 예약
	@RequestMapping(value="reserveAdd",method=RequestMethod.POST)
	public ModelAndView reserveAdd(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="roomNo") int roomNo,
			@RequestParam(value="reserveCheckinDate") String reserveCheckinDate
			){
		ModelAndView mv = new ModelAndView();
		logger.debug(" >>>>>>> reserveAdd <<<<<<< ");
		Map<String, Object> map = reserveService.reserveInfo(sessionId, roomNo);		
		logger.debug(" >>>>>>> reserveCheckinDate {} ",reserveCheckinDate);
		mv.addObject("room", map.get("room"));
		mv.addObject("person", map.get("person"));
		mv.addObject("reserveCheckinDate", reserveCheckinDate);
		mv.setViewName("/reserve/reserveAdd");
		
		return mv;
		
	}
	// 결제 및 예약
	@RequestMapping(value="reserveInsert",method=RequestMethod.POST)
	public ModelAndView reserveInsert(PaymentVo payment, 
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value = "mileageUsePrice") int mileageUsePrice
			){
		ModelAndView mv = new ModelAndView();
		logger.debug("\n\n\n >>>>>>> reserveInsert <<<<<<< ");
		logger.debug(" >>>>>>> payment 받은 값 : {}", payment);
		
		int result = reserveService.reserveInsert(payment, sessionId, mileageUsePrice);
		logger.debug(" >>>>>>> reserveInsert result 값 : {}", result);
		if(result != 1 ){
			mv.setViewName("/error/error");
		}else{
			mv.setViewName("redirect:reserveList");
		}
		
		logger.debug(" >>>>>>> payment end <<<<<<< \n\n\n");
		return mv;
		
	}
	
	// 임시 예약 화면 보기	
	@RequestMapping(value="reserveAdd",method=RequestMethod.GET)
	public ModelAndView reserveAdd(){
		ModelAndView mv = new ModelAndView();
		logger.debug(" >>>>>>> reserveAdd <<<<<<< ");
		
		mv.setViewName("/reserve/reserveAdd");
		
		return mv;
		
	}

	
}
