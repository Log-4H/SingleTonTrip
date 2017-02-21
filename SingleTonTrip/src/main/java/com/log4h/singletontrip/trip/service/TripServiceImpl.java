package com.log4h.singletontrip.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.trip.repository.TripDao;

@Service
public class TripServiceImpl implements TripService{
	@Autowired
	private TripDao tripDao;
}
