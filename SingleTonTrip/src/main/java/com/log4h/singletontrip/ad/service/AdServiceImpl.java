package com.log4h.singletontrip.ad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.ad.domain.AdPriceVo;
import com.log4h.singletontrip.ad.domain.AdVo;
import com.log4h.singletontrip.ad.repository.AdDao;
import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentVo;
import com.log4h.singletontrip.util.ImageUpload;
import com.log4h.singletontrip.util.Paging;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	private AdDao adDao;
	
	// 광고 목록 가져오기
	@Override
	public List<AdPriceVo> selectAdPrice(){
		return adDao.selectAdPrice();
	}
	
	// 광고 신청 등록
	@Transactional
	@Override
	public int adApply(AdVo adVo, MultipartFile imgFile){
		int paymentAddResult = 0;
		ImageUpload imageUpload = new ImageUpload();
		String adImg = imageUpload.uploadImage(imgFile);
		adVo.setAdImg(adImg);
		int adApplyResult = adDao.adApply(adVo);
		// 등록이 성공적으로 이루어지면 결제테이블에도 등록
		if(adApplyResult >0){
			int adNo = adVo.getAdNo();
			adDao.adApplyPayment(adNo);
		}
		return paymentAddResult;
	}
	
	// 광고 신청 리스트 가져오기
	@Override
	public Map<String,Object> selectAdApplyList(LoginVo loginVo,int currentPage){
		Paging paging = new Paging();
		int totalCount = adDao.adApplyListCount();
		Map<String,Object> map = paging.pagingMethod(currentPage, totalCount);
		map.put("beginRow", map.get("beginRow"));
		map.put("pagePerRow", map.get("pagePerRow"));
		map.put("memberId", loginVo.getMemberId());
		map.put("memberLevel", loginVo.getMemberLevel());
		List<AdVo> adApplyList = adDao.selectAdApplyList(map);
		map.put("adApplyList", adApplyList);
		
		return map;
	}
	
	// 광고 리스트
	@Override
	public Map<String,Object> selectAdList(LoginVo loginVo,int currentPage){
		Paging paging = new Paging();
		int totalCount = adDao.adListCount(loginVo);
		Map<String,Object> map = paging.pagingMethod(currentPage, totalCount);
		map.put("beginRow", map.get("beginRow"));
		map.put("pagePerRow", map.get("pagePerRow"));
		map.put("memberId", loginVo.getMemberId());
		map.put("memberLevel", loginVo.getMemberLevel());
		List<AdVo> adList = adDao.selectAdList(map);
		map.put("adList", adList);
		
		return map;
	}
	
	// 광고 신청 승인
	@Override
	public int adApprove(Map<String,Object>map){
		int adApproveResult = 0;
		String selectSameAd = adDao.selectSameAd(map);
		if(selectSameAd != null){
			map.put("selectSameAd", selectSameAd);
			adDao.adApprove(map);
		} else {
			adDao.adApprove(map);
		}
		return adApproveResult;
	}
	
	// 광고 신청 거절
	@Override
	public int adRefuse(Map<String,Object>map){
		return adDao.adRefuse(map);
	}
	
	// 광고 신청 목록에서 환불요청
	@Override
	public int paybackApply(int adNo){
		return adDao.paybackApply(adNo);
	}
	
	// 환불 리스트
	@Override
	public Map<String,Object> paybackList(LoginVo loginVo,int currentPage){
		Paging paging = new Paging();
		int totalCount = adDao.paybackListCount(loginVo);
		Map<String,Object> map = paging.pagingMethod(currentPage, totalCount);
		map.put("beginRow", map.get("beginRow"));
		map.put("pagePerRow", map.get("pagePerRow"));
		map.put("memberId", loginVo.getMemberId());
		map.put("memberLevel", loginVo.getMemberLevel());
		List<PaymentVo> paybackList = adDao.paybackList(map);
		map.put("paybackList", paybackList);
		
		return map;
	}
	
	// 환불
	@Override
	public int payback(Map<String,Object>map){
		return adDao.payback(map);
	}
	
	// 환불 취소
	@Override
	public int paybackCancel(int paymentTargetNo){
		return adDao.paybackCancel(paymentTargetNo);
	}
	
	// 광고 이미지 등록(수정)
	@Override
	public int adImgUpload(AdVo adVo, MultipartFile imgFile){
		ImageUpload imageUpload = new ImageUpload();
		String adImg = imageUpload.uploadImage(imgFile);
		String beforeImg = adDao.selectAdImg(adVo);
		if(beforeImg == null && adImg != null){
			adVo.setAdImg(adImg);
		} else if (beforeImg != null && adImg != null || adImg == null && adImg == ""){
			imageUpload.deleteImage(beforeImg);
			adVo.setAdImg(adImg);
		}
		return adDao.adImgUpload(adVo);
	}
	
	// 결제 할 목록, 목록의 합계 가져오기
	@Override
	public Map<String,Object> paymentList(String companyId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<AdVo> paymentList = adDao.paymentList(companyId);
		map.put("paymentList", paymentList);
		map.put("total", adDao.totalPrice(companyId));
		return map;
	}
	
	// 광고 신청 목록에서 삭제
	@Transactional
	@Override
	public int deleteAdApplyList(int adNo){
		int deletePay = 0;
		int deletePayAdListResult = adDao.deleteAdApplyList(adNo);
		// 광고 신청 목록에서 삭제 후 결제목록에서도 삭제
		if(deletePayAdListResult > 0){
			adDao.deletePayAdList(adNo);
		}
		return deletePay;
	}
	
	// 광고 결제
	@Override
	public int paymentAd(Map<String,Object>map){
		return adDao.paymentAd(map);
	}
	
	// 광고 할 이미지파일 가져오기(메인)
	@Override
	public List<AdVo> selectUseAdMain(){
		return adDao.selectUseAdMain();
	}
	
	// 광고 할 이미지파일 가져오기(홈페이지)
	@Override
	public List<AdVo> selectUseAdHome(){
		return adDao.selectUseAdHome();
	}
	
	// 광고 할 이미지파일 가져오기(검색상단)
	@Override
	public List<AdVo> selectUseAdSearch(){
		return adDao.selectUseAdSearch();
	}
	
	// 메인광고 카운트(갯수) 가져오기
	@Override
	public List<AdVo> mainAdCount(){
		return adDao.mainAdCount();
	}
}
