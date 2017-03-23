package com.log4h.singletontrip.post.domain;

public class PostCommentVo {
	
	private int postCommentNo;
	private String postId;
	private int postNo;
	private String memberId;
	private String memberNm;
	private String memberImg;
	private String postCommentContent;
	private String postCommentRegDate;
	public int getPostCommentNo() {
		return postCommentNo;
	}
	public void setPostCommentNo(int postCommentNo) {
		this.postCommentNo = postCommentNo;
	}
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
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	@Override
	public String toString() {
		return "PostCommentVo [postCommentNo=" + postCommentNo + ", postId=" + postId + ", postNo=" + postNo
				+ ", memberId=" + memberId + ", postCommentContent=" + postCommentContent + ", postCommentRegDate="
				+ postCommentRegDate + "]";
	}
	
	
	
}
