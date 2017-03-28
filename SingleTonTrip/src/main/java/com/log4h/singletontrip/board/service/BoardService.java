package com.log4h.singletontrip.board.service;

import java.util.Map;

import com.log4h.singletontrip.board.domain.BoardVo;

public interface BoardService {

	public Map<String, Object> boardList(int currentPage, int boardCateCd);
	public Map<String, Object> boardList(int currentPage, int boardCateCd, String sessionId, int sessionLevel);
	public BoardVo boardDetail(int boardNo);
	public int boardAdd(BoardVo boardVo);
	public BoardVo qnaDetail(int boardNo);
}
