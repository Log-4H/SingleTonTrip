package com.log4h.singletontrip.reserve.service;

import java.util.Map;

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;

public interface ReserveService {

	Map<String, Object> getReserveList(int currentPage, LoginVo login, int selectOption, String selectValue);

	Map<String, Object> getPayList(int currentPage, String sessionId, int sessionLevel, String selectValue);

	Map<String, Object> reserveInfo(String sessionId, int roomNo);

	int reserveInsert(PaymentVo payment, String sessionId, int mileageUsePrice);
}
