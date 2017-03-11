package com.log4h.singletontrip.trip.service;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.trip.domain.GroupVo;
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
	//여행 & 그룹등록
	public int tripAdd(TripVo tripVo);
	//여행일정등록
	public int planAdd(PlanVo planVo);
	//여행일정 view
	public PlanVo planView(int planNo);
	//여행일정 업데이트
	public int planUpdate(PlanVo planVo);
	//여행일정 삭제
	public int planDelete(int planNo);
	//그룹리스트
	public Map<String, Object> groupList(String personId, String groupMemberLevel, int currentPage);
	//그룹상세보기
	public Map<String, Object> groupView(int tripNo);
	//그룹참가체크
	public GroupVo tripJoinCheck(String personId, int tripNo);
	//그룹참가신청
	public int groupApply(String personId, int tripNo);
}
