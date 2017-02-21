package com.log4h.singletontrip.a.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExampleServiceImpl implements ExampleService{

	/*
	 * ExampleService 
	 * 구현체 (ExampleServiceImpl) 작성전에 인터페이스 먼저 작성
	 * 구현체에 애노테이션 달자.
	 * 서비스 단에서 트랜잭션필요시 메소드위에 @Transactional
	 * 하나로 이루어진 서비스처리는 하나의 메소드로 작성
	 * ex)도서 반납 : 반납처리, 도서 대여상태변경 .. 등은 하나의 서비스로해야된다.  
	 */
	

	@Autowired
	private ExampleDao exampleDao;
	
	@Override
	public int insertExample(ExampleVo exampleVO) {
		
		int a = exampleDao.insertExample(exampleVO);
		
		return a;
		
	}

	@Override
	@Transactional //트랜잭션 처리
	public ExampleVo selectExample(int a) {
		
		ExampleVo exampleVO = exampleDao.selectExample(a);
		
		return exampleVO;
	}
}
