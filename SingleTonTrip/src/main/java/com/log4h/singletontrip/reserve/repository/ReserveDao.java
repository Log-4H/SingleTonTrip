package com.log4h.singletontrip.reserve.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.reserve.domain.PaymentCateVo;
import com.log4h.singletontrip.reserve.domain.PaymentStateVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;
import com.log4h.singletontrip.room.domain.RoomVo;


public interface ReserveDao {

	int reserveTotalCount(Map<String, Object> reserveTotalCountMap);

	List<Object> getReserveList(Map<String, Object> map);

	List<PaymentCateVo> getPaymentCate();

	int adPayCount(Map<String, Object> payCountMap);

	List<PaymentVo> adPayList(Map<String, Object> map);

	PersonVo getPerson(String sessionId);

	RoomVo getRoom(int roomNo);

}
