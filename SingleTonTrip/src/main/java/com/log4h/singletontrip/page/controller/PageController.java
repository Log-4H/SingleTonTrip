package com.log4h.singletontrip.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.page.domain.PostVo;
import com.log4h.singletontrip.page.service.PageService;

@SessionAttributes({"sessionId", "sessionLibrary"})
@Controller
public class PageController {

	@Autowired
	private PageService pageService;
	//포스트 리스트
	@RequestMapping(value="person/postList", method=RequestMethod.GET)
	public ModelAndView postList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="beginRow", defaultValue="0") int beginRow){
		List<PostVo> postList = pageService.postList(memberId, beginRow);
		ModelAndView mv = new ModelAndView("person/post/postList");
		mv.addObject("postList", postList);
		return mv;	
	}
	
	//포스트 리스트
	@RequestMapping(value="person/postAddList", method=RequestMethod.POST)
	public ModelAndView postAddList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="beginRow", defaultValue="1") int beginRow){
		List<PostVo> postList = pageService.postList(memberId, beginRow);
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("postList", postList);
		return mv;	
	}
	
	//포스트 등록
	@RequestMapping(value="person/postAdd", method=RequestMethod.POST)
	public ModelAndView postAdd(PostVo postVo,
			@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="imgFile", required=false) MultipartFile imgFile){
		postVo.setMemberId(memberId);
		int result = pageService.postAdd(postVo, imgFile);
		ModelAndView mv = new ModelAndView();
		if(result>0){
			mv.setViewName("redirect:postList");
		}else{
			mv.setViewName("error");
		}
		return mv;	
	}
}
