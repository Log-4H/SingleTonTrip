package com.log4h.singletontrip.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.reserve.repository.ReserveDao;

@Service
public class ReserveServiceImpl implements ReserveService{
	@Autowired
	private ReserveDao reserveDao;
}
