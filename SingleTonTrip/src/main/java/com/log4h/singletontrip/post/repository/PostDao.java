package com.log4h.singletontrip.post.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.post.domain.PostCommentVo;
import com.log4h.singletontrip.post.domain.PostVo;

public interface PostDao {
	//페이지레벨
	public String pageLevel(String pageId);
	//포스트리스트
	public List<PostVo> postList(Map<String, Object> map);
	//포스트 등록
	public int postInsert(PostVo postVo);
	//포스트 댓글리스트
	public List<PostCommentVo> postCommentList(Map<String, Object> map);
	//포스트 댓글 등록
	public int postCommentInsert(PostCommentVo postCommentVo);
	//포스트 댓글 삭제
	public int postCommentDelete(int postCommentNo);
	//포스트 보기
	public PostVo postView(int postNo);
	//포스트 업데이트
	public int postUpdate(PostVo postVo);
	//포스트 삭제
	public int postDelete(int postNo);
}
