package com.log4h.singletontrip.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
}
