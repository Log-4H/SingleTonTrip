package com.log4h.singletontrip.room.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.room.domain.RoomReserveVo;
import com.log4h.singletontrip.room.domain.RoomFacilityVo;
import com.log4h.singletontrip.room.domain.RoomVo;

@Repository
public class RoomDaoImpl implements RoomDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String ROOM_NS = "roomMapper.";
	
	//객실리스트
	@Override
	public List<RoomVo> roomList(Map<String, Object> map) {
		return sqlSession.selectList(ROOM_NS+"roomList", map);
	}

	//객실시설리스트
	@Override
	public List<RoomFacilityVo> roomFacilityList(int roomNo) {
		return sqlSession.selectList(ROOM_NS+"roomFacilityList", roomNo);
	}
	
	@Override
	public RoomReserveVo roomReserveCheck(Map<String, Object> map) {
		return sqlSession.selectOne(ROOM_NS+"roomReserveCheck", map);
	}
}
