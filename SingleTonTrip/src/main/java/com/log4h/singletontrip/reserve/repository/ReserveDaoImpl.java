package com.log4h.singletontrip.reserve.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDaoImpl implements ReserveDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String RESERVE_NS = "reserveMapper.";

	@Override
	public int reserveTotalCount(Map<String, Object> totalCountMap) {
		return sqlSession.selectOne(RESERVE_NS+"getTotalCount", totalCountMap);
	}

	@Override
	public List<Object> getReserveList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(RESERVE_NS+"getReserveList", map);
	}


}
