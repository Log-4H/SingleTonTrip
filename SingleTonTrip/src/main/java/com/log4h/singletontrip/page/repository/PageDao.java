package com.log4h.singletontrip.page.repository;

import java.util.List;
import java.util.Map;

import com.log4h.singletontrip.page.domain.PostVo;

public interface PageDao {
	//포스트리스트
	public List<PostVo> postList(Map<String, Object> map);
	//포스트 등록
	public int postInsert(PostVo postVo);
}
