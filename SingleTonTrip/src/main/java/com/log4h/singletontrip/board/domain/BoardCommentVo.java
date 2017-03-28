package com.log4h.singletontrip.board.domain;

public class BoardCommentVo {
	private int boardCommentNo;
	private int boardNo;
	private String memberId;
	private String boardCommentContent;
	private String boardCommentRegDate;
	private String boardCommentDeleteDate;
	public int getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public String getBoardCommentRegDate() {
		return boardCommentRegDate;
	}
	public void setBoardCommentRegDate(String boardCommentRegDate) {
		this.boardCommentRegDate = boardCommentRegDate;
	}
	public String getBoardCommentDeleteDate() {
		return boardCommentDeleteDate;
	}
	public void setBoardCommentDeleteDate(String boardCommentDeleteDate) {
		this.boardCommentDeleteDate = boardCommentDeleteDate;
	}

}
