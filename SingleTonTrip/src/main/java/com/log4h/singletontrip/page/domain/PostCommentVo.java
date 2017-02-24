package com.log4h.singletontrip.page.domain;

public class PostCommentVo {
	
	private String postId;
	private int postNo;
	private String memberId;
	private String postCommentContent;
	private String postCommentRegDate;
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPostCommentContent() {
		return postCommentContent;
	}
	public void setPostCommentContent(String postCommentContent) {
		this.postCommentContent = postCommentContent;
	}
	public String getPostCommentRegDate() {
		return postCommentRegDate;
	}
	public void setPostCommentRegDate(String postCommentRegDate) {
		this.postCommentRegDate = postCommentRegDate;
	}
	
	@Override
	public String toString() {
		return "PostCommentVo [postId=" + postId + ", postNo=" + postNo + ", memberId=" + memberId
				+ ", postCommentContent=" + postCommentContent + ", postcommentRegDate=" + postCommentRegDate + "]";
	}

}
