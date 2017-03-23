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
	
	// 광고 신청 리스트 카운트 가져오기
	@Override
	public int adApplyListCount(){
		return sqlSession.selectOne(AD_NS+"adApplyListCount");
	}
	
	// 광고 신청 리스트 가져오기
	@Override
	public List<AdVo> selectAdApplyList(Map<String,Object>map){
		return sqlSession.selectList(AD_NS+"selectAdApplyList",map);
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
	
	// 광고 신청 리스트에서 환불요청
	@Override
	public int paybackApply(int adNo){
		return sqlSession.update(AD_NS+"paybackApply",adNo);
	}
	
	// 환불리스트
	@Override
	public List<PaymentVo> paybackList(LoginVo loginVo){
		return sqlSession.selectList(AD_NS+"paybackList",loginVo);
	}
	
	// 환불
	@Override
	public int payback(Map<String,Object>map){
		return sqlSession.update(AD_NS+"payback",map);
	}
	
	// 환불 취소
	@Override
	public int paybackCancel(int paymentTargetNo){
		return sqlSession.update(AD_NS+"paybackCancel",paymentTargetNo);
	}
	
	// 광고 할 이미지파일 가져오기(메인)
	@Override
	public List<AdVo> selectUseAdMain(){
		return sqlSession.selectList(AD_NS+"selectUseAdMain");
	}
	
	// 광고 할 이미지파일 가져오기(홈페이지)
	@Override
	public List<AdVo> selectUseAdHome(){
		return sqlSession.selectList(AD_NS+"selectUseAdHome");
	}
	
	// 광고 할 이미지파일 가져오기(검색상단)
	@Override
	public List<AdVo> selectUseAdSearch(){
		return sqlSession.selectList(AD_NS+"selectUseAdSearch");
	}
	
	// 메인광고 카운트(갯수) 가져오기
	@Override
	public List<AdVo> mainAdCount(){
		return sqlSession.selectList(AD_NS+"mainAdCount");
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
	
	// 광고 리스트 카운트 가져오기
	@Override
	public int adListCount(){
		return sqlSession.selectOne(AD_NS+"adListCount");
	}
	
	// 광고 리스트
	@Override
	public List<AdVo> selectAdList(Map<String,Object>map){
		return sqlSession.selectList(AD_NS+"selectAdList",map);
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
	
	// 스케줄러 - 기간 지난 광고 내리기
	@Override
	public int adDrop(){
		return sqlSession.update(AD_NS+"adDrop");
	}
	
	// 스케줄러 - 오래된 광고 목록 지우기
	@Override
	public int deleteOldAd(){
		return sqlSession.delete(AD_NS+"deleteOldAd");
	}
	
	// 스케줄러 - 오래된 결제 목록 지우기
	@Override
	public int deleteOldPayment(){
		return sqlSession.delete(AD_NS+"deleteOldPayment");
	}
	
	// 스케줄러 - 등록만 하고 결제를 안한 항목은 7일 뒤 삭제
	@Override
	public int deleteNotPayment(){
		return sqlSession.delete(AD_NS+"deleteNotPayment");
	}
	
	// 스케줄러 - 결제 테이블에서 결제 안한 목록 지워진게 있으면 tb_ad 데이터도 삭제 
	@Override
	public int deleteNotPaymentAd(){
		return sqlSession.delete(AD_NS+"deleteNotPaymentAd");
	}
	
}
