package com.log4h.singletontrip.trip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.TripVo;
import com.log4h.singletontrip.trip.repository.TripDao;

@Service
public class TripServiceImpl implements TripService{
	@Autowired
	private TripDao tripDao;

	//여행리스트
	@Override
	public List<TripVo> tripList(String memberId, int lastTripRow) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("lastTripRow", lastTripRow);
		List<TripVo> tripList = tripDao.tripList(map);
		return tripList;
	}
	//여행상세보기
	@Override	
	public Map<String, Object> tripView(String memberId, int tripNo) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("tripNo", tripNo);
		TripVo trip = tripDao.tripView(map);
		List<PlanVo> planList = tripDao.planList(tripNo);
		map.put("trip", trip);
		map.put("planList", planList);
		return map;
	}
}
