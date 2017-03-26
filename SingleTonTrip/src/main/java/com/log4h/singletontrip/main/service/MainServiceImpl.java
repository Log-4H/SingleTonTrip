package com.log4h.singletontrip.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.main.domain.SearchCompanyVo;
import com.log4h.singletontrip.main.domain.SearchPersonVo;
import com.log4h.singletontrip.main.domain.SearchTripVo;
import com.log4h.singletontrip.main.repository.MainDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class MainServiceImpl implements MainService{
	@Autowired
	private MainDao mainDao;

	@Override
	public Map<String, Object> searchPersonList(String value, int currentPage) {
        int searchPersonCount = mainDao.searchPersonCount(value);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, searchPersonCount);
        map.put("value", value);
        List<SearchPersonVo> searchPersonList = mainDao.searchPersonList(map);
        map.put("searchPersonList", searchPersonList);
		return map;
	}

	@Override
	public Map<String, Object> searchCompanyList(String value, int currentPage) {
		int searchCompanyCount = mainDao.searchCompanyCount(value);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, searchCompanyCount);
        map.put("value", value);
        List<SearchCompanyVo> searchCompanyList = mainDao.searchCompanyList(map);
        map.put("searchCompanyList", searchCompanyList);
		return map;
	}

	@Override
	public Map<String, Object> searchTripList(String value, int currentPage) {
		int searchTripCount = mainDao.searchTripCount(value);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, searchTripCount);
        map.put("value", value);
        List<SearchTripVo> searchTripList = mainDao.searchTripList(map);
        map.put("searchTripList", searchTripList);
		return map;
	}

}
