package com.log4h.singletontrip.ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.ad.service.AdService;

@Controller
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
	
	@RequestMapping(value="adAdd")
	public ModelAndView adAdd(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("advertisement/adAdd");
		
		return mv;
	}
	
	// 광고 신청 리스트
	@RequestMapping(value="adApplyList")
	public ModelAndView adAppllyList(){
		ModelAndView mv = new ModelAndView();
		List<AdVo> adApplyList = adService.selectAdApplyList();
		mv.addObject("adApplyList",adApplyList);
		mv.setViewName("advertisement/adApplyList");
		
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
	public ModelAndView adApply(HttpServletRequest request,AdVo adVo){
		ModelAndView mv = new ModelAndView();
		String companyId = (String) request.getSession().getAttribute("sessionId");
		adVo.setCompanyId(companyId);
		adService.adApply(adVo);
		mv.setViewName("redirect:payAdd");
		return mv;
	}
	
	// 결제 폼
	@RequestMapping(value="payAdd", method=RequestMethod.GET)
	public ModelAndView payAdd(HttpServletRequest request,AdVo adVo){
		ModelAndView mv = new ModelAndView();
		String companyId = (String) request.getSession().getAttribute("sessionId");
		Map<String,Object>map = adService.paymentList(companyId);
		mv.addObject("total",map.get("total"));
		mv.addObject("paymentList",map.get("paymentList"));
		mv.setViewName("payment/payAdd");
		
		return mv;
	}
}
