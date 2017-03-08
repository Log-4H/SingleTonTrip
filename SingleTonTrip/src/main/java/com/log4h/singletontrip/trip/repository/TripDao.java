package com.log4h.singletontrip.trip.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
import com.log4h.singletontrip.trip.domain.TripThemeVo;
import com.log4h.singletontrip.trip.domain.TripVo;

public interface TripDao {
	//여행리스트
	public List<TripVo> tripList(Map<String, Object> map);
	//여행상세보기
	public TripVo tripView(Map<String,Object> map);
	//여행계획리스트
	public List<PlanVo> planList(int tripNo);
	//여행테마리스트
	public List<TripThemeVo> tripThemeList();
	//여행지역(도)리스트
	public List<RegionVo> regionDoList();
	//여행지역(시)리스트
	public List<RegionVo> regionSiList(String regionDo);
}	
