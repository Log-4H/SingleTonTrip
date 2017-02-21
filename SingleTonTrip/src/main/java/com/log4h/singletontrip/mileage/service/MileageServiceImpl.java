package com.log4h.singletontrip.mileage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.mileage.repository.MileageDao;

@Service
public class MileageServiceImpl implements MileageService{
	@Autowired
	private MileageDao mileageDao;
}
