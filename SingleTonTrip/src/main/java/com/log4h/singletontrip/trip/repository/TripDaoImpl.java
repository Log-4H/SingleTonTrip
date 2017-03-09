package com.log4h.singletontrip.trip.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
import com.log4h.singletontrip.trip.domain.TripThemeVo;
import com.log4h.singletontrip.trip.domain.TripVo;

@Repository
public class TripDaoImpl implements TripDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String TRIP_NS = "tripMapper.";
	
	//여행리스트
	@Override
	public List<TripVo> tripList(Map<String, Object> map) {
		return sqlSession.selectList(TRIP_NS+"tripList", map);
	}
	//여행상세보기
	@Override
	public TripVo tripView(Map<String, Object> map) {
		return sqlSession.selectOne(TRIP_NS+"tripList", map);
	}
	//여행계획리스트
	@Override
	public List<PlanVo> planList(int tripNo) {
		return sqlSession.selectList(TRIP_NS+"planList", tripNo);
	}
	//여행테마리스트
	@Override
	public List<TripThemeVo> tripThemeList() {
		return sqlSession.selectList(TRIP_NS+"tripThemeList");
	}
	//여행지역리스트
	@Override
	public List<RegionVo> regionDoList() {
		return sqlSession.selectList(TRIP_NS+"regionDoList");
	}
	//여행지역리스트
	@Override
	public List<RegionVo> regionSiList(String regionDo) {
		return sqlSession.selectList(TRIP_NS+"regionSiList", regionDo);
	}
	//여행등록
	@Override
	public int tripInsert(TripVo tripVo) {
		return sqlSession.insert(TRIP_NS+"tripInsert", tripVo);
	}
}
