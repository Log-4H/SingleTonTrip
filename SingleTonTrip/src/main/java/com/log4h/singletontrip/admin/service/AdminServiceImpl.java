package com.log4h.singletontrip.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.admin.domain.SearchCompanyVo;
import com.log4h.singletontrip.admin.domain.SearchPersonVo;
import com.log4h.singletontrip.admin.domain.SearchTripVo;
import com.log4h.singletontrip.admin.repository.AdminDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public Map<String, Object> searchPersonList(String value, int currentPage) {
        int searchPersonCount = adminDao.searchPersonCount(value);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, searchPersonCount);
        map.put("value", value);
        List<SearchPersonVo> searchPersonList = adminDao.searchPersonList(map);
        map.put("searchPersonList", searchPersonList);
		return map;
	}

	@Override
	public Map<String, Object> searchCompanyList(String value, int currentPage) {
		int searchCompanyCount = adminDao.searchCompanyCount(value);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, searchCompanyCount);
        map.put("value", value);
        List<SearchCompanyVo> searchCompanyList = adminDao.searchCompanyList(map);
        map.put("searchCompanyList", searchCompanyList);
		return map;
	}

	@Override
	public Map<String, Object> searchTripList(String value, int currentPage) {
		int searchTripCount = adminDao.searchTripCount(value);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, searchTripCount);
        map.put("value", value);
        List<SearchTripVo> searchTripList = adminDao.searchTripList(map);
        map.put("searchTripList", searchTripList);
		return map;
	}

}
