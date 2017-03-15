package com.log4h.singletontrip.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.admin.repository.AdminDao;
import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.trip.domain.TripVo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public Map<String, Object> searchList(String value) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<PersonVo> personList = adminDao.searchPersonList(value);
		List<CompanyVo> companyList = adminDao.searchCompanyList(value);
		List<TripVo> tripList = adminDao.searchTripList(value);
		map.put("personList", personList);
		map.put("companyList", companyList);
		map.put("tripList", tripList);
		return map;
	}
}
