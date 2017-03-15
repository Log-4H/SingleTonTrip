package com.log4h.singletontrip.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	//포스트 리스트 추가
	@RequestMapping(value="autocomplete", method=RequestMethod.POST)
	public ModelAndView autocomplete(@RequestParam(value="value") String value){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> map = adminService.searchList(value);
		mv.addObject("tripList", map.get("tripList"));
		return mv;	
	}
}
