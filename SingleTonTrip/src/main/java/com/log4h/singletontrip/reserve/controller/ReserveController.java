package com.log4h.singletontrip.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.reserve.service.ReserveService;

@Controller
public class ReserveController {

	@Autowired
	private ReserveService reserveService;
}
