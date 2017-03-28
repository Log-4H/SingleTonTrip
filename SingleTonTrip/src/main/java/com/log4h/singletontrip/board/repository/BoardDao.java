package com.log4h.singletontrip.board.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.board.domain.BoardCommentVo;
import com.log4h.singletontrip.board.domain.BoardVo;

public interface BoardDao {
	
	public int boardTotalCount(Map<String, Object> map);
	public List<BoardVo> boardList(Map<String, Object> map);
	public BoardVo boardDetail(Map<String, Object> map);
	public int boardInsert(BoardVo boardVo);
	public List<BoardCommentVo> boardCommentList(int boardNo);	

}
