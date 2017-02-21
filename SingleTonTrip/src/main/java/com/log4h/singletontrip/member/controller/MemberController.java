package com.log4h.singletontrip.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.service.MemberService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//로그인 폼 요청
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("member/login/memberLogin");
		return mv;	
	}

	//로그인 처리
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="loginId") String loginId, 
			@RequestParam(value="loginPw") String loginPw){
		ModelAndView mv = new ModelAndView("index");
		LoginVo loginVo = memberService.login(loginId, loginPw);
		mv.addObject("sessionId", loginVo.getMemberId());
		mv.addObject("sessionNm", loginVo.getMemberNm());
		mv.addObject("sessionLevel", loginVo.getMemberLevel());
		return mv;	
	}

	//로그아웃 처리
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(SessionStatus status){
		ModelAndView mv = new ModelAndView("redirect:index");
		status.setComplete();
		return mv;	
	}
}
