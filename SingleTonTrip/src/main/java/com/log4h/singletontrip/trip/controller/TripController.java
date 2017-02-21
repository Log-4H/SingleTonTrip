package com.log4h.singletontrip.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log4h.singletontrip.trip.service.TripService;

@Controller
public class TripController {

	@Autowired
	private TripService tripService;
}
