package com.log4h.singletontrip.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.member.domain.CompanyTypeVo;
import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.MemberVo;
import com.log4h.singletontrip.member.domain.PersonVo;

public interface MemberService {
	//로그인 처리
	public LoginVo login(String loginId, String loginPw);
	//업체유형리스트
	public List<CompanyTypeVo> companyTypeList();
	//개인 회원가입
	public int personMemberJoin(PersonVo personVo, MultipartFile imgFile);
	//업체 회원가입
	public int companyMemberJoin(CompanyVo companyVo, MultipartFile imgFile);
	//개인회원리스트
	public Map<String, Object> personList(int currentPage, String selectOption, String selectValue,  String sessionId);
	//업체회원리스트
	public Map<String, Object> companyList(int currentPage, String selectOption, String selectValue);
	//개인회원 상세보기
	public PersonVo personDetail(String memberId);
	//업체회원 상세보기
	public CompanyVo companyDetail(String memberId);
	//회원탈퇴처리
	public int memberDrop(String memberId, String memberPw);
	//개인회원정보수정
	public int personModify(PersonVo personVo, MultipartFile imgFile);
	//업체회원정보수정
	public int companyModify(CompanyVo companyVo, MultipartFile imgFile);
	//친구추가
	public int friendAdd(String memberId, String friendId);
	//친구요청리스트
	public List<MemberVo> friendAddList(String memberId);
	//친구요청 수락&거절
	public int friendApprove(String memberId, int approveStateCd, String sessionId);
	//친구리스트
	public List<MemberVo> friendTotalList(String sessionId);
	//친구신청리스트
	public List<MemberVo> friendCheckList(String sessionId);
	//친구삭제
	public int friendDelete(String friendId, String sessionId);
}
