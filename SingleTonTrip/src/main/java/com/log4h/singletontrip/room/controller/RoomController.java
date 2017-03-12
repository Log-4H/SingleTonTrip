package com.log4h.singletontrip.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.room.domain.RoomVo;
import com.log4h.singletontrip.room.service.RoomService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel", "pageId"})
@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	//객실 리스트
	@RequestMapping(value="roomList")
	public ModelAndView tripList(@ModelAttribute("pageId") String pageId){
		ModelAndView mv = new ModelAndView("jsonView");
		List<RoomVo> roomList= roomService.roomList(pageId);
		mv.addObject("roomList", roomList);
		return mv;	
	}
}
