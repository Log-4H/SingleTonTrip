package com.log4h.singletontrip.mileage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.mileage.domain.MileageVo;
import com.log4h.singletontrip.mileage.repository.MileageDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class MileageServiceImpl implements MileageService{
	private static final Logger logger = LoggerFactory.getLogger(MileageServiceImpl.class);
	
	@Autowired
	private MileageDao mileageDao;
	
	// 마일리지 리스트
	@Override
	public Map<String, Object> mileageList(int currentPage, LoginVo login, int selectOption, String selectValue) {
		logger.debug("\n >>>>>>> mileageList <<<<<<<");

		logger.debug("\n >>>>>>> login 값 {}", login);
		logger.debug("\n >>>>>>> selectOption 값 {} ", selectOption);
		logger.debug("\n >>>>>>> selectValue 값 {} ", selectValue);
		
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
		totalCountMap.put("login", login);
		
		// 마일리지의 행의 수를 가져온다
		int mileageTotalCount = mileageDao.mileageTotalCount(totalCountMap);
		logger.debug("\n >>>>>>> mileageList mileageTotalCount 값 {} ",mileageTotalCount);
		
		Paging paging = new Paging();
        
		Map<String, Object> map = paging.pagingMethod(currentPage, mileageTotalCount);
		map.put("selectOption", selectOption);
	    map.put("selectValue", selectValue);
	    map.put("login", login);
	    
	    // 마일리지 리스트를 가져온다
	    List<MileageVo> returnMileageList = mileageDao.mileageList(map);
	    map.put("returnMileageList", returnMileageList);
	    return map;
	}
	
}
