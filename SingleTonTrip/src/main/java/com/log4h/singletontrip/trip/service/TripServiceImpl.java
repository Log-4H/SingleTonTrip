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
		tripVo.setTripContent(tripVo.getTripContent().replaceAll("\r\n", "<br>"));
		int tripAddResult = tripDao.tripInsert(tripVo);
		if(tripAddResult>0){
			groupAddResult = tripDao.groupInsert(tripVo);
		}
		return groupAddResult;
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("planNo", planNo);
		int planDeleteResult = tripDao.planDelete(map);
		if(planDeleteResult>0){
			tripPriceUpdate = tripDao.tripPriceUpdate(planVo);
		}
		return tripPriceUpdate;
	}
	
	//그룹리스트
	@Override
	public Map<String, Object> groupList(String personId, String groupMemberLevel, int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personId", personId);
		map.put("groupMemberLevel", groupMemberLevel);
		int groupTotalCount = tripDao.groupTotalCount(map);
		Paging paging = new Paging();
        map = paging.pagingMethod(currentPage, groupTotalCount);
        map.put("personId", personId);
        map.put("groupMemberLevel", groupMemberLevel);
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
		List<GroupVo> groupMemberList = tripDao.groupMemberList(map);
		map.put("trip", trip);
		map.put("groupMemberList", groupMemberList);
		return map;
	}
	//그룹참가체크
	@Override
	public GroupVo tripJoinCheck(String personId, int tripNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personId", personId);
		map.put("tripNo", tripNo);
		return tripDao.tripJoinCheck(map);
	}
	//그룹참가신청
	@Override
	public int groupApply(String personId, int tripNo) {
		TripVo tripVo = new TripVo();
		tripVo.setPersonId(personId);
		tripVo.setTripNo(tripNo);
		return tripDao.groupApply(tripVo);
	}
	//참가신청멤버리스트
	@Override
	public List<GroupVo> applyMemberList(int tripNo, int approveStateCd) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tripNo", tripNo);
		map.put("approveStateCd", approveStateCd);
		List<GroupVo> groupMemberList = tripDao.groupMemberList(map);
		return groupMemberList;
	}
	//그룹 참가 승인 or 거절
	@Transactional
	@Override
	public int groupApprove(int approveStateCd, int tripNo, String personId) {
		GroupVo groupVo = new GroupVo();
		groupVo.setApproveStateCd(approveStateCd);
		groupVo.setTripNo(tripNo);
		groupVo.setPersonId(personId);
		int approveResult = tripDao.groupApprove(groupVo);
		if(approveResult>0){
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("approveStateCd", approveStateCd);
			map.put("recruitStateCd", 1);
			map.put("tripNo", tripNo);
			int presentMemberUpdate = tripDao.tripRecruitUpdate(map);
			if(presentMemberUpdate>0){
				map.put("tripNo", tripNo);
				TripVo tripVo = tripDao.tripView(map);
				int presentMember = tripVo.getTripPresentMember();
				int maxMember = tripVo.getTripMaxMember();
				if(presentMember >= maxMember){
					map.remove("approveStateCd");
					map.put("recruitStateCd", 2);
					int tripRecruitUpdate = tripDao.tripRecruitUpdate(map);
					if(tripRecruitUpdate>0){
						groupVo.setApproveStateCd(4);
						groupVo.setPersonId("");
						int applyDropResult = tripDao.groupApprove(groupVo);
						return applyDropResult;
					}
				}else{
					return presentMemberUpdate;
				}
			}
		}
		return 0;
	}
	//여행수정폼 요청
	public Map<String, Object> tripModifyForm(String memberId, int tripNo){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("tripNo", tripNo);
		TripVo trip = tripDao.tripView(map);
		trip.setTripContent(trip.getTripContent().replaceAll("<br>", "\r\n"));
		List<TripThemeVo> tripThemeList = tripDao.tripThemeList();
		List<RegionVo> regionDoList = tripDao.regionDoList();
		String regionDo = trip.getRegionDo();
		List<RegionVo> regionSiList = tripDao.regionSiList(regionDo);
		map.put("trip", trip);
		map.put("tripThemeList", tripThemeList);
		map.put("regionDoList", regionDoList);
		map.put("regionSiList", regionSiList);
		return map;
	}
	//여행수정
	@Override
	public int tripUpdate(TripVo tripVo) {
		tripVo.setTripContent(tripVo.getTripContent().replaceAll("\r\n", "<br>"));
		return tripDao.tripUpdate(tripVo);
	}
	//여행마감
	@Override
	public int tripEnd(int tripNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tripNo", tripNo);
		map.put("recruitStateCd", 2);
		int tripRecruitUpdate = tripDao.tripRecruitUpdate(map);
		if(tripRecruitUpdate>0){
			GroupVo groupVo = new GroupVo();
			groupVo.setTripNo(tripNo);
			groupVo.setApproveStateCd(4);
			int applyDropResult = tripDao.groupApprove(groupVo);
		}
		return tripRecruitUpdate;
	}
	//여행삭제
	@Override
	public int tripDelete(int tripNo) {
		int tripDelete = tripDao.tripDelete(tripNo);
		if(tripDelete>0){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tripNo", tripNo);
			int planDelete = tripDao.planDelete(map);
			int applyDropResult = tripDao.groupDelete(map);
		}
		return tripDelete;
	};	
}
