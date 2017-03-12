package com.log4h.singletontrip.room.service;

import java.util.List;

import com.log4h.singletontrip.room.domain.RoomVo;

public interface RoomService {
	//객실리스트
	public List<RoomVo> roomList(String companyId);
}
