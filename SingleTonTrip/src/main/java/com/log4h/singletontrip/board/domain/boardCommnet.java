package com.log4h.singletontrip.board.domain;

public class boardCommnet {
	private int boardCommentNo;
	private BoardVo board;
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
	public BoardVo getBoard() {
		return board;
	}
	public void setBoard(BoardVo board) {
		this.board = board;
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
	@Override
	public String toString() {
		return "boardCommnet [boardCommentNo=" + boardCommentNo + ", board=" + board + ", memberId=" + memberId
				+ ", boardCommentContent=" + boardCommentContent + ", boardCommentRegDate=" + boardCommentRegDate
				+ ", boardCommentDeleteDate=" + boardCommentDeleteDate + "]";
	}
	
	
	
	
}
