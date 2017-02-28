package com.log4h.singletontrip.board.service;

import java.util.List;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;

public interface BoardService {

	int faqAdd(BoardVo board, String sessionId);

	List<BoardCateVo> findFaqCate();

}
