package com.log4h.singletontrip.reserve.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDaoImpl implements ReserveDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String RESERVE_NS = "reserveMapper.";
}
