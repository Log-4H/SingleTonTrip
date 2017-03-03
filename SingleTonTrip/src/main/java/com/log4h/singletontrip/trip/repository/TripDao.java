package com.log4h.singletontrip.trip.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.trip.domain.TripVo;

public interface TripDao {
	//여행리스트
	public List<TripVo> tripList(Map<String, Object> map);
	//여행상세보기
	public TripVo tripView(Map<String,Object> map);
}	
