package com.log4h.singletontrip.page.repository;

import java.util.List;

import com.log4h.singletontrip.page.domain.PostVo;

public interface PageDao {
	//포스트리스트
	public List<PostVo> postList(String memberId);
	//포스트 등록
	public int postInsert(PostVo postVo);
}
