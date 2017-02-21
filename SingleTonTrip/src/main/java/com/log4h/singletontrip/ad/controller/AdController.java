package com.log4h.singletontrip.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.ad.service.AdService;

@Controller
public class AdController {

	@Autowired
	private AdService adService;
}
