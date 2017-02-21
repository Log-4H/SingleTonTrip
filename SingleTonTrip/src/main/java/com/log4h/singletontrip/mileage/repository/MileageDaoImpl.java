package com.log4h.singletontrip.mileage.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MileageDaoImpl implements MileageDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String MILEAGE_NS = "mileageMapper.";
}
