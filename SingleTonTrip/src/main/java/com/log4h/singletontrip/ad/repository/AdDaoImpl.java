package com.log4h.singletontrip.ad.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;
import com.log4h.singletontrip.member.domain.LoginVo;

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
	public List<AdVo> selectAdApplyList(LoginVo loginVo){
		return sqlSession.selectList(AD_NS+"selectAdApplyList",loginVo);
	}
	
	// 광고 신청 승인
	@Override
	public int adApprove(Map<String,Object>map){
		return sqlSession.update(AD_NS+"adApprove",map);
	}
	
	// 같은 내용의 광고가 승인 돼있는지 알아보기
	@Override
	public String selectSameAd(Map<String,Object>map){
		return sqlSession.selectOne(AD_NS+"selectSameAd",map);
	}
	
	// 광고 신청 거절
	@Override
	public int adRefuse(Map<String,Object>map){
		return sqlSession.update(AD_NS+"adRefuse",map);
	}
	
	// 거절 후 환불창
	@Override
	public List<PaymentVo> payback(){
		return sqlSession.selectList(AD_NS+"payback");
	}
	
	// 광고 이미지 등록
	@Override
	public int adImgUpload(AdVo adVo){
		return sqlSession.update(AD_NS+"adImgUpload",adVo);
	}
	
	// 광고 이미지 있는지
	@Override
	public String selectAdImg(AdVo adVo){
		return sqlSession.selectOne(AD_NS+"selectAdImg",adVo);
	}
	
	// 광고 리스트
	@Override
	public List<AdVo> selectAdList(){
		return sqlSession.selectList(AD_NS+"selectAdList");
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
	
	// 광고 신청 목록에서 삭제
	@Override
	public int deleteAdApplyList(int adNo){
		return sqlSession.delete(AD_NS+"deleteAdApplyList",adNo);
	}
	
	// 광고 신청 목록에서 삭제 후 결제목록에서도 삭제
	@Override
	public int deletePayAdList(int adNo){
		return sqlSession.delete(AD_NS+"deletePayAdList",adNo);
	}
	
	// 결제 할 목록들의 합계 구하기
	@Override
	public int totalPrice(String companyId){
		return sqlSession.selectOne(AD_NS+"totalPrice",companyId);
	}
	
	// 결제
	@Override
	public int paymentAd(Map<String,Object>map){
		return sqlSession.update(AD_NS+"paymentAd",map);
	}
	
}
