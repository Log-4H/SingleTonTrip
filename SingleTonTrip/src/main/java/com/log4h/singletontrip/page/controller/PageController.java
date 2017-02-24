package com.log4h.singletontrip.page.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.page.domain.PostCommentVo;
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
		ModelAndView mv = new ModelAndView("person/post/postList");
		Map<String, Object> map = pageService.postList(memberId, beginRow);
		mv.addObject("postList", map.get("postList"));
		mv.addObject("postCommentList", map.get("postCommentList"));
		return mv;	
	}
	//포스트 리스트 추가
	@RequestMapping(value="person/postAddList", method=RequestMethod.POST)
	public ModelAndView postAddList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="beginRow") int beginRow){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = pageService.postList(memberId, beginRow);
		mv.addObject("postList", map.get("postList"));
		mv.addObject("postCommentList", map.get("postCommentList"));
		return mv;
	}
	//포스트 등록
	@RequestMapping(value="person/postAdd", method=RequestMethod.POST)
	public ModelAndView postAdd(MultipartHttpServletRequest multi,
			@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="beginRow", defaultValue="0") int beginRow){
		ModelAndView mv = new ModelAndView("jsonView");
		PostVo postVo = new PostVo();
		String postTitle = multi.getParameter("postTitle");
		String postContent = multi.getParameter("postContent");
		postVo.setPostTitle(postTitle);
		postVo.setPostContent(postContent);
		postVo.setMemberId(memberId);
		MultipartFile imgFile = multi.getFile("imgFile");
		int result = pageService.postAdd(postVo, imgFile);
		if(result>0){
			Map<String, Object> map = pageService.postList(memberId, beginRow);
			mv.addObject("postList", map.get("postList"));
			mv.addObject("postCommentList", map.get("postCommentList"));
		}
		return mv;	
	}
	
	//댓글 등록
	@RequestMapping(value="person/postCommentAdd", method=RequestMethod.POST)
	public ModelAndView postCommentAdd(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="postCommentContent") String postCommentContent){
		System.out.println(postNo);
		ModelAndView mv = new ModelAndView("jsonView");
		List<PostCommentVo> commentList= pageService.postCommentAdd(postNo, memberId, postCommentContent);
		mv.addObject("commentList", commentList);
		return mv;
	}
}
