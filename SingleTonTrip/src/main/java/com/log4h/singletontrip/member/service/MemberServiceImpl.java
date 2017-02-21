package com.log4h.singletontrip.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.member.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;

	//로그인 처리
	@Override
	public LoginVo login(String loginId, String loginPw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginId", loginId);
		map.put("loginPw", loginPw);
		LoginVo loginVo = memberDao.login(map);
		return loginVo;
	}

	//개인 회원 가입
	@Transactional
	@Override
	public int personJoin(PersonVo personVo) {
		int personResult = 0;
		//member 테이블 insert
		int joinResult = memberDao.personMemberJoin(personVo);
		if(joinResult >0){
			personResult = memberDao.personJoin(personVo);
		}
		return personResult;
	}

	//업체 회원 가입
	@Transactional
	@Override
	public int companyJoin(CompanyVo companyVo) {
		int companyResult = 0;
		int joinResult = memberDao.companyMemberJoin(companyVo);
		if(joinResult >0){
			companyResult = memberDao.companyJoin(companyVo);
		}
		return companyResult;
	}
}
