package com.log4h.singletontrip.board.domain;

public class BoardCateVo {
	private int boardCateCd;
	private String boardCateNm;
	public int getBoardCateCd() {
		return boardCateCd;
	}
	public void setBoardCateCd(int boardCateCd) {
		this.boardCateCd = boardCateCd;
	}
	public String getBoardCateNm() {
		return boardCateNm;
	}
	public void setBoardCateNm(String boardCateNm) {
		this.boardCateNm = boardCateNm;
	}
	@Override
	public String toString() {
		return "BoardCateVo [boardCateCd=" + boardCateCd + ", boardCateNm=" + boardCateNm + "]";
	}
	
}
