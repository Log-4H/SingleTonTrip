package com.log4h.singletontrip.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.MemberVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.member.repository.MemberDao;
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
	//회원탈퇴처리
	@Override
	public int memberDrop(String memberId, String memberPw) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("memberPw", memberPw);

		return memberDao.memberDrop(map);
	}
	//개인회원정보수정
	@Override
	public int personModify(PersonVo personVo) {
		
		return memberDao.personModify(personVo);
	}
	//업체회원정보수정
	@Override
	public int companyModify(CompanyVo companyVo) {
		
		return memberDao.companyModify(companyVo);
	}
	//친구추가
	@Override
	public int friendAdd(String memberId, String friendId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("friendId", friendId);
		return memberDao.friendAdd(map);
	}
	//친구요청리스트
	@Override
	public List<MemberVo> friendAddList(String memberId) {
		
		return memberDao.friendAddList(memberId);
	}
	//친구요청 수락&거절
	@Transactional
	@Override
	public int friendApprove(String memberId, int approveStateCd, String sessionId) {
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("approveStateCd", approveStateCd);
		map.put("sessionId", sessionId);
		memberDao.friendApprove(map);
		if(approveStateCd==2){
			result = memberDao.friendApprove2(map);
		}
		return result;
	}
	//친구리스트
	@Override
	public List<MemberVo> friendTotalList(String sessionId) {
		
		return memberDao.friendTotalList(sessionId);
	}
	//친구신청리스트
	@Override
	public List<MemberVo> friendCheckList(String sessionId) {
		return memberDao.friendCheckList(sessionId);
	}
	//친구삭제
	@Override
	public int friendDelete(String friendId, String sessionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("friendId", friendId);
		map.put("sessionId", sessionId);
		return memberDao.friendDelete(map);
	}
	
	
}
