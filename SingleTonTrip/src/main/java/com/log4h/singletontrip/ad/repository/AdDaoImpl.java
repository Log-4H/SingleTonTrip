package com.log4h.singletontrip.ad.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdDaoImpl implements AdDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String AD_NS = "adMapper.";
}
