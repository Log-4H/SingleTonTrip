package com.log4h.singletontrip.member.service;

import java.util.Map;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.FindVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.PersonVo;

public interface MemberService {
	//로그인 처리
	public LoginVo login(String loginId, String loginPw);
	//개인 회원가입
	public int personJoin(PersonVo personVo);
	//업체 회원가입
	public int companyJoin(CompanyVo companyVo);
	//개인회원리스트
	public Map<String, Object> personList(int currentPage, String selectOption, String selectValue);
	//업체회원리스트
	public Map<String, Object> companyList(int currentPage, String selectOption, String selectValue);
	//개인회원 상세보기
	public PersonVo personDetail(String memberId);
	//업체회원 상세보기
	public CompanyVo companyDetail(String memberId);
	//회원탈퇴처리
	public int memberDrop(String memberId, String memberPw);
	//개인회원정보수정
	public int personModify(PersonVo personVo);
	//업체회원정보수정
	public int companyModify(CompanyVo companyVo);
	//친구신청
	public int friendAdd(String memberId,String friendId);
	}
