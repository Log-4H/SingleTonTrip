package com.log4h.singletontrip.reserve.service;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentCateVo;
import com.log4h.singletontrip.reserve.domain.PaymentStateVo;

public interface ReserveService {

	Map<String, Object> getReserveList(int currentPage, LoginVo login, int selectOption, String selectValue);

	List<PaymentCateVo> getPaymentCate();

}
