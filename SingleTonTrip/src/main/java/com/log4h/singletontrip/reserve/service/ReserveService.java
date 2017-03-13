package com.log4h.singletontrip.reserve.service;

import java.util.Map;

import com.log4h.singletontrip.member.domain.LoginVo;

public interface ReserveService {

	Map<String, Object> getReserveList(int currentPage, LoginVo login, int selectOption, String selectValue);

	Map<String, Object> getPayList(int currentPage, String sessionId, int sessionLevel, int selectOption,
			String selectValue);
}
