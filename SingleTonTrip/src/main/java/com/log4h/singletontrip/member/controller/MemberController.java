package com.log4h.singletontrip.member.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.member.domain.CompanyTypeVo;
import com.log4h.singletontrip.member.domain.CompanyVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.member.domain.MemberVo;
import com.log4h.singletontrip.member.domain.PersonVo;
import com.log4h.singletontrip.member.service.MailService;
import com.log4h.singletontrip.member.service.MemberService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel", "pageId"})
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	
	@Autowired
    private MailService mailService;
	

	
	//로그인 폼 요청
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("member/login/memberLogin");
		return mv;	
	}

	//로그인 처리
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="loginId") String loginId, 
			@RequestParam(value="loginPw") String loginPw){
		ModelAndView mv = new ModelAndView("main");
		LoginVo loginVo = memberService.login(loginId, loginPw);
		mv.addObject("sessionId", loginVo.getMemberId());
		mv.addObject("sessionNm", loginVo.getMemberNm());
		mv.addObject("sessionLevel", loginVo.getMemberLevel());
		return mv;	
	}

	//로그아웃 처리
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(SessionStatus status){
		ModelAndView mv = new ModelAndView("redirect:main");
		status.setComplete();
		return mv;	
	}
	//개인 & 업체회원 선택 폼
	@RequestMapping(value="joinBegin", method=RequestMethod.GET)
	public ModelAndView joinBegin(){
		ModelAndView mv = new ModelAndView("member/join/joinBegin");
		return mv;	
	}
	//개인 & 업체약관폼
	@RequestMapping(value="joinTerms", method=RequestMethod.GET)
	public ModelAndView joinTerms(@RequestParam(value="memberLevel") int memberLevel){
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberLevel", memberLevel);
		if(memberLevel==2){
			mv.setViewName("member/join/companyTerms");
		}else{
			mv.setViewName("member/join/personTerms");
		}
		return mv;	
	}
	//개인회원 가입 폼 요청
	@RequestMapping(value="personJoin", method=RequestMethod.GET)
	public ModelAndView personJoin(@RequestParam(value="memberLevel") int memberLevel){
		ModelAndView mv = new ModelAndView("member/join/personJoin");
		mv.addObject("memberLevel", memberLevel);
		return mv;	
	}
	//업체 가입 폼 요청
	@RequestMapping(value="companyJoin", method=RequestMethod.GET)
	public ModelAndView companyJoin(@RequestParam(value="memberLevel") int memberLevel){
		ModelAndView mv = new ModelAndView("member/join/companyJoin");
		List<CompanyTypeVo> companyTypeList = memberService.companyTypeList();
		mv.addObject("companyTypeList", companyTypeList);
		mv.addObject("memberLevel", memberLevel);
		return mv;	
	}
	
	//개인회원 가입 처리
	@RequestMapping(value="personJoin", method=RequestMethod.POST)
	public ModelAndView personJoin(PersonVo personVo,
			@RequestParam(value="imgFile") MultipartFile imgFile){
		ModelAndView mv = new ModelAndView();
		int result = memberService.personMemberJoin(personVo, imgFile);
		if(result>0){
			mv.setViewName("main");
		}else{
			mv.setViewName("error/error");
		}
		return mv;	
	}
	//업체회원 가입 처리
	@RequestMapping(value="companyJoin", method=RequestMethod.POST)
	public ModelAndView companyJoin(CompanyVo companyVo,
			@RequestParam(value="imgFile") MultipartFile imgFile){
		ModelAndView mv = new ModelAndView();
		int result = memberService.companyMemberJoin(companyVo, imgFile);
		if(result>0){
			mv.setViewName("main");
		}else{
			mv.setViewName("error/error");
		}
		return mv;	
	}
	//개인회원리스트
	@RequestMapping(value="personList", method=RequestMethod.GET)
	public ModelAndView personList(
			@ModelAttribute("sessionId") String sessionId,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectOption", required=false) String selectOption,
			@RequestParam(value="selectValue", required=false) String selectValue
			){
		Map<String, Object> map = memberService.personList(currentPage, selectOption, selectValue, sessionId);
		ModelAndView mv = new ModelAndView("member/list/personList");
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("personList", map.get("personList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		return mv;	
	}
	//업체회원리스트
	@RequestMapping(value="companyList", method=RequestMethod.GET)
	public ModelAndView companyList(
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectOption", required=false) String selectOption,
			@RequestParam(value="selectValue", required=false) String selectValue
			){
		Map<String, Object> map = memberService.companyList(currentPage, selectOption, selectValue);
		ModelAndView mv = new ModelAndView("member/list/companyList");
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("companyList", map.get("companyList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		return mv;	
	}
	
	//관리자업체회원리스트
	@RequestMapping(value="adminCompanyList", method=RequestMethod.GET)
	public ModelAndView adminCompanyList(
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="selectOption", required=false) String selectOption,
			@RequestParam(value="selectValue", required=false) String selectValue
			){
		Map<String, Object> map = memberService.companyList(currentPage, selectOption, selectValue);
		ModelAndView mv = new ModelAndView("member/list/adminCompanyList");
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("companyList", map.get("companyList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		return mv;	
	}
	
	//개인회원상세보기
	@RequestMapping(value="personDetail", method=RequestMethod.GET)
	public ModelAndView personDetail(@RequestParam(value="memberId") String memberId){
		ModelAndView mv = new ModelAndView("member/detail/personDetail");
		mv.addObject("personVo" , memberService.personDetail(memberId));
		return mv;
	}
	//개인회원상세보기(포스트)
	@RequestMapping(value="personDetail", method=RequestMethod.POST)
	public ModelAndView personDetailPost(@ModelAttribute("pageId") String pageId){
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("person" , memberService.personDetail(pageId));
		return mv;
	}
	//업체회원상세보기
	@RequestMapping(value="companyDetail", method=RequestMethod.GET)
	public ModelAndView companyDetail(@RequestParam(value="memberId") String memberId){
		ModelAndView mv = new ModelAndView("member/detail/companyDetail");
		mv.addObject("companyVo" , memberService.companyDetail(memberId));
		return mv;
	}
	//업체회원상세보기(포스트)
	@RequestMapping(value="companyDetail", method=RequestMethod.POST)
	public ModelAndView companyDetailPost(@ModelAttribute("pageId") String pageId){
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("company" , memberService.companyDetail(pageId));
		return mv;
	}
	//개인&업체회원탈퇴처리화면요청
	@RequestMapping(value="memberDrop", method=RequestMethod.GET)
	public ModelAndView memberDrop(
			@RequestParam(value="memberId") String memberId){
		ModelAndView mv = new ModelAndView("member/drop/memberDrop");
		mv.addObject("memberId", memberId);
		return mv;
	}

	//개인&업체회원탈퇴처리
	@RequestMapping(value="memberDrop", method=RequestMethod.POST)
	public ModelAndView memberDrop(
			@RequestParam(value="memberId") String memberId,
			@RequestParam(value="memberPw") String memberPw){
		memberService.memberDrop(memberId, memberPw);
		ModelAndView mv = new ModelAndView("redirect:main");
		return mv;
	}
	 
	//개인회원정보수정화면요청
	@RequestMapping(value="personModify",method=RequestMethod.GET)
	public ModelAndView personModify(PersonVo personVo,
			@RequestParam(value="memberId") String memberId){
		ModelAndView mv = new ModelAndView("member/modify/personModify");
		mv.addObject("personVo" , memberService.personDetail(memberId));
		return mv;
	}

	//업체회원정보수정화면요청
	@RequestMapping(value="companyModify",method=RequestMethod.GET)
	public ModelAndView companyModify(CompanyVo companyVo,
			@RequestParam(value="memberId") String memberId){
		ModelAndView mv = new ModelAndView("member/modify/companyModify");
		List<CompanyTypeVo> companyTypeList = memberService.companyTypeList();
		mv.addObject("companyTypeList", companyTypeList);
		mv.addObject("companyVo" , memberService.companyDetail(memberId));
		return mv;
	}
	
	//개인회원정보수정
	@RequestMapping(value="personModify",method=RequestMethod.POST)
	public ModelAndView personModify(PersonVo personVo,
			@RequestParam(value="imgFile") MultipartFile imgFile){
		ModelAndView mv = new ModelAndView();
		int result = memberService.personModify(personVo, imgFile);
		if(result>0){
			mv.setViewName("main");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;
	}
	
	//업체회원정보수정
	@RequestMapping(value="companyModify",method=RequestMethod.POST)
	public ModelAndView companyModify(CompanyVo companyVo,
			@RequestParam(value="imgFile") MultipartFile imgFile){
		ModelAndView mv = new ModelAndView();
		int result = memberService.companyModify(companyVo, imgFile);
		if(result>0){
			mv.setViewName("main");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;
	}
	
	//아이디찾기화면요청
	@RequestMapping(value="memberIdFind", method=RequestMethod.GET)
	public ModelAndView memberIdFind(){
		ModelAndView mv = new ModelAndView("member/find/idFind");
		return mv;
		
	}
	
	//아이디찾기
	@RequestMapping(value="memberIdFind", method=RequestMethod.POST)
	public ModelAndView memberIdFind(
			@RequestParam(value="memberNm")String memberNm,
			@RequestParam(value="memberEmail")String memberEmail){
		ModelAndView mv = new ModelAndView();
		int result = mailService.SendId(memberNm, memberEmail);
		if(result>0){
			mv.setViewName("redirect:main");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;
		
	}
	
	//비밀번호찾기화면요청
	@RequestMapping(value="memberPwFind", method=RequestMethod.GET)
	public ModelAndView memberPwFind(){
		ModelAndView mv = new ModelAndView("member/find/pwFind");
		
		return mv;
		
	}
	
	//비밀번호찾기
	@RequestMapping(value="memberPwFind", method=RequestMethod.POST)
	public ModelAndView memberPwFind(
			@RequestParam(value="memberNm")String memberNm,
			@RequestParam(value="memberEmail")String memberEmail,
			@RequestParam(value="memberId")String memberId){	
		ModelAndView mv = new ModelAndView();
		int result = mailService.SendPw(memberNm, memberEmail, memberId);
		if(result>0){
			mv.setViewName("redirect:main");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;
	}
	//친구페이지
	@RequestMapping(value="friend", method=RequestMethod.GET)
	public ModelAndView friend(){
		ModelAndView mv = new ModelAndView("friend/friend");
		return mv;
	}
	//친구추가
	@RequestMapping(value="friendAdd", method=RequestMethod.GET)
	public ModelAndView friendAdd(
			@ModelAttribute("sessionId") String memberId,
			@RequestParam(value="memberId") String friendId){
		ModelAndView mv = new ModelAndView();
		int result = memberService.friendAdd(memberId, friendId);
		if(result>0){
			mv.setViewName("redirect:friendCheckList");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;	
	}
	//친구요청리스트
	@RequestMapping(value="friendAddList", method=RequestMethod.GET)
	public ModelAndView friendList(
			@ModelAttribute("sessionId") String memberId){	
		ModelAndView mv = new ModelAndView("friend/friendAddList");
		List<MemberVo> friendAddList = memberService.friendAddList(memberId);
		mv.addObject("friendAddList",friendAddList);
		return mv;
		
	}
	//친구요청 수락&거절
	@RequestMapping(value="friendApprove", method=RequestMethod.GET)
	public ModelAndView friendApprove(
			@RequestParam("memberId") String memberId,
			@ModelAttribute("sessionId") String sessionId,
			@RequestParam("approveStateCd") int approveStateCd){	
		ModelAndView mv = new ModelAndView();
		int result = memberService.friendApprove(memberId, approveStateCd, sessionId);
		if(result>0){
			mv.setViewName("redirect:friendAddList");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;	
	}
	//친구리스트
	@RequestMapping(value="friendTotalList", method=RequestMethod.GET)
	public ModelAndView friendTotalList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId){	
		ModelAndView mv = new ModelAndView("friend/friendTotalList");
		List<MemberVo> friendTotalList = memberService.friendTotalList(sessionId);
		mv.addObject("friendTotalList", friendTotalList);
		return mv;	
	}
	//친구신청리스트
	@RequestMapping(value="friendCheckList", method=RequestMethod.GET)
	public ModelAndView friendCheckList(
			@ModelAttribute("sessionId") String sessionId){	
		ModelAndView mv = new ModelAndView("friend/friendCheckList");
		List<MemberVo> friendCheckList = memberService.friendCheckList(sessionId);
		mv.addObject("friendCheckList", friendCheckList);
		return mv;	
	}
	//친구삭제
	@RequestMapping(value="friendDelete", method=RequestMethod.GET)
	public ModelAndView friendDelete(
			@ModelAttribute("sessionId") String sessionId,
			@RequestParam("friendId") String friendId){	
		ModelAndView mv = new ModelAndView();
		int result = memberService.friendDelete(friendId, sessionId);
		if(result>0){
			mv.setViewName("redirect:friendTotalList");
		}
	 	return mv;	
	}
	//친구체크
	@RequestMapping(value="pageFriendCheck", method=RequestMethod.GET)
	public ModelAndView pageFriendCheck(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId){	
		ModelAndView mv = new ModelAndView("jsonView");
		MemberVo pageFriendCheck = memberService.pageFriendCheck(pageId,sessionId);
		mv.addObject("pageFriendCheck", pageFriendCheck);
		return mv;
	}
}
