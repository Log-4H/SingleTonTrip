package com.log4h.singletontrip.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;
import com.log4h.singletontrip.board.service.BoardService;

@Controller
@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
public class BoardController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	
	//FAQ등록
	@RequestMapping(value="faqAdd" , method=RequestMethod.GET)
	public ModelAndView faqAdd(){
		ModelAndView mv = new ModelAndView();
		List<BoardCateVo> list = new ArrayList<BoardCateVo>();
		list = boardService.findFaqCate();
		mv.addObject("faqCate", list);
		mv.setViewName("board/faq/faqAdd");
	return mv;	
	}
	
	//FAQ등록처리
	@RequestMapping(value="faqAdd" , method=RequestMethod.POST)
	public ModelAndView faqAdd(BoardVo board,
			@ModelAttribute("sessionId") String sessionId){
		logger.debug(" >>>>>>> faqAdd <<<<<<< ");
		logger.debug(" >>>>>>> board 값 : {},\n sessionId 값 : {} ",board,sessionId);
		ModelAndView mv = new ModelAndView();
		int result = boardService.faqAdd(board, sessionId);
		if(result>0){
			mv.setViewName("board/faq/faqList");
		}else{
			mv.setViewName("error/error");
		}
	return mv;	
	}
	
	//FAQ리스트
	@RequestMapping(value="faqList" , method=RequestMethod.GET)
	public ModelAndView faqList(BoardVo board/*,
			@ModelAttribute("sessionId") String sessionId*/){
		logger.debug(" >>>>>>> faqAdd <<<<<<< ");
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("board/faq/faqList");
	return mv;	
	}

}



