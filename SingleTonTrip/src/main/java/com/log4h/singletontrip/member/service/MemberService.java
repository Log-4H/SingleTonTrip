package com.log4h.singletontrip.member.service;

import com.log4h.singletontrip.member.domain.Member;

public interface MemberService {
	//로그인 처리
	public Member login(String loginId, String loginPw);
}
