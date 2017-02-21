package com.log4h.singletontrip.member.repository;

import java.util.Map;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.PersonVo;

public interface MemberDao {
	//로그인처리 (DB SELECT)
	public LoginVo login(Map<String, String> map);
	//회원가입처리
	public int personMemberJoin(PersonVo personVo);
	public int companyMemberJoin(CompanyVo companyVo);
	public int personJoin(PersonVo personVo);
	public int companyJoin(CompanyVo companyVo);
}
