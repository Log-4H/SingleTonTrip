package com.log4h.singletontrip.board.repository;

import java.util.List;

import com.log4h.singletontrip.board.domain.BoardCateVo;
import com.log4h.singletontrip.board.domain.BoardVo;

public interface BoardDao {

	int faqAdd(BoardVo board);

	List<BoardCateVo> findFaqCate();

}
