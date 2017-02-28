package com.log4h.singletontrip.ad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.ad.repository.AdDao;
import com.log4h.singletontrip.member.domain.LoginVo;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	private AdDao adDao;
	
	// 광고 목록 가져오기
	@Override
	public List<AdPriceVo> selectAdPrice(){
		return adDao.selectAdPrice();
	}
	
	// 광고 신청 등록
	@Transactional
	@Override
	public int adApply(AdVo adVo){
		int paymentAddResult = 0;
		int adApplyResult = adDao.adApply(adVo);
		// 등록이 성공적으로 이루어지면 결제테이블에도 등록
		if(adApplyResult >0){
			int adNo = adVo.getAdNo();
			adDao.adApplyPayment(adNo);
		}
		return paymentAddResult;
	}
	
	// 광고 신청 리스트 가져오기
	@Override
	public List<AdVo> selectAdApplyList(LoginVo loginVo){
		return adDao.selectAdApplyList(loginVo);
	}
	
	// 광고 신청 승인
	@Override
	public int adApprove(Map<String,Object>map){
		return adDao.adApprove(map);
	}
	
	// 결제 할 목록, 목록의 합계 가져오기
	@Override
	public Map<String,Object> paymentList(String companyId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<AdVo> paymentList = adDao.paymentList(companyId);
		map.put("paymentList", paymentList);
		map.put("total", adDao.totalPrice(companyId));
		return map;
	}
	
	// 광고 신청 목록에서 삭제
	@Transactional
	@Override
	public int deleteAdApplyList(int adNo){
		int deletePay = 0;
		int deletePayAdListResult = adDao.deleteAdApplyList(adNo);
		// 광고 신청 목록에서 삭제 후 결제목록에서도 삭제
		if(deletePayAdListResult > 0){
			adDao.deletePayAdList(adNo);
		}
		return deletePay;
	}
	
	// 광고 결제
	@Override
	public int paymentAd(Map<String,Object>map){
		return adDao.paymentAd(map);
	}
}
