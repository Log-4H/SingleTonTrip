package com.log4h.singletontrip.a.example;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDaoImpl implements ExampleDao{
	
	/*
	 * ExampleDaoImpl 
	 * DAO 구현체 (exampleDaoImpl) 작성전에 인터페이스 먼저 작성
	 * 구현체에 애노테이션 달자.
	 */

	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String TEST_NS = "testMapper.";
	
	//insert
	@Override
	public int insertExample(ExampleVo exampleVO) {
		return sqlSession.insert(TEST_NS+"insertExample" , exampleVO);
	}

	//select
	@Override
	public ExampleVo selectExample(int a) {
		return sqlSession.selectOne(TEST_NS+"selectExample", a);
	}
}
