package com.log4h.singletontrip.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;
import com.log4h.singletontrip.board.repository.BoardDao;
import com.log4h.singletontrip.util.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDao boardDao;
	
	// faqAdd
	@Override
	public int faqAdd(BoardVo board, String sessionId) {
		logger.debug(" >>>>>>> faqAdd <<<<<<< ");
		board.setMemberId(sessionId);
		
		logger.debug(" >>>>>>> 받은 값 : {} ", board);
		int result = boardDao.faqAdd(board);
		return result;
	}
	
	// board cate 가져오기
	@Override
	public List<BoardCateVo> findFaqCate() {
		logger.debug(" >>>>>>> findFaqCate <<<<<<< ");
		List<BoardCateVo> returnList = new ArrayList<BoardCateVo>();
		returnList = boardDao.findFaqCate();
		logger.debug(" >>>>>>> findFaqCate 리턴 받은 값 : {}",returnList);
		
		return returnList;
	}
	
	// faqList 가져오기
	@Override
	public Map<String, Object> faqList(int currentPage, int boardCateCd) {
		logger.debug(" >>>>>>> faqList <<<<<<< ");
		
		int faqCount = boardDao.faqCount(boardCateCd);
		logger.debug(" >>>>>>> getFaqCount :{}", faqCount);
		
		Paging paging = new Paging();
		
		Map<String, Object> map = paging.pagingMethod(currentPage, faqCount);
		map.put("boardCateCd", boardCateCd);
		
		List<BoardVo> returnList = boardDao.faqList(map);
		logger.debug("faqList 리턴 값 : {} ", returnList);
		
		map.put("faqList", returnList);
		
		return map;
	}
}

