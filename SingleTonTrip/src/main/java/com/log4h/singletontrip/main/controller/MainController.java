package com.log4h.singletontrip.main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.main.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	//메인페이지
	@RequestMapping(value="main", method=RequestMethod.GET)
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}
	
	//*************검색바*****************
	//포스트 리스트 추가
	@RequestMapping(value="searchList", method=RequestMethod.POST)
	public ModelAndView searchList(@RequestParam(value="value") String value,
			@RequestParam(value="personCurrentPage", defaultValue="1") int personCurrentPage,
			@RequestParam(value="companyCurrentPage", defaultValue="1") int companyCurrentPage,
			@RequestParam(value="tripCurrentPage", defaultValue="1") int tripCurrentPage
			){
		ModelAndView mv = new ModelAndView("search/searchList");
		Map<String,Object> personMap = mainService.searchPersonList(value, personCurrentPage);
		Map<String,Object> companyMap = mainService.searchCompanyList(value, companyCurrentPage);
		Map<String,Object> tripMap = mainService.searchTripList(value, tripCurrentPage);
		mv.addObject("personMap", personMap);
		mv.addObject("companyMap", companyMap);
		mv.addObject("tripMap", tripMap);
		mv.addObject("value", value);
		return mv;	
	}
	//회원검색리스트
	@RequestMapping(value="searchPersonList", method=RequestMethod.POST)
	public ModelAndView searchPersonList(@RequestParam(value="value") String value,
			@RequestParam(value="personCurrentPage", defaultValue="1") int personCurrentPage
			){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> personMap = mainService.searchPersonList(value, personCurrentPage);
		mv.addObject("personMap", personMap);
		return mv;	
	}
	//업체검색리스트
	@RequestMapping(value="searchCompanyList", method=RequestMethod.POST)
	public ModelAndView searchCompanyList(@RequestParam(value="value") String value,
			@RequestParam(value="companyCurrentPage", defaultValue="1") int companyCurrentPage
			){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> companyMap = mainService.searchCompanyList(value, companyCurrentPage);
		mv.addObject("companyMap", companyMap);
		return mv;	
	}
	//여행검색리스트
	@RequestMapping(value="searchTripList", method=RequestMethod.POST)
	public ModelAndView searchTripList(@RequestParam(value="value") String value,
			@RequestParam(value="tripCurrentPage", defaultValue="1") int tripCurrentPage
			){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> tripMap = mainService.searchTripList(value, tripCurrentPage);
		mv.addObject("tripMap", tripMap);
		return mv;	
	}
}
