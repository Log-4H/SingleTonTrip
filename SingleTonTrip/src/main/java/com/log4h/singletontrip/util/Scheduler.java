package com.log4h.singletontrip.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.log4h.singletontrip.ad.repository.AdDao;

@Component
public class Scheduler {
	@Autowired
	AdDao adDao;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void schedule(){
		System.out.println("=======SCHEDULER START=======");
        try {
        	adDao.adDrop();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
