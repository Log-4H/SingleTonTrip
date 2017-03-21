package com.log4h.singletontrip.admin.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.admin.domain.SearchCompanyVo;
import com.log4h.singletontrip.admin.domain.SearchPersonVo;
import com.log4h.singletontrip.admin.domain.SearchTripVo;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String ADMIN_NS = "adminMapper.";
	
	@Override
	public int searchPersonCount(String value) {
		return sqlSession.selectOne(ADMIN_NS+"searchPersonCount", value);
	}
	@Override
	public List<SearchPersonVo> searchPersonList(Map<String, Object> map) {
		return sqlSession.selectList(ADMIN_NS+"searchPersonList", map);
	}
	@Override
	public int searchCompanyCount(String value) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ADMIN_NS+"searchCompanyCount", value);
	}

	@Override
	public List<SearchCompanyVo> searchCompanyList(Map<String, Object> map) {
		return sqlSession.selectList(ADMIN_NS+"searchCompanyList", map);
	}
	@Override
	public int searchTripCount(String value) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ADMIN_NS+"searchTripCount", value);
	}
	@Override
	public List<SearchTripVo> searchTripList(Map<String, Object> map) {
		return sqlSession.selectList(ADMIN_NS+"searchTripList", map);
	}
}
