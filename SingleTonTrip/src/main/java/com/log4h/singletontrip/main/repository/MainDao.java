package com.log4h.singletontrip.main.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.main.domain.SearchCompanyVo;
import com.log4h.singletontrip.main.domain.SearchPersonVo;
import com.log4h.singletontrip.main.domain.SearchTripVo;

public interface MainDao {
	public int searchPersonCount(String value);
	public List<SearchPersonVo> searchPersonList(Map<String, Object> map);
	public int searchCompanyCount(String value);
	public List<SearchCompanyVo> searchCompanyList(Map<String, Object> map);
	public int searchTripCount(String value);
	public List<SearchTripVo> searchTripList(Map<String, Object> map);
}
