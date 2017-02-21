package com.log4h.singletontrip.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.report.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;
}
