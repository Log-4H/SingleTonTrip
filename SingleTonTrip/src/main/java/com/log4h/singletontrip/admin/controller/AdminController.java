package com.log4h.singletontrip.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
}
