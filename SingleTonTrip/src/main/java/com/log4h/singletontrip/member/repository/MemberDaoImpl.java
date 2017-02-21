package com.log4h.singletontrip.member.repository;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.member.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String MEMBER_NS = "memberMapper.";

	//로그인처리 (DB SELECT)
	@Override
	public Member login(Map<String, String> map) {
		return sqlSession.selectOne(MEMBER_NS+"login", map);
	}

}
