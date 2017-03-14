package com.log4h.singletontrip.trip.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.trip.domain.GroupVo;
import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
import com.log4h.singletontrip.trip.domain.TripThemeVo;
import com.log4h.singletontrip.trip.domain.TripVo;

@Repository
public class TripDaoImpl implements TripDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String TRIP_NS = "tripMapper.";
	
	//여행리스트
	@Override
	public List<TripVo> tripList(Map<String, Object> map) {
		return sqlSession.selectList(TRIP_NS+"tripList", map);
	}
	//여행상세보기
	@Override
	public TripVo tripView(Map<String, Object> map) {
		return sqlSession.selectOne(TRIP_NS+"tripList", map);
	}
	//여행계획리스트
	@Override
	public List<PlanVo> planList(int tripNo) {
		return sqlSession.selectList(TRIP_NS+"planList", tripNo);
	}
	//여행테마리스트
	@Override
	public List<TripThemeVo> tripThemeList() {
		return sqlSession.selectList(TRIP_NS+"tripThemeList");
	}
	//여행지역리스트
	@Override
	public List<RegionVo> regionDoList() {
		return sqlSession.selectList(TRIP_NS+"regionDoList");
	}
	//여행지역리스트
	@Override
	public List<RegionVo> regionSiList(String regionDo) {
		return sqlSession.selectList(TRIP_NS+"regionSiList", regionDo);
	}
	//여행등록
	@Override
	public int tripInsert(TripVo tripVo) {
		return sqlSession.insert(TRIP_NS+"tripInsert", tripVo);
	}
	//그룹등록
	@Override
	public int groupInsert(TripVo tripVo) {
		return sqlSession.insert(TRIP_NS+"groupInsert", tripVo);
	}
	//여행일정등록
	@Override
	public int planInsert(PlanVo planVo) {
		return sqlSession.insert(TRIP_NS+"planInsert", planVo);
	}
	//여행일정등록시 여행경비업데이트
	@Override
	public int tripPriceUpdate(PlanVo planVo) {
		return sqlSession.update(TRIP_NS+"tripPriceUpdate", planVo);
	}
	//여행일정 view
	@Override
	public PlanVo planView(int planNo) {
		return sqlSession.selectOne(TRIP_NS+"planView", planNo);
	}
	//여행일정 수정
	public int planUpdate(PlanVo planVo){
		return sqlSession.update(TRIP_NS+"planUpdate", planVo);
	}
	//여행일정 삭제
	@Override
	public int planDelete(Map<String, Object> map) {
		return sqlSession.delete(TRIP_NS+"planDelete", map);
	}
	//그룹리스트 총카운트
	@Override
	public int groupTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(TRIP_NS+"groupTotalCount", map);
	}
	//그룹리스트
	@Override
	public List<GroupVo> groupList(Map<String, Object> map) {
		return sqlSession.selectList(TRIP_NS+"groupList", map);			
	}
	//여행그룹원리스트
	@Override
	public List<GroupVo> groupMemberList(Map<String, Object> map) {
		return sqlSession.selectList(TRIP_NS+"groupMemberList", map);	
	}
	//그룹참가체크
	@Override
	public GroupVo tripJoinCheck(Map<String, Object> map) {
		return sqlSession.selectOne(TRIP_NS+"tripJoinCheck", map);
	}
	//그룹참가신청
	@Override
	public int groupApply(TripVo tripVo) {
		return sqlSession.insert(TRIP_NS+"groupApply", tripVo);
	}
	//그룹 참가 승인 or 거절
	@Override
	public int groupApprove(GroupVo groupVo) {
		return sqlSession.update(TRIP_NS+"groupApprove", groupVo);
	}
	//그룹참가 -> 여행상태변경
	@Override
	public int tripRecruitUpdate(Map<String, Object> map) {
		return sqlSession.update(TRIP_NS+"tripRecruitUpdate", map);
	}
	//여행수정
	@Override
	public int tripUpdate(TripVo tripVo) {
		return sqlSession.update(TRIP_NS+"tripUpdate", tripVo);
	}
	//여행삭제
	@Override
	public int tripDelete(int tripNo) {
		return sqlSession.update(TRIP_NS+"tripDelete", tripNo);
	}
	//그룹삭제
	@Override
	public int groupDelete(Map<String, Object> map) {
		return sqlSession.update(TRIP_NS+"groupDelete", map);
	}
	//그룹가입취소
	@Override
	public int groupApplyCancel(Map<String, Object> map) {
		return sqlSession.delete(TRIP_NS+"groupApplyCancel", map);
	}
	//여행모집기간 만료 검색
	@Override
	public List<TripVo> selectRecruitEnd() {
		return sqlSession.selectList(TRIP_NS+"selectRecruitEnd");
	}
}
