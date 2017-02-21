package com.log4h.singletontrip.mileage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.mileage.service.MileageService;

@Controller
public class MileageController {

	@Autowired
	private MileageService mileageService;
}
