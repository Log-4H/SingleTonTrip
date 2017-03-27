package com.log4h.singletontrip.main.service;

import java.util.Map;

public interface MainService {
	public Map<String, Object> searchPersonList(String value, int currentPage);
	public Map<String, Object> searchCompanyList(String value, int currentPage);
	public Map<String, Object> searchTripList(String value, int currentPage);
	
	public Map<String, Object> mainList();
}
