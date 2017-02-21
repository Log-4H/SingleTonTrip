package com.log4h.singletontrip.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
}
