package com.log4h.singletontrip.reserve.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.reserve.domain.PaymentCateVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;
import com.log4h.singletontrip.room.domain.RoomVo;

@Repository
public class ReserveDaoImpl implements ReserveDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String RESERVE_NS = "reserveMapper.";

	// 예약 내역 카운트
	@Override
	public int reserveTotalCount(Map<String, Object> reserveTotalCountMap) {
		return sqlSession.selectOne(RESERVE_NS+"getReserveTotalCount", reserveTotalCountMap);
	}
	// 예약 내역 리스트
	@Override
	public List<Object> getReserveList(Map<String, Object> map) {
		return sqlSession.selectList(RESERVE_NS+"getReserveList", map);
	}
	// paymentcate 리스트
	@Override
	public List<PaymentCateVo> getPaymentCate() {
		return sqlSession.selectList(RESERVE_NS+"getPaymentCate");
	}
	// 업체 광고 결제 내역 카운트
	@Override
	public int adPayCount(Map<String, Object> payCountMap) {
		
		return sqlSession.selectOne(RESERVE_NS+"adPayCount",payCountMap);
	}
	// 업체 광고 결제 내역 리스트
	@Override
	public List<PaymentVo> adPayList(Map<String, Object> map) {
		return sqlSession.selectList(RESERVE_NS+"adPayList", map);
	}
	// 예약자 정보
	@Override
	public PersonVo getPerson(String sessionId) {
		return sqlSession.selectOne(RESERVE_NS+"getPerson", sessionId);
	}
	// 방 정보
	@Override
	public RoomVo getRoom(int roomNo) {
		return sqlSession.selectOne(RESERVE_NS+"getRoom", roomNo);
	}
}
