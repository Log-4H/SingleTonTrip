package com.log4h.singletontrip.main.service;

import java.util.HashMap;
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

	@Override
	public Map<String, Object> mainList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", 0);
		map.put("pagePerRow", 3);
		map.put("orderBy", "bestList");
		List<SearchPersonVo> bestPerson = mainDao.searchPersonList(map);
		List<SearchCompanyVo> bestCompany = mainDao.searchCompanyList(map);
		map.remove("orderBy");
		map.put("orderBy", "newList");
		List<SearchTripVo> newTrip = mainDao.searchTripList(map);
		List<SearchPersonVo> newPerson = mainDao.searchPersonList(map);
		List<SearchCompanyVo> newCompany = mainDao.searchCompanyList(map);
		map.put("bestPerson", bestPerson);
		map.put("bestCompany", bestCompany);
		map.put("newTrip", newTrip);
		map.put("newPerson", newPerson);
		map.put("newCompany", newCompany);
		return map;
	}

}
