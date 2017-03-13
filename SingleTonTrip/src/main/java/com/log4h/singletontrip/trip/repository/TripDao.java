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
	//여행일정등록
	public int planInsert(PlanVo planVo);
	//여행일정등록시 여행경비업데이트
	public int tripPriceUpdate(PlanVo planVo);
	//여행일정 view
	public PlanVo planView(int planNo);
	//여행일정 수정
	public int planUpdate(PlanVo planVo);
	//여행일정 삭제
	public int planDelete(Map<String, Object> map);
	//그룹리스트 총카운트
	public int groupTotalCount(Map<String, Object> map);
	//그룹리스트
	public List<GroupVo> groupList(Map<String, Object> map);
	//여행그룹원리스트
	public List<GroupVo> groupMemberList(Map<String, Object> map);
	//그룹참가체크
	public GroupVo tripJoinCheck(Map<String, Object> map);
	//그룹참가신청
	public int groupApply(TripVo tripVo);
	//그룹 참가 승인 or 거절
	public int groupApprove(GroupVo groupVo);
	//그룹참가 -> 여행상태변경
	public int tripRecruitUpdate(Map<String, Object> map);
	//여행수정
	public int tripUpdate(TripVo tripVo);
	//여행삭제
	public int tripDelete(int tripNo);
	//그룹삭제
	public int groupDelete(Map<String, Object> map);
	//그룹가입취소
	public int groupApplyCancel(Map<String, Object> map);
}	
