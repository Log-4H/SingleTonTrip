package com.log4h.singletontrip.mileage.service;

import java.util.Map;

import com.log4h.singletontrip.member.domain.LoginVo;

public interface MileageService {

	Map<String, Object> mileageList(int currentPage, LoginVo login, int selectOption, String selectValue);

}
