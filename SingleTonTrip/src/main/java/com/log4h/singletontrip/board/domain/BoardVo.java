package com.log4h.singletontrip.board.domain;

public class BoardVo {
	private int boardNo;
	private String memberId;
	private BoardCateVo boardCate;
	private String boardTitle;
	private String boardContent;
	private String boardRegDate;
	private String boardModifyDate;
	private String boardDeleteDate;
	private String boardViewCount;
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
	public BoardCateVo getBoardCate() {
		return boardCate;
	}
	public void setBoardCate(BoardCateVo boardCate) {
		this.boardCate = boardCate;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public String getBoardModifyDate() {
		return boardModifyDate;
	}
	public void setBoardModifyDate(String boardModifyDate) {
		this.boardModifyDate = boardModifyDate;
	}
	public String getBoardDeleteDate() {
		return boardDeleteDate;
	}
	public void setBoardDeleteDate(String boardDeleteDate) {
		this.boardDeleteDate = boardDeleteDate;
	}
	public String getBoardViewCount() {
		return boardViewCount;
	}
	public void setBoardViewCount(String boardViewCount) {
		this.boardViewCount = boardViewCount;
	}
	@Override
	public String toString() {
		return "EmptyVo [boardNo=" + boardNo + ", memberId=" + memberId + ", boardCate=" + boardCate + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardRegDate=" + boardRegDate
				+ ", boardModifyDate=" + boardModifyDate + ", boardDeleteDate=" + boardDeleteDate + ", boardViewCount="
				+ boardViewCount + "]";
	}
}
