package com.log4h.singletontrip.room.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.room.domain.RoomFacilityVo;
import com.log4h.singletontrip.room.domain.RoomVo;
import com.log4h.singletontrip.room.repository.RoomDao;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomDao roomDao;

	//객실리스트
	@Override
	public List<RoomVo> roomList(String companyId) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("companyId", companyId);
		List<RoomVo> roomList = roomDao.roomList(map);
		for(int i=0; i<roomList.size(); i++){
			int roomNo = roomList.get(i).getRoomNo();
			List<RoomFacilityVo> roomFacilityList = roomDao.roomFacilityList(roomNo);
			roomList.get(i).setRoomFacilityList(roomFacilityList);
		}
		return roomList;
	}
}
