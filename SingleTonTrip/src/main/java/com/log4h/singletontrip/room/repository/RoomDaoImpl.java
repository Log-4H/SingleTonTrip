package com.log4h.singletontrip.room.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl implements RoomDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String ROOM_NS = "roomMapper.";
}
