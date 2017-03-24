package com.log4h.singletontrip.ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.ad.service.AdService;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;

@Controller
@SessionAttributes({"sessionId", "sessionNm", "sessionLevel"})
public class AdController {
	/*
	 * 모든 메소드의 리턴타입은 ModelAndView 로한다 (String 타입 x)
	 * 
	 * - ModelAndView mv = new ModelAndView(); 
	 *  : 메소드 첫 부분에 ModelAndView 생성하자. 필수 
	 *  : 매개변수에 Model model 넣을 필요없다.
	 *   
	 * - mv.addObject()
	 * 	: jsp에서 데이터를 받아야할땐 mv.addObject("view에서사용하는데이터명", 데이터변수이름) 하면된다.
	 * 
	 * - mv.setViewName()
	 * 	: url을 설정한다.
	 * 	: 포워딩 (view폴더 아래의 .jsp로 간다)
	 * 	  mv.setViewName("example/exampleAdd")
	 * 	: 리다이렉트(controller에 맵핑된 주소로간다.) 
	 * 	  mv.setViewName("redirect:example/exampleAdd")
	 */
	@Autowired
	private AdService adService;
	
	
	// 광고 신청 승인
	@RequestMapping(value="adApprove")
	public ModelAndView adApprove(
			@ModelAttribute("sessionId") String adminId, 
			@RequestParam(value="adNo") int adNo,
			@RequestParam(value="companyId") String companyId,
			@RequestParam(value="adGroupCd") int adGroupCd){
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("adGroupCd", adGroupCd);
		map.put("companyId", companyId);
		map.put("adminId", adminId);
		map.put("adNo", adNo);
		adService.adApprove(map);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:adApplyList");
		
		return mv;
	}
	
	// 광고 신청 거절
	@RequestMapping(value="adRefuse")
	public ModelAndView adRefuse(@ModelAttribute("sessionId") String adminId,
			@RequestParam(value="adNo") int adNo){
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("adminId", adminId);
		map.put("adNo", adNo);
		adService.adRefuse(map);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:adApplyList");
		
		return mv;
	}
	
	// 광고 신청목록에서 환불요청
	@RequestMapping(value="paybackApply")
	public ModelAndView paybackApply(
			@RequestParam(value="adNo") int adNo){
		ModelAndView mv = new ModelAndView();
		adService.paybackApply(adNo);
		mv.setViewName("redirect:adApplyList");
		
		return mv;
	}
	
