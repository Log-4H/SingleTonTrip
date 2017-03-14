package com.log4h.singletontrip.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.log4h.singletontrip.ad.repository.AdDao;
import com.log4h.singletontrip.trip.service.TripService;

@Component
public class Scheduler {
	@Autowired
	private AdDao adDao;
	@Autowired
	private TripService tripService;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void schedule(){
		System.out.println("=======SCHEDULER START=======");
        try {
        	//*********************** 광고 ***************************
        	// 기간 지난 광고 내리기
        	adDao.adDrop();
        	// 광고 테이블 광고 끝난시점 부터 2년 지난 데이터 지우기
        	adDao.deleteOldAd();
        	// 결제 테이블 결제일로부터 5년 지난 데이터 지우기
        	adDao.deleteOldPayment();
        	// 등록만 하고 결제를 안한 데이터는 7일 뒤에 지워짐(결제 테이블)
        	int deleteNotPayment = adDao.deleteNotPayment();
        	// 결제 테이블에서 결제 안한 목록 지워진게 있으면 tb_ad 데이터도 삭제
        	if(deleteNotPayment>0){
        		adDao.deleteNotPaymentAd();
        	}
        	//*********************** 여행 ***************************
        	//모집종료일되면 삭제
        	tripService.recruitEnd();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
