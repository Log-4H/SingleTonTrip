package com.log4h.singletontrip.reserve.repository;

import java.util.List;
import java.util.Map;


public interface ReserveDao {

	int reserveTotalCount(Map<String, Object> totalCountMap);

	List<Object> getReserveList(Map<String, Object> map);


}
