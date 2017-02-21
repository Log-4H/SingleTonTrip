package com.log4h.singletontrip.member.repository;

import java.util.Map;

import com.log4h.singletontrip.member.domain.Member;

public interface MemberDao {
	//로그인처리 (DB SELECT)
	public Member login(Map<String, String> map);
}
