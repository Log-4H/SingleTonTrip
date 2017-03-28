package com.log4h.singletontrip.board.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.board.domain.BoardVo;
import com.log4h.singletontrip.board.service.BoardService;

@Controller
@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
public class BoardController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	
	//공지사항
	@RequestMapping(value="notice", method=RequestMethod.GET)
	public ModelAndView notice(
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView("board/notice/noticeList");
		Map<String, Object> getMap =  boardService.boardList(currentPage,4);
		mv.addObject("currentPage", currentPage);
		mv.addObject("boardList", getMap.get("boardList"));
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		return mv;
	}
	
	//공지사항등록
	@RequestMapping(value="noticeAdd", method=RequestMethod.POST)
	public ModelAndView noticeAdd(BoardVo boardVo,
			@ModelAttribute("sessionId") String sessionId){
		boardVo.setMemberId(sessionId);
		ModelAndView mv = new ModelAndView("redirect:notice");
		int result =  boardService.boardAdd(boardVo);
		return mv;
	}
	//FAQ
	@RequestMapping(value="faq", method=RequestMethod.GET)
	public ModelAndView faq(
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView("board/faq/faqList");
		Map<String, Object> getMap =  boardService.boardList(currentPage,3);
		mv.addObject("currentPage", currentPage);
		mv.addObject("boardList", getMap.get("boardList"));
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		return mv;
	}
	//FAQ 등록
	@RequestMapping(value="faqAdd", method=RequestMethod.POST)
	public ModelAndView faqAdd(BoardVo boardVo,
			@ModelAttribute("sessionId") String sessionId){
		boardVo.setMemberId(sessionId);
		ModelAndView mv = new ModelAndView("redirect:faq");
		int result =  boardService.boardAdd(boardVo);
		return mv;
	}
	//1:1문의리스트
	@RequestMapping(value="qnaOne", method=RequestMethod.GET)
	public ModelAndView oneQna(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/qnaOne/qnaOneList");
		Map<String, Object> getMap =  boardService.boardList(currentPage,1, sessionId, sessionLevel);
		mv.addObject("currentPage", currentPage);
		mv.addObject("boardList", getMap.get("boardList"));
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		return mv;
	}
	//1:1 문의
	@RequestMapping(value="qnaOneAdd", method=RequestMethod.POST)
	public ModelAndView qnaOneAdd(BoardVo boardVo,
			@ModelAttribute("sessionId") String sessionId){
		boardVo.setMemberId(sessionId);
		ModelAndView mv = new ModelAndView("redirect:qnaOne");
		int result =  boardService.boardAdd(boardVo);
		return mv;
	}
	//광고문의리스트
	@RequestMapping(value="qnaAd", method=RequestMethod.GET)
	public ModelAndView adQna(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/qnaAd/qnaAdList");
		Map<String, Object> getMap =  boardService.boardList(currentPage,2, sessionId, sessionLevel);
		mv.addObject("currentPage", currentPage);
		mv.addObject("boardList", getMap.get("boardList"));
		mv.addObject("startPage", getMap.get("startPage"));
		mv.addObject("pageSize", getMap.get("pageSize"));
		mv.addObject("endPage", getMap.get("endPage"));
		mv.addObject("lastPage", getMap.get("lastPage"));
		return mv;
	}
	//광고문의
	@RequestMapping(value="qnaAdAdd", method=RequestMethod.POST)
	public ModelAndView qnaAdAdd(BoardVo boardVo,
			@ModelAttribute("sessionId") String sessionId){
		boardVo.setMemberId(sessionId);
		ModelAndView mv = new ModelAndView("redirect:qnaAd");
		int result =  boardService.boardAdd(boardVo);
		return mv;
	}
	//상세보기
	@RequestMapping(value="boardDetail")
	public ModelAndView noticeDetail(@RequestParam(value="boardNo") int boardNo){
		ModelAndView mv = new ModelAndView("jsonView");
		BoardVo board =  boardService.boardDetail(boardNo);
		mv.addObject("board", board);
		return mv;
	}
	//qna상세보기
	@RequestMapping(value="qnaDetail")
	public ModelAndView qnaDetail(@RequestParam(value="boardNo") int boardNo){
		ModelAndView mv = new ModelAndView("jsonView");
		BoardVo board =  boardService.qnaDetail(boardNo);
		mv.addObject("board", board);
		return mv;
	}
}



