package com.log4h.singletontrip.admin.repository;

import java.util.List;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.trip.domain.TripVo;

public interface AdminDao {
	
	public List<PersonVo> searchPersonList(String value);
	public List<CompanyVo> searchCompanyList(String value);
	public List<TripVo> searchTripList(String value);
}
