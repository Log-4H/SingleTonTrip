package com.log4h.singletontrip.mileage.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.member.domain.LoginVo;
import com.log4h.singletontrip.mileage.domain.MileageVo;

@Repository
public class MileageDaoImpl implements MileageDao{
	private static final Logger logger = LoggerFactory.getLogger(MileageDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String MILEAGE_NS = "mileageMapper.";
	
	// 리스트에 대한 총 갯수를 가져온다
	@Override
	public int mileageTotalCount(Map<String, Object> totalCountMap) {
		logger.debug(" mileageTotalCount strat . . . ");
		return sqlSession.selectOne(MILEAGE_NS+"mileageTotalCount", totalCountMap);
	}
	// 리스트 가져오기
	@Override
	public List<MileageVo> mileageList(Map<String, Object> map) {
		logger.info(" mileageList strat . . . ");
		return sqlSession.selectList(MILEAGE_NS+"mileageList", map);
	}
	
}
