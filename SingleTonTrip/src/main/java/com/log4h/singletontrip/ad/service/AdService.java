package com.log4h.singletontrip.ad.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.member.domain.LoginVo;


public interface AdService {
	// 광고 단가 목록 가져오기
	public List<AdPriceVo> selectAdPrice();
	// 광고 신청 등록
	public int adApply(AdVo adVo,MultipartFile imgFile);
	// 광고 신청 리스트 가져오기
	public Map<String,Object> selectAdApplyList(LoginVo loginVo,int currentPage);
	// 결제 할 목록 가져오기
	public Map<String,Object> paymentList(String companyId);
	// 광고 결제
	public int paymentAd(Map<String,Object>map);
	// 광고 신청 목록에서 삭제
	public int deleteAdApplyList(int adNo);
	// 광고 신청 승인
	public int adApprove(Map<String,Object>map);
	// 광고 신청 거절
	public int adRefuse(Map<String,Object>map);
	// 환불 신청
	public int paybackApply(int adNo);
	// 환불신청 취소
	public int paybackCancel(int paymentTargetNo);
	// 광고 리스트 가져오기
	public Map<String,Object> selectAdList(LoginVo loginVo,int currentPage);
	// 이미지파일 업로드
	public int adImgUpload(AdVo adVo, MultipartFile imgFile);
	// 환불 리스트
	public Map<String,Object> paybackList(LoginVo loginVo,int currentpage);
	// 환불
	public int payback(Map<String,Object>map);
	// 광고 할 이미지파일 가져오기(메인)
	public List<AdVo> selectUseAdMain();
	// 광고 할 이미지파일 가져오기(홈페이지)
	public List<AdVo> selectUseAdHome();
	// 광고 할 이미지파일 가져오기(검색상단)
	public List<AdVo> selectUseAdSearch();
	// 메인 광고 갯수 가져오기
	public List<AdVo> mainAdCount();
}
