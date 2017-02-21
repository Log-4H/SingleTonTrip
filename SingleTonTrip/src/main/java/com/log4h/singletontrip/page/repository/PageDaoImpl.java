package com.log4h.singletontrip.page.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageDaoImpl implements PageDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String PAGE_NS = "pageMapper.";
}
