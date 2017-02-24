package com.log4h.singletontrip.page.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.page.domain.PostCommentVo;
import com.log4h.singletontrip.page.domain.PostVo;

public interface PageDao {
	//포스트리스트
	public List<PostVo> postList(Map<String, Object> map);
	//포스트 등록
	public int postInsert(PostVo postVo);
	//포스트 댓글리스트
	public List<PostCommentVo> postCommentList(Map<String, Object> map);
	//포스트 댓글 등록
	public int postCommentInsert(PostCommentVo postCommentVo);
}
