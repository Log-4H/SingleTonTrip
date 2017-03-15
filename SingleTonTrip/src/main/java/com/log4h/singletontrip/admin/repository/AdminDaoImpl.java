package com.log4h.singletontrip.admin.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.trip.domain.TripVo;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String ADMIN_NS = "adminMapper.";

	@Override
	public List<PersonVo> searchPersonList(String value) {
		return sqlSession.selectList(ADMIN_NS+"searchPersonList", value);
	}

	@Override
	public List<CompanyVo> searchCompanyList(String value) {
		return sqlSession.selectList(ADMIN_NS+"searchCompanyList", value);
	}

	@Override
	public List<TripVo> searchTripList(String value) {
		return sqlSession.selectList(ADMIN_NS+"searchTripList", value);
	}
}
