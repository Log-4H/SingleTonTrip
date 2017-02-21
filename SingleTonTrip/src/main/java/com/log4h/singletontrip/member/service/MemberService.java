package com.log4h.singletontrip.member.service;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.PersonVo;

public interface MemberService {
	//로그인 처리
	public LoginVo login(String loginId, String loginPw);
	//회원가입처리
	public int personJoin(PersonVo personVo);
	public int companyJoin(CompanyVo companyVo);
}
