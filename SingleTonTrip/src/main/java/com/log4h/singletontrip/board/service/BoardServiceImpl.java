package com.log4h.singletontrip.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.board.domain.BoardVo;
import com.log4h.singletontrip.board.repository.BoardDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public Map<String, Object> boardList(int currentPage, int boardCateCd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardCateCd", boardCateCd);
		int boardTotalCount = boardDao.boardTotalCount(map);
		Paging paging = new Paging();
		map = paging.pagingMethod(currentPage, boardTotalCount);
		map.put("boardCateCd", boardCateCd);
		List<BoardVo> boardList = boardDao.boardList(map);
		map.put("boardList", boardList);
		return map;
	}

	@Override
	public BoardVo boardDetail(int boardNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardNo", boardNo);
		return boardDao.boardDetail(map);
	}

	@Override
	public int boardAdd(BoardVo boardVo) {
		return boardDao.boardInsert(boardVo);
	}
}

