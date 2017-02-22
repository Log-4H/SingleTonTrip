package com.log4h.singletontrip.page.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.page.domain.PostVo;
import com.log4h.singletontrip.page.service.PageService;

@Controller
public class PageController {

	@Autowired
	private PageService pageService;
	//포스트 리스트
	@RequestMapping(value="person/postList", method=RequestMethod.GET)
	public ModelAndView postList(HttpSession session){
		String memberId = (String) session.getAttribute("sessionId");
		List<PostVo> postList = pageService.postList(memberId);
		ModelAndView mv = new ModelAndView("person/post/postList");
		mv.addObject("postList", postList);
		return mv;	
	}
	//포스트 등록
	@RequestMapping(value="person/postAdd", method=RequestMethod.POST)
	public ModelAndView postAdd(HttpSession session, PostVo postVo,
			@RequestParam(value="imgFile", required=false) MultipartFile imgFile){
		String memberId = (String) session.getAttribute("sessionId");
		postVo.setMemberId(memberId);
		int result = pageService.postAdd(postVo, imgFile);
		ModelAndView mv = new ModelAndView("redirect:postList");
		return mv;	
	}
}
