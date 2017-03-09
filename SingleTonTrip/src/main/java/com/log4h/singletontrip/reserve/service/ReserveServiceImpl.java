package com.log4h.singletontrip.reserve.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.reserve.domain.PaymentCateVo;
import com.log4h.singletontrip.reserve.domain.PaymentStateVo;
import com.log4h.singletontrip.reserve.repository.ReserveDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class ReserveServiceImpl implements ReserveService{
	private static Logger logger = LoggerFactory.getLogger(ReserveServiceImpl.class);
	
	@Autowired
	private ReserveDao reserveDao;
	// get reserveList 
	@Override
	public Map<String, Object> getReserveList(int currentPage, LoginVo login, int selectOption, String selectValue) {
		logger.debug(" >>>>>>> getReserveList <<<<<<< ");
		
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
		totalCountMap.put("login", login);
		logger.debug(" >>>>>>> totalCountMap에 담긴 값 \n{}   ", totalCountMap);
		
		// 예약의 행의 수를 가져온다
		int reserveTotalCount = reserveDao.reserveTotalCount(totalCountMap);
		logger.debug("\n >>>>>>> getReserveList reserveTotalCount 값 : {} ",reserveTotalCount);
		
		Paging paging = new Paging();
        
		Map<String, Object> map = paging.pagingMethod(currentPage, reserveTotalCount);
		map.put("selectOption", selectOption);
	    map.put("selectValue", selectValue);
	    map.put("login", login);
	    
	    // 예약 리스트를 가져온다
	    List<Object> returnList = reserveDao.getReserveList(map);
	    logger.debug("\n >>>>>>> getReserveList retrunMap 값 {} ",returnList);
	    map.put("returnList", returnList);
	    return map;
	}
	
	// get paymentState data
	@Override
	public List<PaymentCateVo> getPaymentCate() {
		List<PaymentCateVo> paymentCate = reserveDao.getPaymentCate();
		logger.debug("paymentCate :{}", paymentCate);
		return paymentCate;
	}

	// get payList
	@Override
	public Map<String, Object> getPayList(int currentPage, LoginVo login, int selectOption, String selectValue) {
		logger.debug(" >>>>>>> getPayList <<<<<<< ");
		
		Map<String, Object> totalCountMap = new HashMap<String, Object>();
		totalCountMap.put("selectOption", selectOption);
		totalCountMap.put("selectValue", selectValue);
		totalCountMap.put("login", login);
		logger.debug(" >>>>>>> totalCountMap에 담긴 값 \n{}   ", totalCountMap);
		
		// 행의 수를 가져온다
		int payTotalCount = reserveDao.payTotalCount(totalCountMap);
		
		return null;
	}
}
