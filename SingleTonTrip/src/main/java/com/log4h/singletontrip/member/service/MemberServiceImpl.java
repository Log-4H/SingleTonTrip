package com.log4h.singletontrip.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.member.repository.MemberDao;
import com.log4h.singletontrip.member.repository.MemberDaoImpl;
import com.log4h.singletontrip.util.Paging;

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
	//개인회원리스트
	@Override
	public Map<String, Object> personList(int currentPage, String selectOption,
			String selectValue) {
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
        int personTotalCount = memberDao.personTotalCount(totalCountMap);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, personTotalCount);
        map.put("selectOption", selectOption);
        map.put("selectValue", selectValue);
        List<PersonVo> personList = memberDao.personList(map);
        map.put("personList", personList);
		return map;
	}
	//업체회원리스트
	@Override
	public Map<String, Object> companyList(int currentPage, String selectOption, String selectValue) {
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
        int companyTotalCount = memberDao.companyTotalCount(totalCountMap);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, companyTotalCount);
        map.put("selectOption", selectOption);
        map.put("selectValue", selectValue);
        List<CompanyVo> companyList = memberDao.companyList(map);
        map.put("companyList", companyList);
		return map;
	}
	//개인회원상세보기
	@Override
	public PersonVo personDetail(String memberId) {
		
		return memberDao.personDetail(memberId);
	}
	//업체회원상세보기
	@Override
	public CompanyVo companyDetail(String memberId) {
		
		return memberDao.companyDetail(memberId);
	}
}
