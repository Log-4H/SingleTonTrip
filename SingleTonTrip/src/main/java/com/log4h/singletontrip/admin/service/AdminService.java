package com.log4h.singletontrip.admin.service;

import java.util.Map;

public interface AdminService {
	public Map<String, Object> searchPersonList(String value, int currentPage);
	public Map<String, Object> searchCompanyList(String value, int currentPage);
	public Map<String, Object> searchTripList(String value, int currentPage);
}
