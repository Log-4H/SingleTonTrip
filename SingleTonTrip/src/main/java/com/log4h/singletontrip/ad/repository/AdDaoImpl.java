package com.log4h.singletontrip.ad.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;

@Repository
public class AdDaoImpl implements AdDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String AD_NS = "com.log4h.singletontrip.ad.repository.AdMapper.";
	
	@Override
	public List<AdPriceVo> selectAdPrice(){
		return sqlSession.selectList(AD_NS+"selectAdPrice");
	}
	
	@Override
	public int adApply(AdVo adVo){
		return sqlSession.insert(AD_NS+"adApply",adVo);
	}
	
	@Override
	public List<AdVo> selectAdApplyList(){
		return sqlSession.selectList(AD_NS+"selectAdApplyList");
	}
	
}
