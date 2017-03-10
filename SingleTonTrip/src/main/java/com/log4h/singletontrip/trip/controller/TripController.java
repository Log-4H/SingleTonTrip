package com.log4h.singletontrip.trip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
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
	//여행등록폼 요청
	@RequestMapping(value="person/tripAdd", method=RequestMethod.GET)
	public ModelAndView tripAdd(){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = tripService.tripAddForm();
		mv.addObject("tripThemeList", map.get("tripThemeList"));
		mv.addObject("regionDoList", map.get("regionDoList"));
		return mv;
	}
	//여행지역(시) 리스트 출력
	@RequestMapping(value="person/regionSiList", method=RequestMethod.POST)
	public ModelAndView regionSiList(@RequestParam(value="regionDo") String regionDo){
		ModelAndView mv = new ModelAndView("jsonView");
		List<RegionVo> regionSiList = tripService.regionSiList(regionDo);
		mv.addObject("regionSiList", regionSiList);
		return mv;
	}
	
	//여행등록처리
	@RequestMapping(value="person/tripAdd", method=RequestMethod.POST)
	public ModelAndView tripAdd(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow, TripVo tripVo){
		ModelAndView mv = new ModelAndView("jsonView");
		tripVo.setPersonId(memberId);
		int result = tripService.tripAdd(tripVo);
		if(result>0){
			List<TripVo> tripList= tripService.tripList(memberId, lastTripRow);
			mv.addObject("tripList", tripList);
		}
		return mv;
	}
	//여행일정 등록
	@RequestMapping(value="person/planAdd", method=RequestMethod.POST)
	public ModelAndView planAdd(@ModelAttribute("sessionId") String memberId, PlanVo planVo){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.planAdd(planVo);
		if(result>0){
			Map<String, Object> map = tripService.tripView(memberId, planVo.getTripNo());
			mv.addObject("trip", map.get("trip"));
			mv.addObject("planList", map.get("planList"));
		}
		return mv;
	}
}
