package com.log4h.singletontrip.mileage.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.mileage.domain.MileageVo;
import com.log4h.singletontrip.mileage.repository.MileageDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class MileageServiceImpl implements MileageService{
	private static final Logger logger = LoggerFactory.getLogger(MileageServiceImpl.class);
	
	@Autowired
	private MileageDao mileageDao;

	@Override
	public Map<String, Object> mileageList(int currentPage, String memberId) {
		logger.info("mileageList currentPage 값 {}, memberId 값 {}",currentPage,memberId );
		
		int mileageTotalCount = mileageDao.mileageTotalCount(memberId);
		logger.info(" mileageList mileageTotalCount 값 {} ",mileageTotalCount);
		
		
		
		Paging paging = new Paging();
        Map<String, Object> map = paging.pagingMethod(currentPage, mileageTotalCount);
        map.put("memberId", memberId);
        
        List<MileageVo> returnMileageList = mileageDao.mileageList(map);
        map.put("returnMileageList", returnMileageList);
		return map;
	}




	
}
