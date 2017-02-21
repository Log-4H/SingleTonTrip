package com.log4h.singletontrip.a.example;

public interface ExampleDao {
	/*
	 * ExampleDao 
	 * DAO 구현체 (exampleDaoImpl) 작성전에 인터페이스 먼저 작성
	 * 인터페이스에는 애노테이션 x
	 * 구현체에 애노테이션 달자.
	 */

	//insert
	public int insertExample(ExampleVo exampleVO);
	//select
	public ExampleVo selectExample(int a);
}
