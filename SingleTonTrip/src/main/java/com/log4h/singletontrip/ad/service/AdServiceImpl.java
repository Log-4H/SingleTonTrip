package com.log4h.singletontrip.ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.ad.repository.AdDao;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	private AdDao adDao;
	
	@Override
	public List<AdPriceVo> selectAdPrice(){
		return adDao.selectAdPrice();
	}
	
	@Override
	public int adApply(AdVo adVo){
		return adDao.adApply(adVo);
	}
	
	@Override
	public List<AdVo> selectAdApplyList(){
		return adDao.selectAdApplyList();
	}
}
