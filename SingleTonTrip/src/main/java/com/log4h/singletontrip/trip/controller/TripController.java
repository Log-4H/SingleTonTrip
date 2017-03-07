package com.log4h.singletontrip.trip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.trip.domain.TripVo;
import com.log4h.singletontrip.trip.service.TripService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
@Controller
public class TripController {

	@Autowired
	private TripService tripService;
	
	//여행 리스트
	@RequestMapping(value="person/tripList")
	public ModelAndView tripList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow){
		ModelAndView mv = new ModelAndView("jsonView");
		List<TripVo> tripList= tripService.tripList(memberId, lastTripRow);
		mv.addObject("tripList", tripList);
		return mv;	
	}
	//여행 상세보기
	@RequestMapping(value="person/tripView")
	public ModelAndView tripView(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = tripService.tripView(memberId, tripNo);
		mv.addObject("trip", map.get("trip"));
		mv.addObject("planList", map.get("planList"));
		return mv;	
	}
}
