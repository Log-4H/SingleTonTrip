package com.log4h.singletontrip.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao{
	private static Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String BOARD_NS = "boardMapper.";

	@Override
	public int faqAdd(BoardVo board) {
		return sqlSession.insert(BOARD_NS+"faqAdd",board);
	}

	@Override
	public List<BoardCateVo> findFaqCate() {
		return sqlSession.selectList(BOARD_NS+"findFaqCate");
	}
}
