package com.log4h.singletontrip.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.member.domain.Member;
import com.log4h.singletontrip.member.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;

	//로그인 처리
	@Override
	public Member login(String loginId, String loginPw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginId", loginId);
		map.put("loginPw", loginPw);
		Member member = memberDao.login(map);
		return member;
	}
}
