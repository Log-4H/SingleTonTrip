package com.log4h.singletontrip.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.member.domain.CompanyTypeVo;
import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.MemberVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.member.repository.MemberDao;
import com.log4h.singletontrip.util.ImageUpload;
import com.log4h.singletontrip.util.Paging;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;

	//로그인 처리
	@Override
	@Transactional
	public LoginVo login(String loginId, String loginPw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginId", loginId);
		map.put("loginPw", loginPw);
		LoginVo loginVo = memberDao.login(map);
		if(loginVo != null && loginVo.getMemberLevel() == 3){
			final int loginMileageCate = 2;
			loginVo.setLoginMileageCate(loginMileageCate);
			int	result = memberDao.addLoginMileage(loginVo);
		}
		return loginVo;
	}
	
	//업체유형리스트
	@Override
	public List<CompanyTypeVo> companyTypeList() {
		return memberDao.companyTypeList();
	}

	//개인 회원 가입
	@Transactional
	@Override
	public int personMemberJoin(PersonVo personVo, MultipartFile imgFile) {
		ImageUpload imageUpload = new ImageUpload();
		String personImg = imageUpload.uploadImage(imgFile);
		if(personImg!=null){
			personVo.setMemberImg(personImg);
		}
		int personResult = 0;
		personResult = memberDao.personMemberJoin(personVo);
			int lastResult = 0;
			if(personResult>0){
				lastResult = memberDao.personJoin(personVo);
			}
		return lastResult;
	}

	//업체 회원 가입
	@Transactional
	@Override
	public int companyMemberJoin(CompanyVo companyVo, MultipartFile imgFile) {
		ImageUpload imageUpload = new ImageUpload();
		String companyImg = imageUpload.uploadImage(imgFile);
		companyVo.setCompanyAddress(companyVo.getCompanyAddressSelect()+companyVo.getCompanyAddressDetail());
		if(companyImg!=null){
			companyVo.setMemberImg(companyImg);
		}
		int companyResult = 0;
		companyResult = memberDao.companyMemberJoin(companyVo);
			int lastResult = 0;
			if(companyResult>0){
				lastResult = memberDao.companyJoin(companyVo);
			}
		return lastResult;
	}
	//개인회원리스트
	@Override
	public Map<String, Object> personList(int currentPage, String selectOption,
			String selectValue, String sessionId) {
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
        int personTotalCount = memberDao.personTotalCount(totalCountMap);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, personTotalCount);
        map.put("selectOption", selectOption);
        map.put("selectValue", selectValue);
        map.put("sessionId", sessionId);
        List<PersonVo> personList = memberDao.personList(map);
        map.put("personList", personList);
		return map;
	}
	//업체회원리스트
	@Override
	public Map<String, Object> companyList(int currentPage, String selectOption, String selectValue) {
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
        int companyTotalCount = memberDao.companyTotalCount(totalCountMap);
        Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, companyTotalCount);
        map.put("selectOption", selectOption);
        map.put("selectValue", selectValue);
        List<CompanyVo> companyList = memberDao.companyList(map);
        map.put("companyList", companyList);
		return map;
	}
	//개인회원상세보기
	@Override
	public PersonVo personDetail(String memberId) {
		
		return memberDao.personDetail(memberId);
	}
	//업체회원상세보기
	@Override
	public CompanyVo companyDetail(String memberId) {
		
		return memberDao.companyDetail(memberId);
	}
	//회원탈퇴처리
	@Override
	public int memberDrop(String memberId, String memberPw) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("memberPw", memberPw);

		return memberDao.memberDrop(map);
	}
	//개인회원정보수정
	@Override
	public int personModify(PersonVo personVo, MultipartFile imgFile) {
		ImageUpload imageUpload = new ImageUpload();
		String personImg = imageUpload.uploadImage(imgFile);
		if(personImg!=null){
			personVo.setMemberImg(personImg);
		}
		int personResult = 0;
		personResult = memberDao.personModify(personVo);
		return personResult;
	}
	//업체회원정보수정
	@Override
	public int companyModify(CompanyVo companyVo, MultipartFile imgFile) {
		ImageUpload imageUpload = new ImageUpload();
		String companyImg = imageUpload.uploadImage(imgFile);
		if(companyImg!=null){
			companyVo.setMemberImg(companyImg);
		}
		int companyResult = 0;
		companyResult = memberDao.companyModify(companyVo);
		return companyResult;
	}
	//친구추가
	@Override
	public int friendAdd(String memberId, String friendId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("friendId", friendId);
		return memberDao.friendAdd(map);
	}
	//친구요청리스트
	@Override
	public List<MemberVo> friendAddList(String memberId) {
		
		return memberDao.friendAddList(memberId);
	}
	//친구요청 수락&거절
	@Transactional
	@Override
	public int friendApprove(String memberId, int approveStateCd, String sessionId) {
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("approveStateCd", approveStateCd);
		map.put("sessionId", sessionId);
		memberDao.friendApprove(map);
		if(approveStateCd==2){
			result = memberDao.friendApproveAdd(map);
		}
		return result;
	}
	//친구리스트
	@Override
	public List<MemberVo> friendTotalList(String sessionId) {
		
		return memberDao.friendTotalList(sessionId);
	}
	//친구신청리스트
	@Override
	public List<MemberVo> friendCheckList(String sessionId) {
		return memberDao.friendCheckList(sessionId);
	}
	//친구삭제
	@Override
	public int friendDelete(String friendId, String sessionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("friendId", friendId);
		map.put("sessionId", sessionId);
		return memberDao.friendDelete(map);
	}

	@Override
	public MemberVo pageFriendCheck(String pageId, String sessionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageId", pageId);
		map.put("sessionId", sessionId);
		return memberDao.pageFriendCheck(map);
	}

	
}
