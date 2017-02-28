package com.log4h.singletontrip.ad.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;

@Repository
public class AdDaoImpl implements AdDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String AD_NS = "AdMapper.";
	
	// 광고 목록 가져오기
	@Override
	public List<AdPriceVo> selectAdPrice(){
		return sqlSession.selectList(AD_NS+"selectAdPrice");
	}
	
	// 광고 신청 등록
	@Override
	public int adApply(AdVo adVo){
		return sqlSession.insert(AD_NS+"adApply",adVo);
	}
	
	// 광고 신청 리스트 가져오기
	@Override
	public List<AdVo> selectAdApplyList(){
		return sqlSession.selectList(AD_NS+"selectAdApplyList");
	}
	
	// 등록이 성공적으로 이루어지면 결제테이블에도 등록
	@Override
	public int adApplyPayment(int adNo){
		return sqlSession.insert(AD_NS+"adApplyPayment",adNo);
	}
	
	// 결제 할 목록 가져오기
	@Override
	public List<AdVo> paymentList(String companyId){
		return sqlSession.selectList(AD_NS+"paymentList",companyId);
	}
	
	// 결제 할 목록들의 합계 구하기
	@Override
	public int totalPrice(String companyId){
		return sqlSession.selectOne(AD_NS+"totalPrice",companyId);
	}
	
	// 결제
	@Override
	public int payment(Map<String,Object>map){
		return sqlSession.update(AD_NS+"payment",map);
	}
	
}
