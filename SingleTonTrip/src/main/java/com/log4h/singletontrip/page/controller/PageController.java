package com.log4h.singletontrip.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.page.service.PageService;

@Controller
public class PageController {

	@Autowired
	private PageService pageService;
}
