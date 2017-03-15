package com.log4h.singletontrip.room.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.room.domain.RoomVo;
import com.log4h.singletontrip.room.service.CalendarService;
import com.log4h.singletontrip.room.service.RoomService;

@SessionAttributes({ "sessionId", "sessionNm", "sessionLevel", "pageId" })
@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private CalendarService calendarService;

	// 객실 리스트
	@RequestMapping(value = "roomList")
	public ModelAndView tripList(@ModelAttribute("pageId") String pageId) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<RoomVo> roomList = roomService.roomList(pageId);
		mv.addObject("roomList", roomList);
		return mv;
	}

	// 캘린더 테스트
	@RequestMapping(value = "calendar")
	public ModelAndView calendar(@RequestParam(value = "roomNo") int roomNo,
			@RequestParam(value = "ddayYear", defaultValue = "0") int ddayYear,
			@RequestParam(value = "ddayMonth", defaultValue = "0") int ddayMonth,
			@RequestParam(value = "ddayOption", defaultValue = "default") String ddayOption) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = calendarService.getOneDayList(roomNo, ddayYear, ddayMonth, ddayOption);
		mv.addObject("calendarList", map.get("calendarList"));
		mv.addObject("ddayYear", map.get("ddayYear"));
		mv.addObject("ddayMonth", map.get("ddayMonth"));
		return mv;
	}
}
