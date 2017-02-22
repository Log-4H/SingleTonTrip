package com.log4h.singletontrip.member.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.PersonVo;

public interface MemberDao {
	//로그인처리 (DB SELECT)
	public LoginVo login(Map<String, String> map);
	//개인회원가입
	public int personMemberJoin(PersonVo personVo);
	//업체회원가입
	public int companyMemberJoin(CompanyVo companyVo);
	//개인테이블에 추가 데이터 삽입
	public int personJoin(PersonVo personVo);
	//업체 테이블에 추가 데이터 삽입
	public int companyJoin(CompanyVo companyVo);
	//개인회원 총카운트
	public int personTotalCount(Map<String, Object> map);
	//개인회원 리스트
	public List<PersonVo> personList(Map<String,Object> map);
	//업체회원 총카운트
	public int companyTotalCount(Map<String, Object> map);
	//업체회원 리스트
	public List<CompanyVo> companyList(Map<String,Object> map);
}
