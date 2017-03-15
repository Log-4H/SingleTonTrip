package com.log4h.singletontrip.room.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.room.domain.RoomReserveVo;
import com.log4h.singletontrip.room.domain.RoomFacilityVo;
import com.log4h.singletontrip.room.domain.RoomVo;

public interface RoomDao {
	//객실리스트
	public List<RoomVo> roomList(Map<String, Object> map);
	//객실시설리스트
	public List<RoomFacilityVo> roomFacilityList(int roomNo);
	//해당날짜 객실예약정보확인
	public RoomReserveVo roomReserveCheck(Map<String, Object> map);
	
}
