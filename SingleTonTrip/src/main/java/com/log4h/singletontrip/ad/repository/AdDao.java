package com.log4h.singletontrip.ad.repository;

import java.util.List;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;

public interface AdDao {

	public List<AdPriceVo> selectAdPrice();
	public int adApply(AdVo adVo);
	public List<AdVo> selectAdApplyList();
	public int adApplyPayment(int adNo);
	public List<AdVo> paymentList(String companyId);
	public int totalPrice(String companyId);
}
