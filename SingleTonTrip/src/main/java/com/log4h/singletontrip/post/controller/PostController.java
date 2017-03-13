package com.log4h.singletontrip.post.controller;

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

import com.log4h.singletontrip.post.domain.PostCommentVo;
import com.log4h.singletontrip.post.domain.PostVo;
import com.log4h.singletontrip.post.service.PostService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel", "pageId"})
@Controller
public class PostController {
	@Autowired
	private PostService postService;
	//페이지메인
	@RequestMapping(value="pageMain", method=RequestMethod.GET)
	public ModelAndView postMain(@RequestParam(value="pageId") String pageId,
			@RequestParam(value="lastPostRow", defaultValue="10") int lastPostRow){
		ModelAndView mv = new ModelAndView("page/pageMain");
		String pageLevel = postService.pageLevel(pageId);
		List<PostVo> postList= postService.postList(pageId, lastPostRow);
		mv.addObject("pageId", pageId);
		mv.addObject("pageLevel", pageLevel);
		mv.addObject("postList", postList);
		return mv;	
	}
	//포스트 리스트 추가
	@RequestMapping(value="postList", method=RequestMethod.POST)
	public ModelAndView postList(@ModelAttribute(value="pageId") String pageId,
			@RequestParam(value="lastPostRow", defaultValue="10") int lastPostRow){
		ModelAndView mv = new ModelAndView("jsonView");
		List<PostVo> postList= postService.postList(pageId, lastPostRow);
		mv.addObject("postList", postList);
		return mv;	
	}

	//포스트 등록
	@RequestMapping(value="postAdd", method=RequestMethod.POST)
	public ModelAndView postAdd(MultipartHttpServletRequest multi,
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastPostRow", defaultValue="10") int lastPostRow){
		ModelAndView mv = new ModelAndView("jsonView");
		PostVo postVo = new PostVo();
		String postTitle = multi.getParameter("postTitle");
		String postContent = multi.getParameter("postContent");
		postVo.setPostTitle(postTitle);
		postVo.setPostContent(postContent);
		postVo.setMemberId(sessionId);
		MultipartFile imgFile = multi.getFile("imgFile");
		int result = postService.postAdd(postVo, imgFile);
		if(result>0){
			List<PostVo> postList= postService.postList(pageId, lastPostRow);
			mv.addObject("postList", postList);
		}
		return mv;	
	}
	//포스트 수정
	@RequestMapping(value="postModify", method=RequestMethod.POST)
	public ModelAndView postModify(MultipartHttpServletRequest multi,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastPostRow", defaultValue="10") int lastPostRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int postNo = Integer.parseInt(multi.getParameter("postModifyNo"));
		String postTitle = multi.getParameter("postModifyTitle");
		String postContent = multi.getParameter("postModifyContent");
		MultipartFile imgFile = multi.getFile("imgFile");
		int result = postService.postModify(postNo, postTitle, postContent, imgFile);
		if(result>0){
			List<PostVo> postList= postService.postList(pageId, lastPostRow);
			mv.addObject("postList", postList);
		}
		return mv;	
	}
	//포스트 삭제
	@RequestMapping(value="postDelete", method=RequestMethod.POST)
	public ModelAndView postDelete(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastPostRow", defaultValue="10") int lastPostRow,
			@RequestParam(value="postNo") int postNo){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = postService.postDelete(postNo);
		if(result>0){
			List<PostVo> postList= postService.postList(pageId, lastPostRow);
			mv.addObject("postList", postList);
		}
		return mv;	
	}
	
	//댓글 리스트
	@RequestMapping(value="postCommentList", method=RequestMethod.POST)
	public ModelAndView postCommentList(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="lastCommentRow", defaultValue="10") int lastCommentRow){
		ModelAndView mv = new ModelAndView("jsonView");
		List<PostCommentVo> postCommentList= postService.postCommentList(postNo, pageId, lastCommentRow);
		mv.addObject("postCommentList", postCommentList);
		return mv;
	}	
	
	//댓글 등록
	@RequestMapping(value="postCommentAdd", method=RequestMethod.POST)
	public ModelAndView postCommentAdd(@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="postCommentContent") String postCommentContent,
			@RequestParam(value="lastCommentRow", defaultValue="10") int lastCommentRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = postService.postCommentAdd(postNo, sessionId, postCommentContent);
		if(result>0){
			List<PostCommentVo> postCommentList= postService.postCommentList(postNo, pageId, lastCommentRow);
			mv.addObject("postCommentList", postCommentList);
		}	
		return mv;
	}
	//댓글 삭제
	@RequestMapping(value="postCommentDelete", method=RequestMethod.POST)
	public ModelAndView postCommentDelete(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="postNo") int postNo,
			@RequestParam(value="postCommentNo") int postCommentNo,
			@RequestParam(value="lastCommentRow", defaultValue="10") int lastCommentRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = postService.postcommentDelete(postCommentNo);
		if(result>0){
			List<PostCommentVo> postCommentList= postService.postCommentList(postNo, pageId, lastCommentRow);
			mv.addObject("postCommentList", postCommentList);
		}
		return mv;
	}
	
	//포스트 조회
	@RequestMapping(value="postView", method=RequestMethod.POST)
	public ModelAndView postCommentDelete(
			@RequestParam(value="postNo") int postNo){
		ModelAndView mv = new ModelAndView("jsonView");
		PostVo post = postService.postView(postNo);
		mv.addObject("post", post);
		return mv;
	}
}
