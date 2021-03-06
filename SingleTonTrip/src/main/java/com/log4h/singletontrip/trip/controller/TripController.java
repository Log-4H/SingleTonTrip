package com.log4h.singletontrip.trip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.trip.domain.GroupVo;
import com.log4h.singletontrip.trip.domain.PlanVo;
import com.log4h.singletontrip.trip.domain.RegionVo;
import com.log4h.singletontrip.trip.domain.TripVo;
import com.log4h.singletontrip.trip.service.TripService;

@SessionAttributes({"sessionId", "sessionNm", "sessionLevel", "pageId"})
@Controller
public class TripController {
	@Autowired
	private TripService tripService;
	//여행 리스트
	@RequestMapping(value="tripList")
	public ModelAndView tripList(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow){
		ModelAndView mv = new ModelAndView("jsonView");
		List<TripVo> tripList= tripService.tripList(pageId, lastTripRow);
		mv.addObject("tripList", tripList);
		return mv;	
	}
	//상단바여행 리스트
	@RequestMapping(value="mainTripList")
	public ModelAndView mainTripList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "selectOption", required = false) String selectOption,
			@RequestParam(value = "selectValue", required = false) String selectValue){
		Map<String, Object> map = tripService.tripList(selectOption, selectValue, currentPage);
		ModelAndView mv = new ModelAndView("trip/tripList");
		mv.addObject("currentPage", currentPage);
		mv.addObject("selectOption", selectOption);
		mv.addObject("selectValue", selectValue);
		mv.addObject("tripList", map.get("tripList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		return mv;	
	}
	//여행 상세보기
	@RequestMapping(value="tripView")
	public ModelAndView tripView(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = tripService.tripView(pageId, tripNo);
		mv.addObject("trip", map.get("trip"));
		mv.addObject("planList", map.get("planList"));
		return mv;	
	}
	//여행 상세보기
	@RequestMapping(value="planList")
	public ModelAndView planDetail(@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("jsonView");
		List<PlanVo> planList = tripService.planList(tripNo);
		mv.addObject("planList", planList);
		return mv;	
	}
	//상단바여행 상세보기
	@RequestMapping(value="tripDetail")
	public ModelAndView tripView(@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("trip/tripDetail");
		Map<String, Object> map = tripService.tripDetail(tripNo);
		mv.addObject("trip", map.get("trip"));
		mv.addObject("planList", map.get("planList"));
		return mv;	
	}
	//여행등록폼 요청
	@RequestMapping(value="tripAdd", method=RequestMethod.GET)
	public ModelAndView tripAdd(){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = tripService.tripAddForm();
		mv.addObject("tripThemeList", map.get("tripThemeList"));
		mv.addObject("regionDoList", map.get("regionDoList"));
		return mv;
	}
	//여행지역(시) 리스트 출력
	@RequestMapping(value="regionSiList", method=RequestMethod.POST)
	public ModelAndView regionSiList(@RequestParam(value="regionDo") String regionDo){
		ModelAndView mv = new ModelAndView("jsonView");
		List<RegionVo> regionSiList = tripService.regionSiList(regionDo);
		mv.addObject("regionSiList", regionSiList);
		return mv;
	}
	
	//여행등록처리
	@RequestMapping(value="tripAdd", method=RequestMethod.POST)
	public ModelAndView tripAdd(@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow, TripVo tripVo){
		ModelAndView mv = new ModelAndView("jsonView");
		tripVo.setPersonId(sessionId);
		int result = tripService.tripAdd(tripVo);
		if(result>0){
			List<TripVo> tripList= tripService.tripList(pageId, lastTripRow);
			mv.addObject("tripList", tripList);
		}
		return mv;
	}
	//여행일정 등록
	@RequestMapping(value="planAdd", method=RequestMethod.POST)
	public ModelAndView planAdd(@ModelAttribute("pageId") String pageId, PlanVo planVo){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.planAdd(planVo);
		if(result>0){
			Map<String, Object> map = tripService.tripView(pageId, planVo.getTripNo());
			mv.addObject("trip", map.get("trip"));
			mv.addObject("planList", map.get("planList"));
		}
		return mv;
	}
	//여행일정 수정 폼 요청
	@RequestMapping(value="planView", method=RequestMethod.POST)
	public ModelAndView planView(@RequestParam(value="planNo") int planNo){
		ModelAndView mv = new ModelAndView("jsonView");
		PlanVo plan = tripService.planView(planNo);
		mv.addObject("plan", plan);
		return mv;
	}
	//여행일정 수정
	@RequestMapping(value="planUpdate", method=RequestMethod.POST)
	public ModelAndView planUpdate(@ModelAttribute("pageId") String pageId,
			PlanVo planVo){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.planUpdate(planVo);
		if(result>0){
			Map<String, Object> map = tripService.tripView(pageId, planVo.getTripNo());
			mv.addObject("trip", map.get("trip"));
			mv.addObject("planList", map.get("planList"));
		}
		return mv;
	}
	//여행일정 삭제
	@RequestMapping(value="planDelete", method=RequestMethod.POST)
	public ModelAndView planDelete(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="planNo") int planNo,
			@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.planDelete(planNo);
		if(result>0){
			Map<String, Object> map = tripService.tripView(pageId, tripNo);
			mv.addObject("trip", map.get("trip"));
			mv.addObject("planList", map.get("planList"));
		}
		return mv;
	}
	//그룹 리스트
	@RequestMapping(value="groupList")
	public ModelAndView groupList(@ModelAttribute("sessionId") String sessionId,
			@RequestParam(value="groupMemberLevel") String groupMemberLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> map = tripService.groupList(sessionId, groupMemberLevel, currentPage);
		mv.addObject("currentPage", currentPage);
		mv.addObject("groupList", map.get("groupList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));
		return mv;	
	}
	//여행 상세보기
	@RequestMapping(value="groupView")
	public ModelAndView groupView(@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = tripService.groupView(tripNo);
		mv.addObject("trip", map.get("trip"));
		mv.addObject("groupMemberList", map.get("groupMemberList"));
		return mv;	
	}
	//여행그룹참가체크
	@RequestMapping(value="tripJoinCheck")
	public ModelAndView tripJoinCheck(@RequestParam(value="tripNo") int tripNo,
			@ModelAttribute("sessionId") String sessionId){
		ModelAndView mv = new ModelAndView("jsonView");
		GroupVo group = tripService.tripJoinCheck(sessionId, tripNo);
		mv.addObject("group", group);
		return mv;	
	}
	//여행그룹참가신청
	@RequestMapping(value="tripJoin")
	public ModelAndView tripJoin(@RequestParam(value="tripNo") int tripNo,
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.groupApply(sessionId, tripNo);
		if(result>0){
			List<TripVo> tripList= tripService.tripList(pageId, lastTripRow);
			mv.addObject("tripList", tripList);
		}
		return mv;	
	}
	//navbar 여행그룹참가신청
	@RequestMapping(value="tripApply")
	public ModelAndView tripApply(@RequestParam(value="tripNo") int tripNo,
			@ModelAttribute("sessionId") String sessionId){
		ModelAndView mv = new ModelAndView();
		int result = tripService.groupApply(sessionId, tripNo);
		if(result>0){
			mv.setViewName("redirect:mainTripList");
		}else{
			mv.setViewName("redirect:error");
		}
		return mv;	
	}
	//참가신청멤버 리스트
	@RequestMapping(value="applyMemberList")
	public ModelAndView applyMemberList(@RequestParam(value="tripNo") int tripNo,
			@RequestParam(value="approveStateCd") int approveStateCd){
		ModelAndView mv = new ModelAndView("jsonView");
		List<GroupVo> groupMemberList = tripService.applyMemberList(tripNo, approveStateCd);
		mv.addObject("groupMemberList", groupMemberList);
		return mv;	
	}
	//그룹참가 승인or거절
	@RequestMapping(value="groupApprove")
	public ModelAndView groupApprove(@RequestParam(value="tripNo") int tripNo,
			@RequestParam(value="personId") String personId,
			@RequestParam(value="approveStateCd") int approveStateCd){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.groupApprove(approveStateCd, tripNo, personId);
		if(result>0){
			Map<String, Object> map = tripService.groupView(tripNo);
			mv.addObject("trip", map.get("trip"));
			mv.addObject("groupMemberList", map.get("groupMemberList"));
		}
		return mv;	
	}
	//여행 수정폼 요청
	@RequestMapping(value="tripModifyForm", method=RequestMethod.GET)
	public ModelAndView tripModifyForm(@ModelAttribute("pageId") String pageId,
			@RequestParam(value="tripNo") int tripNo){
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = tripService.tripModifyForm(pageId, tripNo);
		mv.addObject("trip", map.get("trip"));
		mv.addObject("tripThemeList", map.get("tripThemeList"));
		mv.addObject("regionDoList", map.get("regionDoList"));
		mv.addObject("regionSiList", map.get("regionSiList"));
		return mv;	
	}
	//여행 수정 처리
	@RequestMapping(value="tripModify", method=RequestMethod.POST)
	public ModelAndView tripModifyForm(@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow, TripVo tripVo){
		ModelAndView mv = new ModelAndView("jsonView");
		tripVo.setPersonId(sessionId);
		int result = tripService.tripUpdate(tripVo);
		if(result>0){
			List<TripVo> tripList= tripService.tripList(pageId, lastTripRow);
			mv.addObject("tripList", tripList);
		}
		return mv;	
	}
	//여행 마감
	@RequestMapping(value="tripEnd", method=RequestMethod.POST)
	public ModelAndView tripEnd(@RequestParam(value="tripNo") int tripNo,
			@RequestParam(value="pageId", required=false) String pageId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.tripEnd(tripNo);
		if(pageId != null && result>0){
			List<TripVo> tripList= tripService.tripList(pageId, lastTripRow);
			mv.addObject("tripList", tripList);
		}
		return mv;
	}
	//여행 삭제
	@RequestMapping(value="tripDelete", method=RequestMethod.POST)
	public ModelAndView tripDelete(@RequestParam(value="tripNo") int tripNo,
			@ModelAttribute("pageId") String pageId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.tripDelete(tripNo);
		if(result>0){
			List<TripVo> tripList= tripService.tripList(pageId, lastTripRow);
			mv.addObject("tripList", tripList);
		}
		return mv;	
	}
	//그룹가입취소
	@RequestMapping(value="applyCancel", method=RequestMethod.POST)
	public ModelAndView groupApplyCancel(@RequestParam(value="tripNo") int tripNo,
			@ModelAttribute("sessionId") String sessionId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="groupMemberLevel", defaultValue="1") String groupMemberLevel){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.groupApplyCancel(tripNo, sessionId);
		if(result>0){
			Map<String,Object> map = tripService.groupList(sessionId, groupMemberLevel, currentPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("groupList", map.get("groupList"));
			mv.addObject("startPage", map.get("startPage"));
			mv.addObject("pageSize", map.get("pageSize"));
			mv.addObject("endPage", map.get("endPage"));
			mv.addObject("lastPage", map.get("lastPage"));
		}
		return mv;	
	}
	//그룹가입탈퇴
	@RequestMapping(value="groupDrop", method=RequestMethod.POST)
	public ModelAndView groupMemberDrop(@RequestParam(value="tripNo") int tripNo,
			@ModelAttribute("sessionId") String sessionId,
			@RequestParam(value="lastTripRow", defaultValue="5") int lastTripRow,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="groupMemberLevel", defaultValue="1") String groupMemberLevel){
		ModelAndView mv = new ModelAndView("jsonView");
		int result = tripService.groupMemberDrop(tripNo, sessionId);
		if(result>0){
			Map<String,Object> map = tripService.groupList(sessionId, groupMemberLevel, currentPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("groupList", map.get("groupList"));
			mv.addObject("startPage", map.get("startPage"));
			mv.addObject("pageSize", map.get("pageSize"));
			mv.addObject("endPage", map.get("endPage"));
			mv.addObject("lastPage", map.get("lastPage"));
		}
		return mv;	
	}
}
