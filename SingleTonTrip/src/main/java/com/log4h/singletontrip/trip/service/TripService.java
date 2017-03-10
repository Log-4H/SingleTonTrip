package com.log4h.singletontrip.trip.service;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
import com.log4h.singletontrip.trip.domain.TripVo;

public interface TripService {
	//여행리스트
	public List<TripVo> tripList(String memberId, int lastTripRow);
	//여행상세보기
	public Map<String, Object> tripView(String memberId, int tripNo);
	//여행등록 폼 요청
	public Map<String, Object> tripAddForm();
	//여행지역(시) 리스트
	public List<RegionVo> regionSiList(String regionDo);
	//여행등록
	public int tripAdd(TripVo tripVo);
	//여행일정등록
	public int planAdd(PlanVo planVo);
	//여행일정 view
	public PlanVo planView(int planNo);
}
