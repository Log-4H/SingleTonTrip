package com.log4h.singletontrip.board.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;

public interface BoardDao {
	// faqAdd
	int faqAdd(BoardVo board);
	
	// getfaqCate
	List<BoardCateVo> findFaqCate();
	
	// getFaqCount
	int faqCount(int boardCateCd);

	// getFaqList
	List<BoardVo> faqList(Map<String, Object> map);

}
