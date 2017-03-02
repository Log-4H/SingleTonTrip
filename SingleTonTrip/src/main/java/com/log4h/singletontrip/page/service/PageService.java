package com.log4h.singletontrip.page.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.page.domain.PostCommentVo;
import com.log4h.singletontrip.page.domain.PostVo;

public interface PageService {
	//포스트 리스트
	public List<PostVo> postList(String memberId, int lastPostRow);
	//포스트 등록
	public int postAdd(PostVo postVo, MultipartFile imgFile);
	//포스트 보기
	public PostVo postView(int postNo);
	//댓글 리스트
	public List<PostCommentVo> postCommentList(int postNo, String memberId, int lastCommentRow);
	//댓글 등록
	public int postCommentAdd(int postNo, String memberId, String postCommentContent);
	//포스트 댓글 삭제
	public int postcommentDelete(int postCommentNo);
	//포스트 업데이트
	public int postModify(int postNo, String postTitle, String postContent, MultipartFile imgFile);
	//포스트 삭제
	public int postDelete(int postNo);
	
}
