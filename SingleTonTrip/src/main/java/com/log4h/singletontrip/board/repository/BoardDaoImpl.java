package com.log4h.singletontrip.board.repository;

import java.util.List;
import java.util.Map;

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

	// faqAdd 
	@Override
	public int faqAdd(BoardVo board) {
		return sqlSession.insert(BOARD_NS+"faqAdd",board);
	}

	// faqCate 가져오기
	@Override
	public List<BoardCateVo> findFaqCate() {
		return sqlSession.selectList(BOARD_NS+"findFaqCate");
	}
	
	// faq 전체행의 수를 가져온다
	@Override
	public int faqCount(int boardCateCd) {
		return sqlSession.selectOne(BOARD_NS+"faqCount", boardCateCd);
	}
	
	// faqList를 가져온다
	@Override
	public List<BoardVo> faqList(Map<String, Object> map) {
		return sqlSession.selectList(BOARD_NS+"faqList",map);
	}
}
