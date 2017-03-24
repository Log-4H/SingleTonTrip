package com.log4h.singletontrip.ad.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;

public interface AdDao {

	public List<AdPriceVo> selectAdPrice();
	public int adApply(AdVo adVo);
	public List<AdVo> selectAdApplyList(Map<String,Object>map);
	public int adApplyPayment(int adNo);
	public List<AdVo> paymentList(String companyId);
	public int totalPrice(String companyId);
	public int paymentAd(Map<String,Object>map);
	public int deleteAdApplyList(int adNo);
	public int deletePayAdList(int adNo);
	public int adApprove(Map<String,Object>map);
	public int adRefuse(Map<String,Object>map);
	public int paybackApply(int adNo);
	public int paybackCancel(int paymentTargetNo);
	public List<AdVo> selectAdList(Map<String,Object>map);
	public int adImgUpload(AdVo adVo);
	public String selectAdImg(AdVo adVo);
	public String selectSameAd(Map<String,Object>map);
	public List<PaymentVo> paybackList(Map<String,Object>map);
	public int payback(Map<String,Object>map);
	public int adDrop();
	public int deleteOldAd();
	public int deleteOldPayment();
	public int deleteNotPayment();
	public int deleteNotPaymentAd();
	public List<AdVo> selectUseAdMain();
	public List<AdVo> selectUseAdHome();
	public List<AdVo> selectUseAdSearch();
	public List<AdVo> mainAdCount();
	public int adApplyListCount();
	public int adListCount(LoginVo loginVo);
	public int paybackListCount(LoginVo loginVo);
}
