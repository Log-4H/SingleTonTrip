package com.log4h.singletontrip.page.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.page.domain.PostCommentVo;
import com.log4h.singletontrip.page.domain.PostVo;

public interface PageService {
	//포스트&댓글 리스트
	public Map<String, Object> postList(String memberId, int beginRow);
	//포스트 등록
	public int postAdd(PostVo postVo, MultipartFile imgFile);
	//댓글 등록
	public List<PostCommentVo> postCommentAdd(int postNo, String memberId, String postCommentContent);
}
