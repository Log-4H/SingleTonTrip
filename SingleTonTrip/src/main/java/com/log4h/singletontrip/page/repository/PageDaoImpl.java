package com.log4h.singletontrip.page.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.page.domain.PostVo;

@Repository
public class PageDaoImpl implements PageDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String PAGE_NS = "pageMapper.";
	
	//포스트리스트
	@Override
	public List<PostVo> postList(Map<String, Object> map) {
		return sqlSession.selectList(PAGE_NS+"postList", map);
	}
	
	//포스트등록
	@Override
	public int postInsert(PostVo postVo) {
		return sqlSession.insert(PAGE_NS+"postInsert", postVo);
	}
}
