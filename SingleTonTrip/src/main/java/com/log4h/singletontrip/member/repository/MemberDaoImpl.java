package com.log4h.singletontrip.member.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.MemberVo;
import com.log4h.singletontrip.member.domain.PersonVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String MEMBER_NS = "memberMapper.";

	//로그인처리 (DB SELECT)
	@Override
	public LoginVo login(Map<String, String> map) {
		return sqlSession.selectOne(MEMBER_NS+"login", map);
	}
	//개인회원가입
	@Override
	public int personMemberJoin(PersonVo personVo) {
		return  sqlSession.insert(MEMBER_NS+"personMemberJoin", personVo);
	}
	//업체회원가입
	@Override
	public int companyMemberJoin(CompanyVo companyVo) {
		return  sqlSession.insert(MEMBER_NS+"companyMemberJoin", companyVo);
	}
	//개인테이블에 추가 데이터 삽입
	@Override
	public int personJoin(PersonVo personVo) {
		return sqlSession.insert(MEMBER_NS+"personJoin", personVo);
	}
	//업체 테이블에 추가 데이터 삽입
	@Override
	public int companyJoin(CompanyVo companyVo) {
		return sqlSession.insert(MEMBER_NS+"companyJoin", companyVo);
	}
	//개인회원 총카운트
	@Override
	public int personTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(MEMBER_NS+"personTotalCount", map);
	}
	//개인회원 리스트
	@Override
	public List<PersonVo> personList(Map<String, Object> map) {
		return sqlSession.selectList(MEMBER_NS+"personList", map);
	}
	//업체회원 총카운트
	@Override
	public int companyTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(MEMBER_NS+"companyTotalCount", map);
	}
	//업체회원 리스트
	@Override
	public List<CompanyVo> companyList(Map<String, Object> map) {
		return sqlSession.selectList(MEMBER_NS+"companyList", map);
	}
	//개인회원상세보기
	@Override
	public PersonVo personDetail(String memberId) {
		return sqlSession.selectOne(MEMBER_NS+"personDetail", memberId);
	}
	//업체회원상세보기
	@Override
	public CompanyVo companyDetail(String memberId) {
		return sqlSession.selectOne(MEMBER_NS+"companyDetail", memberId);
	}
	//회원탈퇴처리
	@Override
	public int memberDrop(Map<String, Object> map) {
		return sqlSession.update(MEMBER_NS+"memberDrop", map);
	}
	//개인회원정보수정
	@Override
	public int personModify(PersonVo personVo) {
		return sqlSession.update(MEMBER_NS+"personModify", personVo);
	}
	//업체회원정보수정
	@Override
	public int companyModify(CompanyVo companyVo) {
		return sqlSession.update(MEMBER_NS+"companyModify", companyVo);
	}
	//아이디찾기
	@Override
	public MemberVo memberIdFind(Map<String, Object> map) {
		return sqlSession.selectOne(MEMBER_NS+"memberIdFind", map);
	}
	//비밀번호찾기
	@Override
	public MemberVo memberPwFind(Map<String, Object> map) {
		return sqlSession.selectOne(MEMBER_NS+"memberPwFind", map);
	}
	//랜덤비밀번호 업데이트
	@Override
	public int memberPwUpdate(Map<String, Object> map) {
		return sqlSession.update(MEMBER_NS+"memberPwUpdate", map);
	}
	//친구추가
	@Override
	public int friendAdd(Map<String, Object> map) {
 
		return sqlSession.insert(MEMBER_NS+"friendAdd", map);
	}
	//친구요청리스트
	@Override
	public List<MemberVo> friendAddList(String memberId) {
		return sqlSession.selectList(MEMBER_NS+"friendAddList", memberId);
	}
	//친구요청 수락&거절
	@Override
	public int friendApprove(Map<String, Object> map) {
		return sqlSession.update(MEMBER_NS+"friendApprove", map);
	}
	//친구리스트
	@Override
	public List<MemberVo> friendTotalList(String sessionId) {
		return sqlSession.selectList(MEMBER_NS+"friendTotalList", sessionId);
	}
	//친구요청 수락하면 친구 요청한 쪽에 리스트 추가
	@Override
	public int friendApprove2(Map<String, Object> map) {
		return sqlSession.insert(MEMBER_NS+"friendApprove2",map);
	}
	//친구신청확인
	@Override
	public List<MemberVo> friendCheckList(String sessionId) {
		return sqlSession.selectList(MEMBER_NS+"friendCheckList", sessionId);
	}
	//친구삭제
	@Override
	public int friendDelete(Map<String, Object> map) {

		return sqlSession.delete(MEMBER_NS+"friendDelete", map);
	}
	
}
