package com.log4h.singletontrip.ad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.ad.repository.AdDao;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	private AdDao adDao;
	
}