	// 환불 리스트
	@RequestMapping(value="payCancelList")
	public ModelAndView payCancelList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView();
		LoginVo loginVo = new LoginVo();
		loginVo.setMemberId(sessionId);
		loginVo.setMemberLevel(sessionLevel);
		Map<String,Object>map = adService.paybackList(loginVo,currentPage);
		mv.addObject("currentPage",currentPage);
		mv.addObject("paybackList",map.get("paybackList"));
		mv.addObject("startPage",map.get("startPage"));
		mv.addObject("pageSize",map.get("pageSize"));
		mv.addObject("endPage",map.get("endPage"));
		mv.addObject("lastPage",map.get("lastPage"));		
		mv.setViewName("payment/payCancelList");
		
		
		return mv;
	}
	
	// 환불
	@RequestMapping(value="payback")
	public ModelAndView payback(
			@RequestParam(value="memberId") String memberId,
			@RequestParam(value="paymentTotalPrice") int paymentTotalPrice,
			@RequestParam(value="paymentTargetNo") int paymentTargetNo){
		ModelAndView mv = new ModelAndView("redirect:payCancelList");
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("paymentTotalPrice", paymentTotalPrice);
		map.put("paymentTargetNo", paymentTargetNo);
		adService.payback(map);
		
		
		return mv;
	}
	
	// 환불 취소
	@RequestMapping(value="paybackCancel")
	public ModelAndView paybackCancel(
			@RequestParam(value="paymentTargetNo") int paymentTargetNo){
		ModelAndView mv = new ModelAndView("redirect:payCancelList");
		adService.paybackCancel(paymentTargetNo);
		
		return mv;
	}
	
	// 광고 리스트
	@RequestMapping(value="adList")
	public ModelAndView adList(
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		ModelAndView mv = new ModelAndView();
		Map<String,Object>map = adService.selectAdList(currentPage);
		mv.addObject("currentPage",currentPage);
		mv.addObject("adList",map.get("adList"));
		mv.addObject("startPage",map.get("startPage"));
		mv.addObject("pageSize",map.get("pageSize"));
		mv.addObject("endPage",map.get("endPage"));
		mv.addObject("lastPage",map.get("lastPage"));		
		mv.setViewName("advertisement/adList");
		
		return mv;
	}
	
	// 광고 리스트에서 이미지 파일 수정
	@RequestMapping(value="imgUpload", method=RequestMethod.POST)
	public ModelAndView imgUpload(MultipartHttpServletRequest multi, AdVo adVo){
		ModelAndView mv = new ModelAndView();
		MultipartFile imgFile = multi.getFile("imgFile");
		adService.adImgUpload(adVo, imgFile);
		mv.setViewName("redirect:adList");
		
		
		return mv;
	}
	
	// 광고 신청 폼
	@RequestMapping(value="adApply", method=RequestMethod.GET)
	public ModelAndView adApply(){
		ModelAndView mv = new ModelAndView();
		List<AdPriceVo> adPrice = adService.selectAdPrice();
		mv.addObject("adPrice", adPrice);
		mv.setViewName("advertisement/adApply");
		
		return mv;
	}
	
	// 광고 신청 등록
	@RequestMapping(value="adApply", method=RequestMethod.POST)
	public ModelAndView adApply(@ModelAttribute("sessionId") String companyId,
								AdVo adVo, MultipartHttpServletRequest multi){
		ModelAndView mv = new ModelAndView();
		MultipartFile imgFile = multi.getFile("imgFile");
		adVo.setCompanyId(companyId);
		adService.adApply(adVo,imgFile);
		mv.setViewName("redirect:adApply");
		return mv;
	}
	
	// 결제 폼
	@RequestMapping(value="payAdd", method=RequestMethod.GET)
	public ModelAndView payAdd(@ModelAttribute("sessionId") String companyId,AdVo adVo){
		ModelAndView mv = new ModelAndView();
		Map<String,Object>map = adService.paymentList(companyId);
		int total = (int) map.get("total");
		mv.addObject("total",total);
		mv.addObject("paymentList",map.get("paymentList"));
		mv.setViewName("payment/payAdd");
		
		return mv;
	}
	
	// 결제
	@RequestMapping(value="paymentAd", method=RequestMethod.POST)
	public ModelAndView payment(@ModelAttribute("sessionId") String companyId,
			@RequestParam(value="total") int total,
			@RequestParam(value="adNo") int adNo){
		ModelAndView mv = new ModelAndView();
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("companyId", companyId);
		map.put("total", total);
		map.put("adNo", adNo);
		adService.paymentAd(map);
		mv.setViewName("redirect:adApplyList");
		
		
		return mv;
	}
	

	// 광고 신청 리스트
	@RequestMapping(value="adApplyList")
	public ModelAndView adAppllyList(
			@ModelAttribute("sessionId") String sessionId,
			@ModelAttribute("sessionLevel") int sessionLevel,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		LoginVo loginVo = new LoginVo();
		loginVo.setMemberId(sessionId);
		loginVo.setMemberLevel(sessionLevel);
		
		ModelAndView mv = new ModelAndView();
		Map<String,Object>map = adService.selectAdApplyList(loginVo, currentPage);
		mv.addObject("currentPage",currentPage);
		mv.addObject("adApplyList",map.get("adApplyList"));
		mv.addObject("startPage",map.get("startPage"));
		mv.addObject("pageSize",map.get("pageSize"));
		mv.addObject("endPage",map.get("endPage"));
		mv.addObject("lastPage",map.get("lastPage"));
		mv.setViewName("advertisement/adApplyList");
		
		return mv;
	}
	
	
	// 광고 결제 목록에서 삭제
	@RequestMapping(value="deleteAdApplyList")
	public ModelAndView deletePayList(@RequestParam(value="adNo") int adNo){
		ModelAndView mv = new ModelAndView();
		adService.deleteAdApplyList(adNo);
		mv.setViewName("redirect:payAdd");
		return mv;
	}
	
	// 광고할 이미지 파일 가져오기
	@RequestMapping(value="serviceAdList", method=RequestMethod.GET)
	public ModelAndView selectUseAdMain(){
		ModelAndView mv = new ModelAndView();
		// 메인 광고
		List<AdVo> mainAdList = adService.selectUseAdMain();
		mv.addObject("mainAdList",mainAdList);
		// 홈페이지 상단 광고
		List<AdVo> homeAdList = adService.selectUseAdHome();
		mv.addObject("homeAdList",homeAdList);
		// 검색 상단 광고
		List<AdVo> searchAdList = adService.selectUseAdSearch();
		mv.addObject("searchAdList",searchAdList);
		
		mv.setViewName("jsonView");
		return mv;
	}
		
}
