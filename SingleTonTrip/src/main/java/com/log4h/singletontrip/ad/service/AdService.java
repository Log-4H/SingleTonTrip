package com.log4h.singletontrip.ad.service;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;


public interface AdService {
	public List<AdPriceVo> selectAdPrice();
	public int adApply(AdVo adVo);
	public List<AdVo> selectAdApplyList();
	public Map<String,Object> paymentList(String companyId);
	public int payment(Map<String,Object>map);
}
