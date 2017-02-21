package com.log4h.singletontrip.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.room.repository.RoomDao;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomDao roomDao;
}
