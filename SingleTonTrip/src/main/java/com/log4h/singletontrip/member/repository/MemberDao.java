package com.log4h.singletontrip.member.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.member.domain.CompanyTypeVo;
import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.MemberVo;
import com.log4h.singletontrip.member.domain.PersonVo;

public interface MemberDao {
	//로그인처리 (DB SELECT)
	public LoginVo login(Map<String, String> map);
	//업체유형리스트
	public List<CompanyTypeVo> companyTypeList();
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
	//개인회원 상세보기
	public PersonVo personDetail(String memberId);
	//업체회원 상세보기
	public CompanyVo companyDetail(String memberId);
	//회원탈퇴처리
	public int memberDrop(Map<String, Object> map);
	//개인회원정보수정
	public int personModify(PersonVo personVo);
	//업체회원정보수정
	public int companyModify(CompanyVo companyVo);
	//아이디찾기
	public MemberVo memberIdFind(Map<String, Object> map);
	//비밀번호찾기
	public MemberVo memberPwFind(Map<String, Object> map);
	//랜덤비밀번호 업데이트
	public int memberPwUpdate(Map<String, Object> map);
	//친구추가
	public int friendAdd(Map<String, Object> map);
	//친구요청리스트
	public List<MemberVo> friendAddList(String memberId);
	//친구요청 수락&거절
	public int friendApprove(Map<String, Object> map);
	//친구요청 수락하면 친구 요청한 쪽에 리스트 추가
	public int friendApproveAdd(Map<String, Object> map);
	//친구리스트
	public List<MemberVo> friendTotalList(String sessionId);
	//친구신청확인
	public List<MemberVo> friendCheckList(String sessionId);
	//친구삭제
	public int friendDelete(Map<String, Object> map);
}
