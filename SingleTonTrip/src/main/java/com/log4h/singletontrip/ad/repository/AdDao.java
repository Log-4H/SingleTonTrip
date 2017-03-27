package com.log4h.singletontrip.ad.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;

public interface AdDao {

	// 광고 단가 목록 가져오기
	public List<AdPriceVo> selectAdPrice();
	// 광고 신청
	public int adApply(AdVo adVo);
	// 광고 신청 리스트 가져오기
	public List<AdVo> selectAdApplyList(Map<String,Object>map);
	// 등록이 성공적으로 이루어지면 결제테이블에도 등록
	public int adApplyPayment(int adNo);
	// 결제 할 목록 가져오기
	public List<AdVo> paymentList(String companyId);
	// 결제 목록의 합계 구하기
	public int totalPrice(String companyId);
	// 결제
	public int paymentAd(Map<String,Object>map);
	// 광고 신청 취소
	public int deleteAdApplyList(int adNo);
	// 결제 창에서 신청목록 삭제
	public int deletePayAdList(int adNo);
	// 광고 신청 승인
	public int adApprove(Map<String,Object>map);
	// 광고 신청 거절
	public int adRefuse(Map<String,Object>map);
	// 환불 요청
	public int paybackApply(int adNo);
	// 환불 취소
	public int paybackCancel(int paymentTargetNo);
	// 광고 리스트 가져오기
	public List<AdVo> selectAdList(Map<String,Object>map);
	// 이미지 업로드
	public int adImgUpload(AdVo adVo);
	// 광고 이미지 가져오기
	public String selectAdImg(AdVo adVo);
	// 같은 내용의 광고 있는지 알아보기
	public String selectSameAd(Map<String,Object>map);
	// 환불 리스트
	public List<PaymentVo> paybackList(Map<String,Object>map);
	// 환불
	public int payback(Map<String,Object>map);
	// 스케줄러 - 기간 지난 광고 내리기
	public int adDrop();
	// 스케줄러 - 오래된 광고 목록 지우기
	public int deleteOldAd();
	// 스케줄러 - 오래된 결제 목록 지우기
	public int deleteOldPayment();
	// 스케줄러 - 등록만 하고 결제를 안한 항목은 7일 뒤 삭제
	public int deleteNotPayment();
	// 스케줄러 - 결제 테이블에서 결제 안한 목록 지워진게 있으면 tb_ad 데이터도 삭제 
	public int deleteNotPaymentAd();
	// 광고 할 이미지파일 가져오기(메인)
	public List<AdVo> selectUseAdMain();
	// 광고 할 이미지파일 가져오기(홈페이지)
	public List<AdVo> selectUseAdHome();
	// 광고 할 이미지파일 가져오기(검색상단)
	public List<AdVo> selectUseAdSearch();
	// 메인광고 카운트(갯수) 가져오기
	public List<AdVo> mainAdCount();
	// 광고 신청 리스트 카운트 가져오기
	public int adApplyListCount();
	// 광고 리스트 카운트 가져오기
	public int adListCount(LoginVo loginVo);
	// 환불리스트 카운트
	public int paybackListCount(LoginVo loginVo);
}
