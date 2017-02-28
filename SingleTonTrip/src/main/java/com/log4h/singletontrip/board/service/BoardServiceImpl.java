package com.log4h.singletontrip.board.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;
import com.log4h.singletontrip.board.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public int faqAdd(BoardVo board, String sessionId) {
		logger.debug(" >>>>>>> faqAdd <<<<<<< ");
		board.setMemberId(sessionId);
		
		logger.debug(" >>>>>>> map 값 : {} ", board);
		int result = boardDao.faqAdd(board);
		return result;
	}

	@Override
	public List<BoardCateVo> findFaqCate() {
		logger.debug(" >>>>>>> findFaqCate <<<<<<< ");
		List<BoardCateVo> returnList = new ArrayList<BoardCateVo>();
		returnList = boardDao.findFaqCate();
		logger.debug(" >>>>>>> findFaqCate 리턴 받은 값 : {}",returnList);
		
		return returnList;
	}
	
}

