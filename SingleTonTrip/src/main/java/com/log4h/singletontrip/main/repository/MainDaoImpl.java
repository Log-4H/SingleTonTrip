package com.log4h.singletontrip.main.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.main.domain.SearchCompanyVo;
import com.log4h.singletontrip.main.domain.SearchPersonVo;
import com.log4h.singletontrip.main.domain.SearchTripVo;

@Repository
public class MainDaoImpl implements MainDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String MAIN_NS = "mainMapper.";
	
	@Override
	public int searchPersonCount(String value) {
		return sqlSession.selectOne(MAIN_NS+"searchPersonCount", value);
	}
	@Override
	public List<SearchPersonVo> searchPersonList(Map<String, Object> map) {
		return sqlSession.selectList(MAIN_NS+"searchPersonList", map);
	}
	@Override
	public int searchCompanyCount(String value) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(MAIN_NS+"searchCompanyCount", value);
	}

	@Override
	public List<SearchCompanyVo> searchCompanyList(Map<String, Object> map) {
		return sqlSession.selectList(MAIN_NS+"searchCompanyList", map);
	}
	@Override
	public int searchTripCount(String value) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(MAIN_NS+"searchTripCount", value);
	}
	@Override
	public List<SearchTripVo> searchTripList(Map<String, Object> map) {
		return sqlSession.selectList(MAIN_NS+"searchTripList", map);
	}
}
