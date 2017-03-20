package com.log4h.singletontrip.board.service;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;

public interface BoardService {

	int faqAdd(BoardVo board, String sessionId);

	List<BoardCateVo> findFaqCate();

	Map<String, Object> faqList(int currentPage, int boardCateCd);



}
