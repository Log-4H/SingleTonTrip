package com.log4h.singletontrip.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.member.domain.Member;
import com.log4h.singletontrip.member.service.MemberService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("member/login/memberLogin");
		return mv;	
	}
	
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="loginId") String loginId, 
			@RequestParam(value="loginPw") String loginPw){
		ModelAndView mv = new ModelAndView("index");
		Member member = memberService.login(loginId, loginPw);
		mv.addObject("sessionId", member.getMemberId());
		mv.addObject("sessionNm", member.getMemberNm());
		mv.addObject("sessionLevel", member.getMemberLevel());
		return mv;	
	}
}
