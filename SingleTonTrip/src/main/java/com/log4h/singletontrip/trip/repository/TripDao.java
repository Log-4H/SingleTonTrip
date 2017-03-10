package com.log4h.singletontrip.trip.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.trip.domain.GroupVo;
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
	//여행등록
	public int tripInsert(TripVo tripVo);
	//그룹등록
	public int groupInsert(TripVo tripVo);
	//여행그룹승인
	public int groupApprove(GroupVo groupVo);
	//여행일정등록
	public int planInsert(PlanVo planVo);
	//여행일정등록시 여행경비업데이트
	public int tripPriceUpdate(PlanVo planVo);
	//여행일정 view
	public PlanVo planView(int planNo);
	//여행일정 수정
	public int planUpdate(PlanVo planVo);
	//여행일정 삭제
	public int planDelete(int planNo);
	//그룹리스트 총카운트
	public int groupTotalCount(String personId);
	//그룹리스트
	public List<GroupVo> groupList(Map<String, Object> map);
	//여행그룹원리스트
	public List<GroupVo> groupMemberList(int tripNo);
}	
