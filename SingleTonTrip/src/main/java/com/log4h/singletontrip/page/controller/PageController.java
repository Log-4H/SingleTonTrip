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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.page.domain.PostCommentVo;
import com.log4h.singletontrip.page.domain.PostVo;
import com.log4h.singletontrip.page.service.PageService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
@Controller
public class PageController {

	@Autowired
	private PageService pageService;
	
	//포스트 리스트
	@RequestMapping(value="person/personMain")
	public ModelAndView postList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="lastPostRow", defaultValue="5") int lastPostRow){
		ModelAndView mv = new ModelAndView();
		List<PostVo> postList= pageService.postList(memberId, lastPostRow);
		mv.addObject("postList", postList);
		if(lastPostRow==5){
			mv.setViewName("person/personMain");
		}else{
			mv.setViewName("jsonView");
		}
		return mv;	
	}

	//포스트 등록
	@RequestMapping(value="person/postAdd", method=RequestMethod.POST)
	public ModelAndView postAdd(MultipartHttpServletRequest multi,
			@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="lastPostRow", defaultValue="5") int lastPostRow){
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
			List<PostVo> postList= pageService.postList(memberId, lastPostRow);
			mv.addObject("postList", postList);
		}
		return mv;	
	}
	//포스트 수정
	@RequestMapping(value="person/postModify", method=RequestMethod.POST)
	public ModelAndView postModify(MultipartHttpServletRequest multi,
			@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="lastPostRow", defaultValue="5") int lastPostRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int postNo = Integer.parseInt(multi.getParameter("postModifyNo"));
		String postTitle = multi.getParameter("postModifyTitle");
		String postContent = multi.getParameter("postModifyContent");
		MultipartFile imgFile = multi.getFile("imgFile");
		int result = pageService.postModify(postNo, postTitle, postContent, imgFile);
		if(result>0){
			List<PostVo> postList= pageService.postList(memberId, lastPostRow);
			mv.addObject("postList", postList);
		}
		return mv;	
	}
	//포스트 삭제
	@RequestMapping(value="person/postDelete", method=RequestMethod.POST)
	public ModelAndView postDelete(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="lastPostRow", defaultValue="5") int lastPostRow,
			@RequestParam(value="postNo") int postNo){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = pageService.postDelete(postNo);
		if(result>0){
			List<PostVo> postList= pageService.postList(memberId, lastPostRow);
			mv.addObject("postList", postList);
		}
		return mv;	
	}
	
	//댓글 리스트
	@RequestMapping(value="person/postCommentList", method=RequestMethod.POST)
	public ModelAndView postCommentList(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="lastCommentRow", defaultValue="5") int lastCommentRow){
		ModelAndView mv = new ModelAndView("jsonView");
		List<PostCommentVo> postCommentList= pageService.postCommentList(postNo, memberId, lastCommentRow);
		mv.addObject("postCommentList", postCommentList);
		return mv;
	}	
	
	//댓글 등록
	@RequestMapping(value="person/postCommentAdd", method=RequestMethod.POST)
	public ModelAndView postCommentAdd(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="postCommentContent") String postCommentContent,
			@RequestParam(value="lastCommentRow", defaultValue="5") int lastCommentRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = pageService.postCommentAdd(postNo, memberId, postCommentContent);
		List<PostCommentVo> postCommentList= pageService.postCommentList(postNo, memberId, lastCommentRow);
		mv.addObject("postCommentList", postCommentList);
		return mv;
	}
	//댓글 삭제
	@RequestMapping(value="person/postCommentDelete", method=RequestMethod.POST)
	public ModelAndView postCommentDelete(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="postCommentNo") int postCommentNo,
			@RequestParam(value="lastCommentRow", defaultValue="5") int lastCommentRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = pageService.postcommentDelete(postCommentNo);
		List<PostCommentVo> postCommentList= pageService.postCommentList(postNo, memberId, lastCommentRow);
		mv.addObject("postCommentList", postCommentList);
		return mv;
	}
	
	//포스트 조회
	@RequestMapping(value="person/postView", method=RequestMethod.POST)
	public ModelAndView postCommentDelete(@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="postNo") int postNo){
		ModelAndView mv = new ModelAndView("jsonView");
		PostVo post = pageService.postView(postNo);
		mv.addObject("post", post);
		return mv;
	}
}
