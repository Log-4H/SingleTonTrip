package com.log4h.singletontrip.reserve.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.reserve.domain.PaymentCateVo;
import com.log4h.singletontrip.reserve.domain.PaymentStateVo;


public interface ReserveDao {

	int reserveTotalCount(Map<String, Object> totalCountMap);

	List<Object> getReserveList(Map<String, Object> map);

	List<PaymentCateVo> getPaymentCate();

	int payTotalCount(Map<String, Object> totalCountMap);




}
