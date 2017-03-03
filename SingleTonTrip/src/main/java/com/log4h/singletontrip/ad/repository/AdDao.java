package com.log4h.singletontrip.ad.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.member.domain.LoginVo;

public interface AdDao {

	public List<AdPriceVo> selectAdPrice();
	public int adApply(AdVo adVo);
	public List<AdVo> selectAdApplyList(LoginVo loginVo);
	public int adApplyPayment(int adNo);
	public List<AdVo> paymentList(String companyId);
	public int totalPrice(String companyId);
	public int paymentAd(Map<String,Object>map);
	public int deleteAdApplyList(int adNo);
	public int deletePayAdList(int adNo);
	public int adApprove(Map<String,Object>map);
	public int adRefuse(Map<String,Object>map);
	public List<AdVo> selectAdList();
	public int adImgUpload(AdVo adVo);
	public String selectAdImg(AdVo adVo);
}
