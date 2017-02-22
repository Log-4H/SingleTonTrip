package com.log4h.singletontrip.mileage.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.mileage.domain.MileageVo;

public interface MileageDao {

	int mileageTotalCount(String memberId);

	List<MileageVo> mileageList(Map<String, Object> map);


}
