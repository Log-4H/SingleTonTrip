package com.log4h.singletontrip.trip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.trip.domain.GroupVo;
import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
import com.log4h.singletontrip.trip.domain.TripThemeVo;
import com.log4h.singletontrip.trip.domain.TripVo;
import com.log4h.singletontrip.trip.repository.TripDao;
import com.log4h.singletontrip.util.Paging;

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
	//여행 등록 폼 요청
	@Override
	public Map<String, Object> tripAddForm() {
		List<TripThemeVo> tripThemeList = tripDao.tripThemeList();
		List<RegionVo> regionDoList = tripDao.regionDoList();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tripThemeList", tripThemeList);
		map.put("regionDoList", regionDoList);
		return map;
	}
	//여행지역(시) 리스트
	@Override
	public List<RegionVo> regionSiList(String regionDo) {
		return tripDao.regionSiList(regionDo);
	}
	//여행 & 그룹등록
	@Override
	public int tripAdd(TripVo tripVo) {
		int groupAddResult = 0;
		int result = 0;
		int tripAddResult = tripDao.tripInsert(tripVo);
		if(tripAddResult>0){
			groupAddResult = tripDao.groupInsert(tripVo);
			if(groupAddResult>0){
				GroupVo groupVo = new GroupVo();
				groupVo.setTripNo(tripVo.getTripNo());
				groupVo.setApproveStateCd(2);
				groupVo.setPersonId(tripVo.getPersonId());
				result = tripDao.groupApprove(groupVo);
			}
		}
		return result;
	}
	
	//여행일정등록
	@Transactional
	@Override
	public int planAdd(PlanVo planVo) {
		int tripPriceUpdate = 0;
		int planAddResult = tripDao.planInsert(planVo);
		if(planAddResult>0){
			tripPriceUpdate = tripDao.tripPriceUpdate(planVo);
		}
		return tripPriceUpdate;
	}
	//여행일정 view
	@Override
	public PlanVo planView(int planNo) {
		PlanVo plan = tripDao.planView(planNo);
		String planStartTime = plan.getPlanStartTime().replace(" ", "T");
		String planEndTime = plan.getPlanEndTime().replace(" ", "T");
		plan.setPlanStartTime(planStartTime);
		plan.setPlanEndTime(planEndTime);
		return plan;
	}
	//여행일정 업데이트
	@Transactional
	@Override
	public int planUpdate(PlanVo planVo) {
		int tripPriceUpdate = 0;
		int planUpdateResult = tripDao.planUpdate(planVo);
		if(planUpdateResult>0){
			tripPriceUpdate = tripDao.tripPriceUpdate(planVo);
		}
		return tripPriceUpdate;
	}
	//여행일정 삭제
	@Transactional
	@Override
	public int planDelete(int planNo) {
		PlanVo planVo = tripDao.planView(planNo);
		planVo.setPlanLastPrice(planVo.getPlanPrice());
		planVo.setPlanPrice(0);
		int tripPriceUpdate = 0;
		int planDeleteResult = tripDao.planDelete(planNo);
		if(planDeleteResult>0){
			tripPriceUpdate = tripDao.tripPriceUpdate(planVo);
		}
		return tripPriceUpdate;
	}
	//그룹리스트
	@Override
	public Map<String, Object> groupList(String personId, int currentPage) {
		int groupTotalCount = tripDao.groupTotalCount(personId);
		Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, groupTotalCount);
		map.put("personId", personId);
		List<GroupVo> groupList = tripDao.groupList(map);
		map.put("groupList", groupList);
		return map;
	}
	//그룹상세보기
	@Override
	public Map<String, Object> groupView(int tripNo) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tripNo", tripNo);
		TripVo trip = tripDao.tripView(map);
		List<GroupVo> groupMemberList = tripDao.groupMemberList(tripNo);
		map.put("trip", trip);
		map.put("groupMemberList", groupMemberList);
		return map;
	}
}
