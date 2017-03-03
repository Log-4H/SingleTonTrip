package com.log4h.singletontrip.trip.service;

import java.util.List;

import com.log4h.singletontrip.trip.domain.TripVo;

public interface TripService {
	//여행리스트
	public List<TripVo> tripList(String memberId, int lastTripRow);
}
