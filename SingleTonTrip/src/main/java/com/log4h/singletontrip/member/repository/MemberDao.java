package com.log4h.singletontrip.member.repository;

import java.util.Map;

import com.log4h.singletontrip.member.domain.LoginVo;

public interface MemberDao {
	//로그인처리 (DB SELECT)
	public LoginVo login(Map<String, String> map);
}
