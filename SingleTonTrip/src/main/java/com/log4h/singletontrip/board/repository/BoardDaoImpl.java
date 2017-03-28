package com.log4h.singletontrip.board.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.board.domain.BoardCommentVo;
import com.log4h.singletontrip.board.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao{
	private static Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String BOARD_NS = "boardMapper.";

	@Override
	public int boardTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(BOARD_NS+"boardTotalCount", map);
	}
	@Override
	public List<BoardVo> boardList(Map<String, Object> map) {
		return sqlSession.selectList(BOARD_NS+"boardList",map);
	}
	@Override
	public BoardVo boardDetail(Map<String, Object> map) {
		return sqlSession.selectOne(BOARD_NS+"boardList",map);
	}
	@Override
	public int boardInsert(BoardVo boardVo) {
		return sqlSession.insert(BOARD_NS+"boardInsert", boardVo);
	}
	@Override
	public List<BoardCommentVo> boardCommentList(int boardNo) {
		return sqlSession.selectList(BOARD_NS+"boardCommentList", boardNo);
	}
}
