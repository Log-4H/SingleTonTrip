package com.log4h.singletontrip.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.room.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
}
