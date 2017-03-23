package com.log4h.singletontrip.ad.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;
import com.log4h.singletontrip.member.domain.LoginVo;


public interface AdService {
	public List<AdPriceVo> selectAdPrice();
	public int adApply(AdVo adVo,MultipartFile imgFile);
	public Map<String,Object> selectAdApplyList(LoginVo loginVo,int currentPage);
	public Map<String,Object> paymentList(String companyId);
	public int paymentAd(Map<String,Object>map);
	public int deleteAdApplyList(int adNo);
	public int adApprove(Map<String,Object>map);
	public int adRefuse(Map<String,Object>map);
	public int paybackApply(int adNo);
	public int paybackCancel(int paymentTargetNo);
	public Map<String,Object> selectAdList(int currentPage);
	public int adImgUpload(AdVo adVo, MultipartFile imgFile);
	public List<PaymentVo> paybackList(LoginVo loginVo);
	public int payback(Map<String,Object>map);
	public List<AdVo> selectUseAdMain();
	public List<AdVo> selectUseAdHome();
	public List<AdVo> selectUseAdSearch();
	public List<AdVo> mainAdCount();
}
